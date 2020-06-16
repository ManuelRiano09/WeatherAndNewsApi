package com.weatherandnews.controller.testcontroller;

import com.weatherandnews.city.Coord;
import com.weatherandnews.service.CityFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @Autowired
    private CityFinderService cityFinderService;

    public Coord getCoord(){
        return  cityFinderService.cityFinder("");
    }

    @GetMapping("/test/{id}")
    public String test(@PathVariable ("id") String id){
        return id.toUpperCase();
    }

    @GetMapping("/testRequest") // responde en localhost:1234/testRequest?id={}
    public String testRequest(@RequestParam String id){
        return id.toUpperCase();
    }

    @GetMapping("/testCity")
    public void testCity(@RequestParam Coord coord){

    }
}
