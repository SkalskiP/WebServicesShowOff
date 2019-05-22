package rest.employee;

import dao.EmployeeDAO;
import dto.EmployeeDTO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/employees")
public class EmployeesRestService {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getEmployees() {
        List<EmployeeDTO> employees = EmployeeDAO.getInstance().getItems();
        return Response.ok().entity(employees).build();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getEmployeeById(@PathParam("id") Integer id) {
        EmployeeDTO employee = EmployeeDAO.getInstance().getItem(id);
        return Response.ok().entity(employee).build();
    }
}
