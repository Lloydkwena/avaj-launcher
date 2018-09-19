package com.aircraft.aircrafts;

import com.aircraft.simulator.Flyable;
import com.aircraft.tower.WeatherTower;
import com.aircraft.tower.WriteToFile;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    protected Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
    }

   public void updateConditions(){
       String neweather = weatherTower.getWeather(coordinates);//returns current weather
       message(neweather);
       if (neweather.compareTo("RAIN") == 0)
           this.coordinates.setLongitute(this.coordinates.getLongitute() + 5);
       else if (neweather.compareTo("SUN") == 0){
           this.coordinates.setHieght(this.coordinates.getHieght() + 2);
           this.coordinates.setLongitute(this.coordinates.getLongitute() + 10);
       }
       else if (neweather.compareTo("SNOW") == 0){
           this.coordinates.setHieght(this.coordinates.getHieght() - 12);
       }
       else if (neweather.compareTo("FOG") == 0)
           this.coordinates.setLongitute(this.coordinates.getLongitute() + 1);

       if (this.coordinates.getHieght() == 0) {
           this.weatherTower.unregister(this);
           WriteToFile.openFile();
           WriteToFile.writeToFile("Helicopter#:"+ this.name + "(" + this.id + "): "+ "landing.");
           WriteToFile.writeToFile("Tower says: "+ "Helicopter#"+this.name + "("+this.id+") " + "unregistered from weather tower");
       }
   }
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        WriteToFile.openFile();
        WriteToFile.writeToFile("Tower says: " + "Helicopter#" + this.name + "(" + this.id + ") " + "registered to weather tower");
    }

}