package com.wikiraceassistant.crawler;

/**
 * Tests the eventspider.crawler application on the command line
 * @author Sebastian Greenholtz
 */
public class CrawlerTest {
    public static void main(String[] args) {
        Crawler crawler = new Crawler();
        crawler.search("http://isthmus.com/search/event/calendar-of-events/", "jazz");
    }
}
