package com.br400.rest;

import com.br400.JSON.Token;
import com.br400.util.UserVerificator;

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
        return Response.ok().entity(UserVerificator.verifyUser(payload.getToken())).build();
    }
}
