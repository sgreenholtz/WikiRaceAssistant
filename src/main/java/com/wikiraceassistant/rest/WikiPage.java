package com.wikiraceassistant.rest;

import com.wikiraceassistant.crawler.Crawler;
import com.wikiraceassistant.utility.JSONParser;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Rest controller to get a page from Wikipedia
 * @author Sebastian Greenholtz
 */
@Path("/links")
public class WikiPage {

//    @GET
//    @Path("{page}")
//    @Produces("text/json")
//    public Response getLinkList(@PathParam("page") String page) {
//        Crawler crawler = new Crawler();
//        crawler.search(page);
//        String json = JSONParser.parse(crawler.getLinks());
//        return constructResponse(json);
//    }

    @GET
    @Produces("text/json")
    public Response getAllEvents() {
        Crawler crawler = new Crawler();
        crawler.search("Panda");
        String json = JSONParser.parse(crawler.getLinks());
        return constructResponse(json);
    }

    private Response constructResponse(String json) {
        if (json != null) {
            return Response.status(200).entity(json).build();
        } else {
            return constructResponse(404);
        }
    }

    private Response constructResponse(Integer error) {
        return Response.status(error).build();
    }
}
