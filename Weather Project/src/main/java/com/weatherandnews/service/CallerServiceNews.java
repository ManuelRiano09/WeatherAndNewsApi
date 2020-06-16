package com.weatherandnews.service;


import com.weatherandnews.newsapi.NewsResponse;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CallerServiceNews {
    private RestTemplate restTemplate;

    public CallerServiceNews() {
        restTemplate = new RestTemplate();
    }

    public NewsResponse callNewsService(String URLNEWS){

        ResponseEntity<NewsResponse> response =  restTemplate.exchange(URLNEWS, HttpMethod.GET, null, NewsResponse.class);
        if(response.hasBody()){
            System.out.println(response.getStatusCode() + "news");
            return response.getBody();
        }
        return new NewsResponse();
    }

    public String getDate(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate= formatter.format(date);
        return strDate;
    }

    public String urlDinamic(String nameCity){
        String url = "http://newsapi.org/v2/everything?q=%s&from=%s";
        String city = nameCity;
        String date = getDate();
        String newUrl = String.format(url,city, date) + "&sortBy=publishedAt&apiKey=4511191721c049cfb018fce69fac294a" ;
        return newUrl;
    }
}
