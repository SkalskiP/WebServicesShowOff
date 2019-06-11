package rest.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.EmployeeDAO;
import dto.EmployeeDTO;
import dto.ParkingSpotDTO;
import jms.ParkingSystemNotificationMessage;
import store.NotificationStore;
import verification.Identity;
import verification.UserVerificator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("/employees")
public class MessagesRestService {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMessagesAll(@HeaderParam("authorization") String token) {
        Identity identity = UserVerificator.validateIdToken(token);
        if (token == null || !identity.getVerificationStatus()) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        List<ParkingSystemNotificationMessage> allNotifications = NotificationStore.getInstance().getNotificationsAll();
        List<ParkingSystemNotificationMessage> filtered = this.filterInactiveNotifications(allNotifications, token);

        if (identity.isAdmin()) {
            return Response.ok().entity(filtered).build();
        } else {
            EmployeeDTO employee = EmployeeDAO.getInstance().getByFirebaseUid(identity.getUid());
            return Response.ok().entity(filtered.stream().filter(notification -> notification.getEmployeeId().equals(employee.getId())).collect(Collectors.toList())).build();
        }
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public Response resolveNotification(@QueryParam("employeeId") Integer employeeId, @QueryParam("spotId") Integer spotId, @HeaderParam("authorization") String token) {
        Identity identity = UserVerificator.validateIdToken(token);
        if (token == null || !identity.getVerificationStatus()) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        boolean resolveStatus = NotificationStore.getInstance().resolve(employeeId, spotId);
        if (resolveStatus) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    private List<ParkingSystemNotificationMessage> filterInactiveNotifications(List<ParkingSystemNotificationMessage> notifications, String authToken) {
        ArrayList activeNotifications = new ArrayList();

        for (ParkingSystemNotificationMessage notificationMessage : notifications) {
            try {
                Optional<ParkingSpotDTO> parkingSpot = this.sendGET(notificationMessage.getSpotId(), authToken);
                if (parkingSpot.isPresent() && parkingSpot.get().getOccupied() && Objects.equals(parkingSpot.get().getTriggerEventUuid(), notificationMessage.getTriggerEventUuid())) {
                    activeNotifications.add(notificationMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return activeNotifications;
    }

    private Optional<ParkingSpotDTO> sendGET(Integer spotId, String authToken) throws IOException {
        URL obj = new URL("http://localhost:8080/rest/parking-spots/" + spotId.toString());
        ObjectMapper objectMapper = new ObjectMapper();
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("Authorization", authToken);
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //TODO: Remove logs
            System.out.println(response.toString());
            return Optional.of(objectMapper.readValue(response.toString(), ParkingSpotDTO.class));
        } else {
            System.out.println("GET request not worked");
            return Optional.empty();
        }

    }

}
