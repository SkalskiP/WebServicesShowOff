package com.br400.rest;

import org.jboss.resteasy.plugins.interceptors.CorsFilter;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class RestServiceConfig extends Application {
    Set<Object> singletons;

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> clazzes = new HashSet<>();
        clazzes.add(UserService.class);
        clazzes.add(VerificationService.class);
        return clazzes;
    }

    @Override
    public Set<Object> getSingletons() {
        if (singletons == null) {
            CorsFilter corsFilter = new CorsFilter();
            corsFilter.getAllowedOrigins().add("*");

            singletons = new LinkedHashSet<>();
            singletons.add(corsFilter);
        }
        return singletons;
    }
}
