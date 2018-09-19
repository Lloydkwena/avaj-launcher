package com.aircraft.simulator;

import com.aircraft.tower.WeatherTower;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower WeatherTower);

}
