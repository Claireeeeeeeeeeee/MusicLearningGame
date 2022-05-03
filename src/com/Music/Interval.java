package com.Music;

public class Interval extends Sound{
    private int intervalDistance;
    private String note1, note2;

    //GETTERS
    public int getIntervalDistance(){
        return intervalDistance;
    }

    //SETTERS
    public void setIntervalDistance(int distance){
        this.intervalDistance = distance;
    }

    //Plays two sounds, places the note names in a field, and returns the distance between the two sounds
    public void compareInterval(){

    }

    //User guesses the interval and is asked if they want to try again
    public void chooseInterval(){

    }

}
