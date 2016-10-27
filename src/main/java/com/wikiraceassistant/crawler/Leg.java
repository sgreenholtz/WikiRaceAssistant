package com.wikiraceassistant.crawler;

import com.wikiraceassistant.entities.Link;
import org.apache.log4j.Logger;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.*;

/**
 * One leg of the crawling journey. Scapes all the data from a webpage and looks for the
 * given word, plus links to visit next
 * @author Sebastian Greenholtz
 */
public class Leg {
    private static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
    private List<Link> links;
    private Document htmlDocument;
    private final Logger logger = Logger.getLogger(this.getClass());

    /**
     * Empty constructor
     */
    public Leg() {
       links = new LinkedList<String>();
        keywordText = new ArrayList<String>();
    }

    /**
     * Brings up a given webpage and searches for links on the page
     * @param url page to search
     * @return list of links found on the page
     */
    private Elements crawl(String url) {
        Elements linksOnPage = null;
        try {
            Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
            Document htmlDocument = connection.get();
            this.htmlDocument = htmlDocument;
            linksOnPage = htmlDocument.select("a[href]");
        } catch(IOException ioe) {
            logger.info("Error in out HTTP request " + ioe);
            logger.error(ioe.getStackTrace());
        }
        return linksOnPage;
    }

    /**
     * Perform a crawl to search for links with the given search term
     * @param url page to search
     * @param searchTerm word to search for
     */
    public void searchCrawl(String url, String searchTerm) {
        addLinksToList(crawl(url), searchTerm);
    }

    /**
     * Perform a crawl to search for all links
     * @param url page to search
     */
    public void plainCrawl(String url) {
        addLinksToList(crawl(url));
    }

    /**
     * Adds the links found on a page to the list of links.
     * @param links All links on a page
     */
    private void addLinksToList(Elements links) {
        for(Element link : links) {
            this.links.add(link.absUrl("href"));
        }
    }

    /**
     * Adds the links found on a page to the list of links if they contain the
     * given search term.
     * @param links All links on a page
     * @param searchTerm term to search for
     */
    private void addLinksToList(Elements links, String searchTerm) {
        for(Element link : links) {
            if (link.absUrl("href").toLowerCase().contains(searchTerm.toLowerCase())) {
                this.links.add(link.absUrl("href"));
            }
        }
    }

    /**
     * Gets the links found on the page
     * @return links List of links found on the page searched
     */
    public List<Link> getLinks() {
        return links;
    }

}
