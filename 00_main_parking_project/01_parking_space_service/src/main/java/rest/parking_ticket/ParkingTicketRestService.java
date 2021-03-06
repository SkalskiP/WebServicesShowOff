package rest.parking_ticket;

import dao.EmployeeDAO;
import dao.ParkingSpotDAO;
import dao.ParkingTicketDAO;
import dao.TicketTypeDAO;
import domain.ParkingTicketStatus;
import dto.EmployeeDTO;
import dto.ParkingSpotDTO;
import dto.ParkingTicketDTO;
import dto.TicketTypeDTO;
import jms.NotificationMessageSource;
import timer_guard.ParkingTicketGuard;
import verification.Identity;
import verification.UserVerificator;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Path("/parking-tickets")
public class ParkingTicketRestService {

    // This is hack! Don't change!
    @EJB
    private NotificationMessageSource messageSource;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getParkingTickets(@HeaderParam("Authorization") String token) {
        if (token == null || !UserVerificator.validateIdToken(token).getVerificationStatus()) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        List<ParkingTicketDTO> parkingTickets = ParkingTicketDAO.getInstance().getItems();
        return Response.ok().entity(parkingTickets).build();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getParkingTicketById(@PathParam("id") Integer id, @HeaderParam("Authorization") String token) {
        if (token == null || !UserVerificator.validateIdToken(token).getVerificationStatus()) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        ParkingTicketDTO parkingTicket = ParkingTicketDAO.getInstance().getItem(id);
        return Response.ok().entity(parkingTicket).build();
    }

    @POST
    @Path("/buy")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response buyTicketForParkingSpotById(TicketPurchaseData ticketPurchaseData) {
        try {
            ParkingSpotDTO parkingSpot = ParkingSpotDAO.getInstance().getItem(ticketPurchaseData.parkingSpotId);
            TicketTypeDTO ticketType = TicketTypeDAO.getInstance().getItem(ticketPurchaseData.ticketTypeId);
            LocalDateTime currentTime = LocalDateTime.now();
            ParkingTicketDTO parkingTicket = ParkingTicketDAO.getInstance().findActiveTicketForSpot(parkingSpot);
            parkingTicket.setTicketType(ticketType);
            parkingTicket.setStatus(ParkingTicketStatus.PAID);
            parkingTicket.setPaymentTime(currentTime);
            parkingTicket.setExpiryTime(currentTime.plusMinutes(ticketType.getDurationMinutes()));
            ParkingTicketDTO updatedParkingTicket = ParkingTicketDAO.getInstance().updateItem(parkingTicket);
            ParkingTicketGuard.getInstance().scheduleValidation(parkingTicket.getId(), parkingSpot.getTriggerEventUuid(), ticketType.getDurationMinutes(), messageSource);
            return Response.ok().entity(updatedParkingTicket).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/report")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getParkingTicketsReport(@QueryParam("from") String from, @QueryParam("to") String to,
                                            @QueryParam("limit") Integer limit, @QueryParam("offset") Integer offset, @HeaderParam("Authorization") String token) {
        Identity identity = UserVerificator.validateIdToken(token);
        if (token == null || !identity.getVerificationStatus()) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime fromDateTime = LocalDateTime.parse(from, formatter);
        LocalDateTime toDateTime = LocalDateTime.parse(to, formatter);
        if (identity.isAdmin()) {
            List<ParkingTicketDTO> parkingTicketsData = ParkingTicketDAO.getInstance()
                    .findTicketsFromTimePeriod(fromDateTime, toDateTime, limit, offset);
            Long parkingTicketCount = ParkingTicketDAO.getInstance()
                    .findTicketsFromTimePeriodCount(fromDateTime, toDateTime);
            return Response.ok().entity(new TicketReportData(parkingTicketsData, parkingTicketCount)).build();
        } else {
            EmployeeDTO employee = EmployeeDAO.getInstance().getByFirebaseUid(identity.getUid());
            List<ParkingTicketDTO> parkingTicketsData = ParkingTicketDAO.getInstance()
                    .findTicketsForUserFromTimePeriod(employee.getId(), fromDateTime, toDateTime, limit, offset);
            Long parkingTicketCount = ParkingTicketDAO.getInstance()
                    .findTicketsForUserFromTimePeriodCount(employee.getId(), fromDateTime, toDateTime);
            return Response.ok().entity(new TicketReportData(parkingTicketsData, parkingTicketCount)).build();
        }
    }
}
