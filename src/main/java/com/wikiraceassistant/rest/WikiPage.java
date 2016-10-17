package com.wikiraceassistant.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Class to get a single page from Wikipedia
 * @author Sebastian Greenholtz
 */
@Path("/pages")
public class WikiPage {

    @GET
    @Path("{page}")
    public Response getEventByID(@PathParam("page") String page) {
        return Response.status(200).entity(page).build();
    }
}
