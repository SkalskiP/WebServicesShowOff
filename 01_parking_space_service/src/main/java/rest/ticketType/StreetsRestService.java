package rest.ticketType;

import dao.StreetDAO;
import dto.StreetDTO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/streets")
public class StreetsRestService {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getStreets() {
        List<StreetDTO> streets = StreetDAO.getInstance().getItems();
        return Response.ok().entity(streets).build();
    }

}
