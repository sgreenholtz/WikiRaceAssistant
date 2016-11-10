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
    private List<Link> links;
    private String sourceUrl;
    private final Logger logger = Logger.getLogger(this.getClass());
    private static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";

    /**
     * Empty constructor
     */
    public Leg() {
       links = new LinkedList<>();
    }

    /**
     * Protected constructor adds URL at construction
     * @param url
     */
    protected Leg(String url) {
        this();
        this.sourceUrl = url;
    }

    /**
     * Brings up a given webpage and searches for links on the page
     * TODO: Return error if the page doesn't exist
     * TODO: Filter results at this step
     * @param url page to search
     * @return list of links found on the page
     */
    protected Elements crawl(String url) throws PageNotFoundException{
        sourceUrl = url;
        Elements linksOnPage = null;
        try {
            Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
            Document htmlDocument = connection.get();
            linksOnPage = htmlDocument.select("a[href]");
        } catch (HttpStatusException e) {
            throw new PageNotFoundException("Page does not exist: " + url);
        } catch(IOException ioe) {
            logger.info("Error in out HTTP request " + ioe);
            logger.error(ioe.getStackTrace());
        }
        return linksOnPage;
    }

    /**
     * Perform a crawl to search for all links
     * @param url page to search
     */
    public void doCrawl(String url) throws PageNotFoundException{
        addLinksToList(crawl(url));
    }

    /**
     * Adds the links found on a page to the list of links.
     * @param elements All links on a page
     */
    protected void addLinksToList(Elements elements) {
        for(Element element : elements) {
            String url = element.absUrl("href");
            if (isContentPage(url)) {
                Link link = new Link();
                link.setTitle(element.attr("title"));
                link.setUrl(element.absUrl("href"));
                links.add(link);
            }
        }
    }

    /**
     * Checks a series of conditions to see if this url
     * represents a real content page (ie not a Wikipedia organization
     * page)
     * @param url link url
     * @return true if this is a valid content page
     */
    private boolean isContentPage(String url) {
        if (!url.startsWith("https://en.wikipedia.org/wiki/")) {
            return false;
        } else if (url.matches("https:\\/\\/en\\.wikipedia\\.org\\/wiki\\/.+:.*")) {
            return false;
        } else if (url.contains("Main_Page")) {
            return false;
        } else if (url.toLowerCase().startsWith(sourceUrl.toLowerCase())) {
            return false;
        }
        return true;
    }

    /**
     * Gets the links found on the page
     * @return links List of links found on the page searched
     */
    public List<Link> getLinks() {
        return links;
    }



}
