package com.aircraft.simulator;

import com.aircraft.aircrafts.AircraftFactory;
import com.aircraft.aircrafts.Baloon;
import com.aircraft.tower.Tower;
import com.aircraft.tower.WeatherTower;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * To compile my structure : find *.java ../tower *.java ../aircrafts *.java > sources.txt
 */
public class Main{
    public static void main(String[] args) {
       WeatherTower weatherTower = new WeatherTower();
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
            String line = bufferedReader.readLine();
            if (line != null) {
                int simulationOccurrence = Integer.parseInt(line.split(" ")[0]);
                if (simulationOccurrence < 0) {
                    System.out.println("Outter-sphire " + simulationOccurrence);
                    System.exit(1);
                }
                while ((line = bufferedReader.readLine()) != null) {
                    try{
                        Flyable newAircraft = AircraftFactory.newAircraft(
                          line.split(" ")[0],
                          line.split(" ")[1],
                          Integer.parseInt(line.split(" ")[2]),
                          Integer.parseInt(line.split(" ")[3]),
                          Integer.parseInt(line.split(" ")[4]));
                          weatherTower.runSimulation(simulationOccurrence);
                          newAircraft.registerTower(weatherTower);
                          int i = 0;
                          while (i++ < simulationOccurrence)
                            newAircraft.updateConditions();
                    }catch (Exception e){
                     System.out.println(e.getMessage());
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("====== AIRPORT TOWER =========");
    }
}
