package rest;

import rest.message.MessagesRestService;

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

        set.add(MessagesRestService.class);

        return set;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

}
