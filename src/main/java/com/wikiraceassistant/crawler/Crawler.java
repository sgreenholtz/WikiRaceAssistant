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
     * @param page Page name to search
     */
    public void search(String page) {
        String url = createWikipediaUrl(page);
        links.setSourceUrl(url);
        Leg leg = new Leg();
        try {
            leg.doCrawl(url);
            links.setLinks(leg.getLinks());
        } catch (PageNotFoundException e) {
            links.setLinks(null);
        }
    }

    /**
     * Takes the page name, replaces the spaces with underscores, and appends
     *  it to the rest of the url
     * @param title Page title, with spaces or underscores as delimiters
     * @return URL of the wikipedia page with that title
     */
    private String createWikipediaUrl(String title) {
        return "https://en.wikipedia.org/wiki/" + title.replace(' ', '_');
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
