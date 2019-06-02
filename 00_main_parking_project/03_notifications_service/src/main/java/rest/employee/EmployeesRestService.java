package rest.employee;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/employees")
public class EmployeesRestService {

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getEmployeeById(@PathParam("id") Integer id) {
        return Response.ok().entity(id).build();
    }
}
