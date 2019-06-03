package rest.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.ParkingSpotDTO;
import jms.ParkingSystemNotificationMessage;
import store.NotificationStore;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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


@Path("/employees")
public class MessagesRestService {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMessagesAll() {
        List<ParkingSystemNotificationMessage> allNotifications = NotificationStore.getInstance().getNotificationsAll();
        return Response.ok().entity(this.filterInactiveNotifications(allNotifications)).build();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMessagesEmployeeById(@PathParam("id") Integer id) {
        List<ParkingSystemNotificationMessage> allNotifications = NotificationStore.getInstance().getNotificationsByEmployee(id);
        return Response.ok().entity(this.filterInactiveNotifications(allNotifications)).build();
    }

    private List<ParkingSystemNotificationMessage> filterInactiveNotifications(List<ParkingSystemNotificationMessage> notifications) {
        ArrayList activeNotifications = new ArrayList();

        for (ParkingSystemNotificationMessage notificationMessage : notifications){
            try {
                Optional<ParkingSpotDTO> parkingSpot = this.sendGET(notificationMessage.getSpotId());
                if (parkingSpot.isPresent() && parkingSpot.get().getOccupied() && Objects.equals(parkingSpot.get().getTriggerEventUuid(), notificationMessage.getTriggerEventUuid())) {
                    activeNotifications.add(notificationMessage);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  activeNotifications;
    }

    private Optional<ParkingSpotDTO> sendGET(Integer spotId) throws IOException {
        URL obj = new URL("http://localhost:8080/rest/parking-spots/" + spotId.toString());
        ObjectMapper objectMapper = new ObjectMapper();
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
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
