package rest.services;

import dao.ParkingTicketDAO;
import dto.ParkingTicketDTO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/parking-tickets")
public class ParkingTicketRestService {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getParkingTickets() {
        List<ParkingTicketDTO> parkingTickets = ParkingTicketDAO.getInstance().getItems();
        return Response.ok().entity(parkingTickets).build();
    }

}
