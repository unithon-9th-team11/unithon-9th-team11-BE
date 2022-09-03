package com.gitjupalza.domain.github.repository;

import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
@RequiredArgsConstructor
public class GitHubCrawlUtil {

    public int getTotalContribution() {
        String crawlingURL = "https://github.com/";
        Document doc;

        {
            try {
                doc = Jsoup.connect(crawlingURL).get();
                Elements imageUrlElements = doc.getElementsByClass("swiper-lazy");

                for (Element element : imageUrlElements) {
                    System.out.println(element);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return -1;
    }

}
