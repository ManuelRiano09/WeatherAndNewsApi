package com.weatherandnews.entitys;

import javax.persistence.*;

@Entity
public class Searches {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="city", nullable = false)
    private String city;

    @Column(name="info", nullable = false)
    private String info;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
