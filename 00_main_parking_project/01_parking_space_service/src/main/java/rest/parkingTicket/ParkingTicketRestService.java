package rest.parkingTicket;

import dao.ParkingSpotDAO;
import dao.ParkingTicketDAO;
import dao.TicketTypeDAO;
import domain.ParkingTicketStatus;
import dto.ParkingSpotDTO;
import dto.ParkingTicketDTO;
import dto.TicketTypeDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Path("/parking-tickets")
public class ParkingTicketRestService {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getParkingTickets() {
        List<ParkingTicketDTO> parkingTickets = ParkingTicketDAO.getInstance().getItems();
        return Response.ok().entity(parkingTickets).build();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getParkingTicketById(@PathParam("id") Integer id) {
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
            return Response.ok().entity(updatedParkingTicket).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/report")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getParkingTicketsReport(@QueryParam("from") String from, @QueryParam("to") String to,
                                            @QueryParam("limit") Integer limit,  @QueryParam("offset") Integer offset) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime fromDateTime = LocalDateTime.parse(from, formatter);
        LocalDateTime toDateTime = LocalDateTime.parse(to, formatter);
        List<ParkingTicketDTO> parkingTickets = ParkingTicketDAO.getInstance()
                .findTicketsFromTimePeriod(fromDateTime, toDateTime, limit, offset);
        return Response.ok().entity(parkingTickets).build();
    }
}
