package com.wikiraceassistant.crawler;

import com.wikiraceassistant.entities.Links;

/**
 * Simple crawler patterned on <a href="http://www.netinstructions.com/how-to-make-a-simple-web-crawler-in-java/" >this tutorial</a>
 * @author Sebastian Greenholtz
 */
public class Crawler {

    protected Links links;

    /**
     * Empty constructor
     */
    public Crawler() {
        links = new Links();
    }

    /**
     * Performs search using Leg
     * @param url Page url to search
     */
    public void search(String url) {
        links.setSourceUrl(url);
        Leg leg = new Leg();
        leg.doCrawl(url);
        links.setLinks(leg.getLinks());
    }

    /**
     * Gets the value of links.
     * @return links
     */
    public Links getLinks() {
        return links;
    }

    //TODO: Take in a page title (ie. gapes valley, as opposed to gapes_valley) and create the URL to search
    //TODO: Return error if the page doesn't exist
}
