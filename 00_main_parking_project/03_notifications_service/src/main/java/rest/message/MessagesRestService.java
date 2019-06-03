package rest.message;

import store.NotificationStore;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/employees")
public class MessagesRestService {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMessagesAll() {
        return Response.ok().entity(NotificationStore.getInstance().getNotificationsAll()).build();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMessagesEmployeeById(@PathParam("id") Integer id) {
        return Response.ok().entity(NotificationStore.getInstance().getNotificationsByEmployee(id)).build();
    }
}
