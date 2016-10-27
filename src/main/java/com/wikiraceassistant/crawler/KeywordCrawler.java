package com.wikiraceassistant.crawler;

import org.apache.log4j.Logger;

import java.util.*;

/**
 * Crawler that searches for a search term in links that contain a specified keyword
 * @author Sebastian Greenholtz
 */
public class KeywordCrawler extends Crawler {
    private Set<String> keywordText;
    private Map<String, Set<String>> linkText;
    private final Logger logger = Logger.getLogger(this.getClass());

    /**
     * Empty constructor
     */
    public KeywordCrawler() {
        super();
        this.keywordText = new HashSet<String>();
        this.linkText = new HashMap<>();
    }

    /**
     * Runs the keyword crawl. First, all the links from the given web page with
     * the given keyword in the link are collected and added to the pages to visit.
     * Then the search is performed on each of those link pages, looking for the
     * search keyword
     * @param startURL url to start the crawl
     * @param urlKeyword key word to collect urls
     * @param searchKeyword key word to search for on the collected pages
     */
    public void run(String startURL, String urlKeyword, String searchKeyword) {
        KeywordUrlCollector collector = new KeywordUrlCollector(urlKeyword);
        collector.search(startURL);
        this.pagesToVisit = collector.getUrls();
        search(searchKeyword);
    }

//    /**
//     * Searches for a given word in the list of keyword links
//     * @param keyword word to do the search on
//     */
//    private void search(String keyword)
//    {
//        while(this.pagesVisited.size() < MAX_PAGES_TO_SEARCH)
//        {
//            String currentUrl;
//            Leg leg = new Leg();
//            if(this.pagesToVisit.isEmpty()) {
//                logger.info("No valid links found.");
//                break;
//            } else {
//                currentUrl = this.nextUrl();
//            }
//
//            leg.searchCrawl(currentUrl, keyword);
//
//            if(leg.searchForWord(keyword)) {
//                logger.info(leg.getKeywordText());
//            }
//            this.pagesToVisit.addAll(leg.getLinks());
//        }
//    }

    /**
     * Gets the value of linkText.
     * @return linkText
     */
    public Map<String, Set<String>> getLinkText() {
        return linkText;
    }
}
