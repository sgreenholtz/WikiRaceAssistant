package com.wikiraceassistant.entities;

/**
 * Represents a single link on a page
 * @author Sebastian Greenholtz
 */
public class Link {
    private String title;
    private String url;

    /**
     * Empty constructor
     */
    public Link() {}

    /**
     * Set title and url
     * @param title String
     * @param url String
     */
    public Link(String title, String url) {
        this.title = title;
        this.url = url;
    }

    /**
     * Gets the value of title.
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title to given value
     *
     * @param title value to set instance variable to
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the value of url.
     *
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets url to given value
     *
     * @param url value to set instance variable to
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
