package rest.ticketType;

import dao.TicketTypeDAO;
import dto.TicketTypeDTO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/ticket-types")
public class TicketTypeRestService {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getUsers() {
        List<TicketTypeDTO> ticketTypes = TicketTypeDAO.getInstance().getItems();
        return Response.ok().entity(ticketTypes).build();
    }

}
