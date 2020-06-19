package com.weatherandnews.service;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.weatherandnews.accesingdatamysql.SearchesRepository;
import com.weatherandnews.city.City;
import com.weatherandnews.entitys.Searches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;

@Service
public class SavedService {

    @Autowired
    private SearchesRepository searchesRepository;

    private Gson gson;

    public SavedService() {
        gson = new Gson();
    }

    public boolean validateCity(String name){
        try{
            JsonReader reader = new JsonReader(new FileReader("C:\\Users\\felip\\IdeaProjects\\Weather Project\\src\\main\\resources\\city.list.json"));
            City[] cities = gson.fromJson(reader, City[].class);
            for (int i = 0; i< cities.length; i++){
                if (cities[i].getName().equalsIgnoreCase(name)){
                    return true;
                }
            }
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void save(String name){
        boolean b = validateCity(name);
        if(b){
            Searches s = new Searches();
            s.setCity(name);
            s.setInfo("http://localhost:1234/weatherandnews?nameCity=" + name);
            searchesRepository.save(s);
        }
    }
}
