package com.br400.rest;
import com.br400.JSON.Token;
import com.br400.JSON.VerificationResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.UserRecord;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/verification")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class VerificationService {
    @POST
    public Response verify(Token payload) {
        try {
            FirebaseToken token = FirebaseAuth.getInstance().verifyIdToken(payload.getToken());
            UserRecord user = FirebaseAuth.getInstance().getUser(token.getUid());
            Boolean isAdmin = (Boolean) user.getCustomClaims().getOrDefault("isAdmin", false);
            return Response.ok().entity(new VerificationResult(true, isAdmin, token.getUid())).build();
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            return Response.ok().entity(new VerificationResult(false, false, null)).build();
        }
    }
}
