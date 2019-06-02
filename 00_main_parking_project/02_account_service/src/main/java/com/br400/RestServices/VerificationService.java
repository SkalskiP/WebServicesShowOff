package com.br400.RestServices;
import com.br400.JSON.Identity;
import com.br400.JSON.Token;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;

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
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(payload.getToken());
            return Response.ok().entity(new Identity(decodedToken.getUid())).build();
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
