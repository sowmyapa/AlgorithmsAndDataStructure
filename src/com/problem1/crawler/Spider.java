package com.problem1.crawler;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * http://www.netinstructions.com/how-to-make-a-simple-web-crawler-in-java/
 */
public class Spider {

    static final int MAX_NO_OF_PAGES = 10;

    private Set<String> pagesVisited;

    private List<String> pagesToVisit;

    Spider(){
        pagesVisited = new HashSet<String>();
        pagesToVisit = new LinkedList<String>();
    }

    String nextURL(){
        String nextUrl;
        do{
            nextUrl = pagesToVisit.remove(0);
        }while(pagesVisited.contains(nextUrl));
        pagesVisited.add(nextUrl);
        return nextUrl;
    }

    void search(String url,String word){
        int numberOfPages=0;
        String currentURL;
        SpiderLeg spiderLeg = new SpiderLeg();
        while(numberOfPages<MAX_NO_OF_PAGES){
            if(pagesToVisit.isEmpty()){
                currentURL = url;
                pagesVisited.add(currentURL);
            }else{
                currentURL = nextURL();
            }
            spiderLeg.crawl(currentURL);
            if(spiderLeg.findWord(word)){
                System.out.println(String.format("**Success** Word %s found at %s", word, currentURL));
            }
            this.pagesToVisit.addAll(spiderLeg.getLinks());
            numberOfPages++;
        }
        System.out.println("\n**Done** Visited " + this.pagesVisited.size() + " web page(s)");
    }

}
