package com.aircraft.tower;

import com.aircraft.aircrafts.Coordinates;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
    }

    void changeWeather(){
        conditionsChanged();
    }

    public void runSimulation(Integer amountOfsimulations) {
        //Compare and increment
        while (amountOfsimulations --> 0) {
            changeWeather();
        }
    }

}
