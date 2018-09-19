package com.aircraft.tower;

import com.aircraft.simulator.Flyable;
import java.util.ArrayList;

public class Tower{
    private ArrayList<Flyable> observers = new ArrayList<>();
    public void register(Flyable flyable){
        try {
            observers.add(flyable);
        }catch (Exception e) {
            unregister(flyable);
        }
    }
    public void unregister(Flyable flyable){
        try {
            observers.remove(flyable);
        }catch (Exception e){
            e.getMessage();
        }
    }
    protected void conditionsChanged(){
        for(int i = 0; observers.size() < 0; i++)
            observers.get(i).updateConditions();
    }
}