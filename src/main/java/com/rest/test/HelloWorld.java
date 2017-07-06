package com.rest.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * This is a sample REST API service for the purpose of demonstrating
 * Enunciate/Swagger integration.
 *
 * @author Crash Bandicoot
 */
@Path("/helloworld")
public class HelloWorld {

    /**
     * Returns a customized greeting.
     * @param name Name of the person to greet.
     * @return The greeting.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response HelloWorld(@DefaultValue("World") @QueryParam("name") String msg) {

        String result = "Hello " + msg + "!";

        return Response.ok()
                       .entity(result)
                       .header("Access-Control-Allow-Origin", "*")
                       .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                       .build();
    }
}
