package rest;

import rest.ticketType.EmployeesRestService;
import rest.ticketType.ParkingSpotRestService;
import rest.ticketType.StreetsRestService;
import rest.ticketType.TicketTypesRestService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class ApiApplication extends Application {

    HashSet<Object> singletons = new HashSet<Object>();

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> set = new HashSet<Class<?>>();

        set.add(TicketTypesRestService.class);
        set.add(EmployeesRestService.class);
        set.add(StreetsRestService.class);
        set.add(ParkingSpotRestService.class);

        return set;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

}
