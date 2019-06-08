package com.br400.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class RestServiceConfig extends Application {

    HashSet<Object> singletons = new HashSet<Object>();

    public RestServiceConfig() {
        CorsFilter corsFilter = new CorsFilter();
        corsFilter.getAllowedOrigins().add("*");
        corsFilter.setAllowedMethods("OPTIONS, GET, POST, DELETE, PUT, PATCH");
        singletons.add(corsFilter);
    }

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> set = new HashSet<Class<?>>();

        set.add(UserService.class);
        set.add(VerificationService.class);

        return set;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

}
