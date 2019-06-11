package rest.parking_spot;

import dao.ParkingSpotDAO;
import dto.ParkingSpotDTO;
import verification.Identity;
import verification.UserVerificator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/parking-spots")
public class ParkingSpotRestService {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getParkingSpots(@QueryParam("zone") String zone, @QueryParam("street") String street,
                                    @QueryParam("limit") Integer limit, @QueryParam("offset") Integer offset, @HeaderParam("Authorization") String token) {

        Identity identity = UserVerificator.validateIdToken(token);
        if (token == null || !identity.getVerificationStatus()) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        ParkingSpotRaportData parkingSpotRaport = new ParkingSpotRaportData();

        if (identity.isAdmin()) {
            parkingSpotRaport.setData(ParkingSpotDAO.getInstance().getFiltered(zone, street, offset, limit));
            parkingSpotRaport.setTotalCount(ParkingSpotDAO.getInstance().getFilteredCount(zone, street));
        } else {
            parkingSpotRaport.setData(ParkingSpotDAO.getInstance().getByFirebaseUid(zone, street, offset, limit, identity.getUid()));
            parkingSpotRaport.setTotalCount(ParkingSpotDAO.getInstance().getByFirebaseUidCount(zone, street, identity.getUid()));
        }

        return Response.ok().entity(parkingSpotRaport).build();
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
