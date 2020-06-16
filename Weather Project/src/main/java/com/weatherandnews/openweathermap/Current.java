package com.weatherandnews.openweathermap;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Current {

     private Long dt;
     private Long sunrise;
     private Long sunset;
     private Double temp;
     @JsonProperty("feels_like")
     private Double feelsLike;
     private Integer pressure;
     private Integer humidity;
     @JsonProperty("dew_point")
     private Double dewPoint;
     private Double uvi;
     private Integer clouds;
     private String visibility;
     @JsonProperty("wind_speed")
     private Float windSpeed;
     @JsonProperty("wind_deg")
     private Integer windDeg;
     private List<Weather> weather;

     public Long getDt() {
          return dt;
     }

     public void setDt(Long dt) {
          this.dt = dt;
     }

     public Long getSunrise() {
          return sunrise;
     }

     public void setSunrise(Long sunrise) {
          this.sunrise = sunrise;
     }

     public Long getSunset() {
          return sunset;
     }

     public void setSunset(Long sunset) {
          this.sunset = sunset;
     }

     public Double getTemp() {
          return temp;
     }

     public void setTemp(Double temp) {
          this.temp = temp;
     }

     public Double getFeelsLike() {
          return feelsLike;
     }

     public void setFeelsLike(Double feelsLike) {
          this.feelsLike = feelsLike;
     }

     public Integer getPressure() {
          return pressure;
     }

     public void setPressure(Integer pressure) {
          this.pressure = pressure;
     }

     public Integer getHumidity() {
          return humidity;
     }

     public void setHumidity(Integer humidity) {
          this.humidity = humidity;
     }

     public Double getDewPoint() {
          return dewPoint;
     }

     public void setDewPoint(Double dewPoint) {
          this.dewPoint = dewPoint;
     }

     public Double getUvi() {
          return uvi;
     }

     public void setUvi(Double uvi) {
          this.uvi = uvi;
     }

     public Integer getClouds() {
          return clouds;
     }

     public void setClouds(Integer clouds) {
          this.clouds = clouds;
     }

     public String getVisibility() {
          return visibility;
     }

     public void setVisibility(String visibility) {
          this.visibility = visibility;
     }

     public Float getWindSpeed() {
          return windSpeed;
     }

     public void setWindSpeed(Float windSpeed) {
          this.windSpeed = windSpeed;
     }

     public Integer getWindDeg() {
          return windDeg;
     }

     public void setWindDeg(Integer windDeg) {
          this.windDeg = windDeg;
     }

     public List<Weather> getWeather() {
          return weather;
     }

     public void setWeather(List<Weather> weather) {
          this.weather = weather;
     }
}
