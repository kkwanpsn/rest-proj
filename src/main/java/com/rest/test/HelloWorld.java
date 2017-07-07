package com.rest.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.webcohesion.enunciate.metadata.rs.StatusCodes;
import com.webcohesion.enunciate.metadata.rs.ResponseCode;
import com.webcohesion.enunciate.metadata.rs.TypeHint;

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
     * @HTTP 500 Internal server error.
     * @HTTP 404 Greeting not found.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @StatusCodes({
            @ResponseCode(code=500, condition="Internal Kamaji server error.", type=@TypeHint(Response.class))
                })
    public Response HelloWorld(@DefaultValue("World") @QueryParam("name") String msg) {

        String result = "Hello " + msg + "!";

        return Response.ok()
                       .entity(result)
                       .header("Access-Control-Allow-Origin", "*")
                       .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                       .build();
    }
}
