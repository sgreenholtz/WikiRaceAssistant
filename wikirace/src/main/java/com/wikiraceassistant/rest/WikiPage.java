package com.wikiraceassistant.rest;

import com.wikiraceassistant.crawler.Crawler;
import com.wikiraceassistant.utility.JSONParser;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Rest controller to get a page from Wikipedia. Returns a 404 error
 * if the page does not exist in Wikipedia, even though Wikipedia has their own error
 * page for errors.
 * @author Sebastian Greenholtz
 */
@Path("/links")
public class WikiPage {

    @GET
    @Path("{page}")
    @Produces("text/json")
    public Response getLinkList(@PathParam("page") String page) {
        Crawler crawler = new Crawler();
        crawler.search(page);
        if (crawler.getLinks().getLinks() == null) {
            return constructResponse(404);
        } else {
            String json = JSONParser.parse(crawler.getLinks());
            return constructResponse(json);
        }

    }

    private Response constructResponse(String json) {
        return Response.status(200).entity(json).build();
    }

    private Response constructResponse(Integer error) {
        return Response.status(error).build();
    }
}
