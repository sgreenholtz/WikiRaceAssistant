package com.wikiraceassistant.crawler;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Austin Chappell
 */
public class CrawlerUnitTest {

    private final Logger logger = Logger.getLogger(this.getClass());


    @Test
    public void searchTest() throws Exception {
        Crawler crawler = new Crawler();
        crawler.search("Stoneycroft");
        assertEquals(119, crawler.getLinks().getLinks().size());
    }

}