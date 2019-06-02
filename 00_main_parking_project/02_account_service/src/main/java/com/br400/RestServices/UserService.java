package com.br400.RestServices;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.ListUsersPage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserService {
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response listUsers() {
        try {
            ListUsersPage page = FirebaseAuth.getInstance().listUsers(null);
            return Response.ok().entity(page).build();
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }



}
