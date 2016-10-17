package com.wikiraceassistant.crawler;

import java.util.*;

/**
 * Scrapes through a web page and collects every URL that contains the given
 * keyword
 * @author Sebastian Greenholtz
 */
public class KeywordUrlCollector {
    private String keyword;
    private List<String> urls;

    /**
     * Constructor with the keyword
     * @param keyword sets to keyword
     */
    public KeywordUrlCollector(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Searches a given page for every link that contains the given
     * keyword
     * @param startUrl page to start with
     */
    public void search(String startUrl) {
        Leg crawler = new Leg();
        crawler.searchCrawl(startUrl, keyword);
        this.urls = crawler.getLinks();
    }

    /**
     * Gets the list of urls.
     * @return urls
     */
    public List<String> getUrls() {
        return urls;
    }

    @Override
    public String toString() {
        String output = "Keyword: " + keyword + System.lineSeparator();
        output += "Links Found:" + System.lineSeparator();
        for (String link : urls) {
           output += link + System.lineSeparator();
        }
        return output;
    }
}
