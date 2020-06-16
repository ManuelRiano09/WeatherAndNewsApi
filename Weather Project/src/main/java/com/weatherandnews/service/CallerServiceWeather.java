package com.weatherandnews.service;

import com.weatherandnews.openweathermap.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CallerServiceWeather {

    //CityFinderService cityFinderService = new CityFinderService();

    @Autowired
    private CityFinderService cityFinderService;
    private RestTemplate restTemplate;

    public CallerServiceWeather() {
        restTemplate = new RestTemplate();
    }

    public String urlDinamic(String nameCity){ //completar la url con los valores latitud y longitud de la ciudad pasada como parametro

        String URL = "https://api.openweathermap.org/data/2.5/onecall?lat=%f&lon=%f";
        // "https://www.onlinegdb.com/online_java_compiler?param1=%f&param2=&%f&param3=%f&param4=%s";
        Double lat = cityFinderService.cityFinder(nameCity).getLat();
        Double lon = cityFinderService.cityFinder(nameCity).getLon();
        String newURL = String.format(URL,lat,lon) +"&%20exclude=hourly,daily&appid=dc294ff057c882d8e2147db39eca2f3f#";
        return  newURL;
    }

    public WeatherResponse callWeatherResponse(String URLWEATHER){

        ResponseEntity<WeatherResponse> response = restTemplate.exchange(URLWEATHER, HttpMethod.GET, null, WeatherResponse.class);
        if (response.hasBody()){
            System.out.println(response.getStatusCode() + "weather");
            return response.getBody();
        }
        return new WeatherResponse();
    }
}
