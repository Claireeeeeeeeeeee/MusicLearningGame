package com.Music;

import java.util.Random;

public class Interval extends Sound{
    Random rand = new Random();
    static int intervalSize;


    //plays two notes, and compares the two
    //Warning: Currently throws OutOfBounds due to the first note being too low
    //Will fix later I'm tired
    @Override
    public void playSound() throws ArrayIndexOutOfBoundsException {
        int note1 = rand.nextInt(88);
        int note2 = note1 - rand.nextInt(13);
        intervalSize = note1 - note2;
        super.playSound(note1);
        super.playSound(note2);
        System.out.println(intervalSize);
    }

    //User guesses the interval and is asked if they want to try again
    public void guessInterval(){

    }

}
