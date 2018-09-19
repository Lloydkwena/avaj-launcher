package com.aircraft.tower;

import com.aircraft.aircrafts.Coordinates;
import java.util.Random;

public class WeatherProvider extends Tower{
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};
    private Integer algorithm = 0;
    Random  randomGenerator = new Random();
    private WeatherProvider() {}

    // Randomizes LNG, LAT, HHT it's weather
    private String getRandomWeather(Coordinates coordinates) {
        algorithm = coordinates.getLongitute()
                + coordinates.getLatidute()
                + coordinates.getHieght()
                + randomGenerator.nextInt(100);
        algorithm = (algorithm < 0) ? (algorithm * -1) : algorithm;
        //Looping weather[]
        return (weather[algorithm % 4]);
    }

    public static WeatherProvider getProvider() {
        return (weatherProvider);
    }
    public String getCurrentWeather(Coordinates coordinates){
        return (getRandomWeather(coordinates));
    }
}
