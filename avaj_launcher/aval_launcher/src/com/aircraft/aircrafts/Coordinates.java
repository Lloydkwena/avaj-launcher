package com.aircraft.aircrafts;

public class Coordinates{
    private int longitute;
    private int latidute;
    private int hieght;

    Coordinates(int longitute, int latidute, int hieght){
        this.longitute = longitute;
        this.latidute = latidute;
        this.hieght = hieght;
    }

    public int getLongitute() {return longitute;}

    public void setLongitute(int longitute) {
        this.longitute = longitute;
    }

    public int getLatidute() {
        return latidute;
    }

    public void setLatidute(int latidute) {
        this.latidute = latidute;
    }

    public int getHieght() {
        return hieght;
    }

    public void setHieght(int hieght) {
        this.hieght = hieght;
    }
}
