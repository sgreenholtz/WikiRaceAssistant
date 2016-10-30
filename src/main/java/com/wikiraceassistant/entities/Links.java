package com.wikiraceassistant.entities;

import java.util.List;

/**
 * Collection of Links
 * @author Sebastian Greenholtz
 */
public class Links {
    private String sourceUrl;
    private List<Link> links;

    /**
     * Empty constructor
     */
    public Links() {}

    /**
     * Set instance vars
     * @param sourceUrl String the original page link
     * @param links List<Link>
     */
    public Links(String sourceUrl, List<Link> links) {
        this.sourceUrl = sourceUrl;
        this.links = links;
    }

    /**
     * Gets the value of sourceUrl.
     *
     * @return sourceUrl
     */
    public String getSourceUrl() {
        return sourceUrl;
    }

    /**
     * Sets sourceUrl to given value
     *
     * @param sourceUrl value to set instance variable to
     */
    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    /**
     * Gets the value of links.
     *
     * @return links
     */
    public List<Link> getLinks() {
        return links;
    }

    /**
     * Sets links to given value
     *
     * @param links value to set instance variable to
     */
    public void setLinks(List<Link> links) {
        this.links = links;
    }

}
