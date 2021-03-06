package rest.ticket_type;

import dao.TicketTypeDAO;
import dto.TicketTypeDTO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/ticket-types")
public class TicketTypesRestService {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getTicketTypes() {
        List<TicketTypeDTO> ticketTypes = TicketTypeDAO.getInstance().getItems();
        return Response.ok().entity(ticketTypes).build();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getTicketTypeById(@PathParam("id") Integer id) {
        TicketTypeDTO ticketType = TicketTypeDAO.getInstance().getItem(id);
        return Response.ok().entity(ticketType).build();
    }
}
