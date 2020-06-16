package com.weatherandnews.service;

import com.weatherandnews.newsapi.Article;
import com.weatherandnews.newsapi.NewsResponse;
import com.weatherandnews.openweathermap.WeatherResponse;
import com.weatherandnews.response.ApiResponse;
import com.weatherandnews.response.CurrentWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherAndNewsUnionService {

    @Autowired
    private CallerServiceNews callerServiceNews;

    @Autowired
    private CallerServiceWeather callerServiceWeather;


    public ApiResponse getApiResponse(String name){
        ApiResponse apiResponse = new ApiResponse();

        List<Article> articles = new ArrayList<>();
        NewsResponse newsResponse = callerServiceNews.callNewsService(callerServiceNews.urlDinamic(name));
        if (newsResponse != null && newsResponse.getArticles() != null){
            apiResponse.setArticles(newsResponse.getArticles());
        }

        CurrentWeather currentWeather = new CurrentWeather();
        WeatherResponse  weatherResponse = callerServiceWeather.callWeatherResponse(callerServiceWeather.urlDinamic(name));
        if (weatherResponse != null){
            if ( weatherResponse.getCurrent() != null){
                currentWeather.setSunrise(weatherResponse.getCurrent().getSunrise());
                currentWeather.setSunset(weatherResponse.getCurrent().getSunset());
                currentWeather.setTemp(weatherResponse.getCurrent().getTemp());
                currentWeather.setPressure(weatherResponse.getCurrent().getPressure());
                currentWeather.setHumidity(weatherResponse.getCurrent().getHumidity());
                if (weatherResponse.getCurrent().getWeather() != null && weatherResponse.getCurrent().getWeather().size() > 0){
                    currentWeather.setWeatherMain(weatherResponse.getCurrent().getWeather().get(0).getMain());
                    currentWeather.setWeatherDescription(weatherResponse.getCurrent().getWeather().get(0).getDescription());
                }
                currentWeather.setFeelsLike(weatherResponse.getCurrent().getFeelsLike());
                currentWeather.setWindSpeed(weatherResponse.getCurrent().getWindSpeed());
                currentWeather.setTimeZone(weatherResponse.getTimeZone());
            }

        }
        apiResponse.setCurrentWeather(currentWeather);
        return apiResponse;
    }


}
