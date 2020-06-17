las siguientes son las url para consumir el api

° http://localhost:1234/weatherandnews?nameCity=(nombre de la ciudad) ==> retorna un nuevo json con la informacion de ambos apis de la ciudad buscada
(https://openweathermap.org  y  http://newsapi.org/) 

° http://localhost:1234/news/city?name=(nombre de la ciudad) ==> retorna un json con las noticias de la ciudad buscada (http://newsapi.org/)

° http://localhost:1234/weather/city?name=(nombre de la ciudad) ==> retorna un json con el reporte del clima de la ciudad buscada(https://openweathermap.org)

° http://localhost:1234/cityProperties?city=(nombre de la ciudad)  ==> retorna un json con la longitud y latitud de la ciudad buscada

°http://localhost:1234/history ==> retorna un json con los nombres de las ciudades buscadas anteriormente (datos almacenados en una base de datos)
