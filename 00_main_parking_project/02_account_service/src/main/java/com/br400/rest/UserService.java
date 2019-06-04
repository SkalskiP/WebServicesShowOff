package com.br400.rest;

import com.br400.JSON.PlainUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.ListUsersPage;
import com.google.firebase.auth.UserRecord;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/user")
public class UserService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listUsers() {
        try {
            ListUsersPage page = FirebaseAuth.getInstance().listUsers(null);
            return Response.ok().entity(page).build();
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("id") String id) {
        try {
            UserRecord user = FirebaseAuth.getInstance().getUser(id);
            return Response.ok().entity(user).build();
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(PlainUser payload) {
        try {
            UserRecord.CreateRequest request = new UserRecord.CreateRequest();
            request.setDisplayName(payload.getDisplayName());
            request.setEmail(payload.getEmail());
            request.setPassword(payload.getPassword());
            UserRecord user = FirebaseAuth.getInstance().createUser(request);
            Map<String, Object> customClaims = new HashMap<>();
            customClaims.put("isAdmin", payload.getAdmin());
            FirebaseAuth.getInstance().setCustomUserClaims(user.getUid(), customClaims);
            user = FirebaseAuth.getInstance().getUser(user.getUid());
            return Response.ok().entity(user).build();
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @PATCH
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") String userId, PlainUser payload) {
        try {
            UserRecord user = FirebaseAuth.getInstance().getUser(userId);
            UserRecord.UpdateRequest request = new UserRecord.UpdateRequest(user.getUid());

            if (payload.getAdmin() != null && payload.getAdmin() != user.getCustomClaims().get("isAdmin")) {
                Map<String, Object> customClaims = new HashMap<>(user.getCustomClaims());
                customClaims.put("isAdmin", payload.getAdmin());
                request.setCustomClaims(customClaims);
            }

            if (payload.getDisplayName() != null && !payload.getDisplayName().equals(user.getDisplayName())) {
                request.setDisplayName(payload.getDisplayName());
            }

            if (payload.getEmail() != null && !payload.getEmail().equals(user.getEmail())) {
                request.setDisplayName(payload.getEmail());
            }

            user = FirebaseAuth.getInstance().updateUser(request);
            return Response.ok().entity(user).build();
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
