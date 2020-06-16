package com.weatherandnews.pruebas;

import java.text.DateFormat;
import java.util.Calendar;
import java.text.SimpleDateFormat;
class prueba
{
    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal));
    }
}
