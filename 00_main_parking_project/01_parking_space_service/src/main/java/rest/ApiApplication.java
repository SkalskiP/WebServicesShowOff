package rest;

import rest.employee.EmployeesRestService;
import rest.parkingSpot.ParkingSpotRestService;
import rest.parkingTicket.ParkingTicketRestService;
import rest.street.StreetsRestService;
import rest.ticketType.TicketTypesRestService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class ApiApplication extends Application {

    HashSet<Object> singletons = new HashSet<Object>();

    public ApiApplication() {
        CorsFilter corsFilter = new CorsFilter();
        corsFilter.getAllowedOrigins().add("*");
        corsFilter.setAllowedMethods("OPTIONS, GET, POST, DELETE, PUT, PATCH");
        singletons.add(corsFilter);
    }

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> set = new HashSet<Class<?>>();

        set.add(TicketTypesRestService.class);
        set.add(EmployeesRestService.class);
        set.add(StreetsRestService.class);
        set.add(ParkingSpotRestService.class);
        set.add(ParkingTicketRestService.class);

        return set;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

}
