package rest.message;

import dao.EmployeeDAO;
import dto.EmployeeDTO;
import verification.UserVerificator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/employees")
public class EmployeesRestService {
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getEmployees(@HeaderParam("Authorization") String token) {
        if (token == null || !UserVerificator.validateIdToken(token).getVerificationStatus()) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        List<EmployeeDTO> employees = EmployeeDAO.getInstance().getItems();
        return Response.ok().entity(employees).build();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getEmployeeById(@PathParam("id") Integer id, @HeaderParam("Authorization") String token) {
        if (token == null || !UserVerificator.validateIdToken(token).getVerificationStatus()) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        EmployeeDTO employee = EmployeeDAO.getInstance().getItem(id);
        return Response.ok().entity(employee).build();
    }
}
