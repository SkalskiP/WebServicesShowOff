package rest.parkingSpot;

import dao.ParkingSpotDAO;
import dto.ParkingSpotDTO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/parking-spots")
public class ParkingSpotRestService {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getParkingSpots() {
        List<ParkingSpotDTO> parkingSpots = ParkingSpotDAO.getInstance().getItems();
        return Response.ok().entity(parkingSpots).build();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getParkingSpotById(@PathParam("id") Integer id) {
        ParkingSpotDTO parkingSpot = ParkingSpotDAO.getInstance().getItem(id);
        return Response.ok().entity(parkingSpot).build();
    }

//    @GET
//    @Path("/report")
//    @Produces({MediaType.APPLICATION_JSON})
}
