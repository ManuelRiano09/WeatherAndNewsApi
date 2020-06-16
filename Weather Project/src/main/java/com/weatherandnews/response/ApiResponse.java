package com.weatherandnews.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.weatherandnews.newsapi.Article;

import java.util.List;

public class ApiResponse {

    private List<Article> articles;
    @JsonProperty("current_weather")
    private CurrentWeather currentWeather;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public CurrentWeather getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(CurrentWeather currentWeather) {
        this.currentWeather = currentWeather;
    }
}
