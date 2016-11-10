package com.wikiraceassistant.crawler;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Sebastian Greenholtz
 */
public class LegTest {

    private static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";

    @Test
    public void crawlTest() throws Exception {
        Leg leg = new Leg();
        Elements elements = leg.crawl("http://www.sheldonbrown.com/web_sample1.html");
        int expected = 62;
        assertEquals("Incorrect number of links retrieved", expected, elements.size());
    }

    @Test
    public void addLinksToListTest() throws Exception {
        Leg leg = new Leg("http://www.sheldonbrown.com/web_sample1.html");
        Connection connection = Jsoup.connect("http://www.sheldonbrown.com/web_sample1.html").userAgent(USER_AGENT);
        Document htmlDocument = connection.get();
        Elements elements = htmlDocument.select("a[href]");
        leg.addLinksToList(elements);
        assertEquals(0, leg.getLinks().size());
    }

}