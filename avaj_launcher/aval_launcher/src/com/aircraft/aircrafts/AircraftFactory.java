package com.aircraft.aircrafts;

import com.aircraft.simulator.Flyable;

public class AircraftFactory{
    public static Flyable newAircraft(String type, String name, int longitude, int latitute, int height) throws Exception {
       Coordinates coordinates = new Coordinates(longitude, latitute, height);
       switch(type){
           case "Helicopter":
               return new Helicopter(name, coordinates);
            case "JetPlane":
                return new JetPlane(name, coordinates);
            case "Baloon":
                return new Baloon(name, coordinates);
            default:throw new Exception("No aircraft type");
        }

    }

}
