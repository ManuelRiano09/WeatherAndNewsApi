package com.weatherandnews.service;


import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.weatherandnews.city.City;
import com.weatherandnews.city.Coord;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;

@Service
public class CityFinderService {

    private Gson gson;

    public CityFinderService() {
        gson = new Gson();
    }

    public Coord cityFinder(String name){
        try{
            JsonReader reader = new JsonReader(new FileReader("C:\\Users\\felip\\IdeaProjects\\Weather Project\\src\\main\\resources\\city.list.json"));
            City[] cities = gson.fromJson(reader, City[].class);
            for (int i = 0; i< cities.length; i++){
                if (cities[i].getName().equalsIgnoreCase(name)){
                    return cities[i].getCoord();
                }
            }

        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        return new Coord();
    }

}
