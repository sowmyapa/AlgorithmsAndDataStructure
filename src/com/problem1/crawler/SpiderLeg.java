package com.problem1.crawler;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sowmyaparameshwara on 8/28/17.
 */
public class SpiderLeg {

    // We'll use a fake USER_AGENT so the web server thinks the robot is a normal web browser.
    private static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
    private String nextLinks;
    private List<String> linksToVisit = new LinkedList<String>(); // Just a list of URLs
    private Document htmlDocument; // This is our web page, or in other words, our document

    public boolean crawl(String url) {
        try {
            Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
            this.htmlDocument = connection.get();
            if(connection.response().statusCode()==200){
                System.out.println("\n**Visiting** Received web page at " + url);
            }else{
                return false;
            }
            if(!connection.response().contentType().contains("text/html")){
                System.out.println("**Failure** Retrieved something other than HTML");
                return false;
            }
            Elements links = htmlDocument.select("a[href]");
            for(Element link : links){
                linksToVisit.add(link.absUrl("href"));
            }
            return true;


        } catch (IOException e) {
            return false;
        }

    }

    public boolean findWord(String word) {
        // Defensive coding. This method should only be used after a successful crawl.
        if(this.htmlDocument == null)
        {
            System.out.println("ERROR! Call crawl() before performing analysis on the document");
            return false;
        }
        System.out.println("Searching for the word " + word + "...");
        String bodyText = this.htmlDocument.body().text();
        return bodyText.toLowerCase().contains(word.toLowerCase());
    }

    public List<String> getLinks()
    {
        return this.linksToVisit;
    }
}
