package com.ropogit.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("rst")
public interface TestRestEp {

    @GET
    @Path("test")
    public Response microTest();
}
