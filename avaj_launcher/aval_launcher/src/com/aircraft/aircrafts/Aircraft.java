package com.aircraft.aircrafts;

import com.aircraft.tower.WriteToFile;
import java.util.HashMap;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    static long idCounter = 1;

    protected Aircraft(String name, Coordinates coordinates){
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    public long nextId(){
        this.idCounter += 1;
        return (this.idCounter);
    }

    public void message(String neweather){
        HashMap<String, String> messages = new HashMap<String, String>();
        messages.put("RAIN", "Wow, rain is couzy");
        messages.put("SUN", "Well come to Africa");
        messages.put("SNOW", "White walker are here!");
        messages.put("FOG", "I cant see nothing");
        WriteToFile.openFile();
        WriteToFile.writeToFile(this.getClass().getSimpleName() + "#"
                + this.name + "(" + this.id + "): " + messages.get(neweather));
    }

}
