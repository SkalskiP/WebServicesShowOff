package com.br400.rest;

import com.br400.JSON.PlainUser;
import com.br400.util.UserVerificator;
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
    public Response listUsers(@HeaderParam("Authorization") String token) {
        if (token == null || !UserVerificator.verifyUser(token).getVerificationStatus()) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        } else if (!UserVerificator.verifyUser(token).isAdmin()) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
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
    public Response getUserById(@HeaderParam("Authorization") String token, @PathParam("id") String id) {
        if (token == null || !UserVerificator.verifyUser(token).getVerificationStatus()) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        } else if (!(UserVerificator.verifyUser(token).getUid().equals(id) || UserVerificator.verifyUser(token).isAdmin())) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
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
    public Response createUser(@HeaderParam("Authorization") String token, PlainUser payload) {
        if (token == null || !UserVerificator.verifyUser(token).getVerificationStatus()) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        } else if (!UserVerificator.verifyUser(token).isAdmin()) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
        try {
            UserRecord.CreateRequest request = new UserRecord.CreateRequest();
            request.setDisplayName(payload.getDisplayName());
            request.setEmail(payload.getEmail());
            request.setPassword(payload.getPassword());
            request.setPhotoUrl(payload.getPhotoUrl());
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
    public Response updateUser(@HeaderParam("Authorization") String token, @PathParam("id") String userId, PlainUser payload) {
        if (token == null || !UserVerificator.verifyUser(token).getVerificationStatus()) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        } else if (!(UserVerificator.verifyUser(token).getUid().equals(userId) || UserVerificator.verifyUser(token).isAdmin())) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
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

            if (payload.getPhotoUrl() != null && !payload.getPhotoUrl().equals(user.getPhotoUrl())) {
                request.setPhotoUrl(payload.getPhotoUrl());
            }

            user = FirebaseAuth.getInstance().updateUser(request);
            return Response.ok().entity(user).build();
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
