package com.wikiraceassistant.crawler;

import java.util.*;

/**
 * Simple eventspider.crawler patterned on tutorial from http://www.netinstructions.com/how-to-make-a-simple-web-crawler-in-java/
 * @author Sebastian Greenholtz
 */
public class Crawler {
    protected static final int MAX_PAGES_TO_SEARCH = 25;
    protected Set<String> pagesVisited = new HashSet<String>();
    protected List<String> pagesToVisit = new LinkedList<String>();

    /**
     * Gets the next URL to visit from pagesToVisit that hasn't already
     * been visited
     * @return next URL to search
     */
    protected String nextUrl() {
        String nextUrl;
        do {
            nextUrl = this.pagesToVisit.remove(0);
        } while(this.pagesVisited.contains(nextUrl));

        this.pagesVisited.add(nextUrl);
        return nextUrl;
    }

    /**
     * Searches for a given word on the website at give URL
     * @param url page to search
     * @param searchWord word to search for
     */
    public void search(String url, String searchWord)
    {
        while(this.pagesVisited.size() < MAX_PAGES_TO_SEARCH)
        {
            String currentUrl;
            Leg leg = new Leg();
            if(this.pagesToVisit.isEmpty()) {
                currentUrl = url;
                this.pagesVisited.add(url);
            } else {
                currentUrl = this.nextUrl();
            }

            leg.plainCrawl(currentUrl);
            this.pagesToVisit.addAll(leg.getLinks());
        }
    }
}
