package com.weatherandnews.controller;

import com.weatherandnews.city.Coord;
import com.weatherandnews.newsapi.NewsResponse;
import com.weatherandnews.openweathermap.WeatherResponse;
import com.weatherandnews.response.ApiResponse;
import com.weatherandnews.service.CallerServiceNews;
import com.weatherandnews.service.CallerServiceWeather;
import com.weatherandnews.service.CityFinderService;
import com.weatherandnews.service.WeatherAndNewsUnionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherAndNewsController {
    @Autowired //instancia la clase para poder usar sus metodos
    private CallerServiceNews callerServiceNews;

    @Autowired
    private CallerServiceWeather callerServiceWeather;

    @Autowired
    private CityFinderService cityFinderService;

    @Autowired
    private WeatherAndNewsUnionService weatherAndNewsUnionService;

    @GetMapping("/news/city") // metodo get - responde en localhost:1234/news
    public NewsResponse getNewsFromCity(@RequestParam String name){
        return callerServiceNews.callNewsService(callerServiceNews.urlDinamic(name));
    }

    //@GetMapping("/weather")
    //public WeatherResponse getWeather(){
      //  return  callerServiceWeather.callWeatherResponse();
    //}

    @GetMapping("/cityProperties") // responde en localhost:1234/cityProperties?city={parametro}
    public Coord getCity(@RequestParam String city) { // parametro (@RequestParam) = nombre de la ciudad
        return cityFinderService.cityFinder(city);

    }

    @GetMapping("/weather/city")
    public WeatherResponse getWeatherFromCity(@RequestParam String name){
        return callerServiceWeather.callWeatherResponse(callerServiceWeather.urlDinamic(name));
    }

    @GetMapping("/weatherandnews")
    public ApiResponse getApi (@RequestParam String nameCity){
        return weatherAndNewsUnionService.getApiResponse(nameCity);
    }
}

