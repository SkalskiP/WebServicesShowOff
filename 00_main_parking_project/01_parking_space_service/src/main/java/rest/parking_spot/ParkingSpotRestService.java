package rest.parking_spot;

import dao.ParkingSpotDAO;
import dto.ParkingSpotDTO;
import verification.Identity;
import verification.UserVerificator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/parking-spots")
public class ParkingSpotRestService {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getParkingSpots(@HeaderParam("Authorization") String token) {
        Identity identity = UserVerificator.validateIdToken(token);
        if (token == null || !identity.getVerificationStatus()) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        List<ParkingSpotDTO> parkingSpots;

        System.out.println("DUPA");
        System.out.println(identity.isAdmin());

        if (identity.isAdmin()) {
            parkingSpots = ParkingSpotDAO.getInstance().getItems();
        } else {
            parkingSpots = ParkingSpotDAO.getInstance().getByFirebaseUid(identity.getUid());
        }

        return Response.ok().entity(parkingSpots).build();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getParkingSpotById(@PathParam("id") Integer id, @HeaderParam("Authorization") String token) {
        if (token == null || !UserVerificator.validateIdToken(token).getVerificationStatus()) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        ParkingSpotDTO parkingSpot = ParkingSpotDAO.getInstance().getItem(id);
        return Response.ok().entity(parkingSpot).build();
    }
}
