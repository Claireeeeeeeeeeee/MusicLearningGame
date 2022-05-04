package com.Music;

import java.util.Random;

public class Interval extends Sound{
    Random rand = new Random();
    static int intervalSize;


    //plays two notes, and compares the two
    @Override
    public void playSound(){
        int note1 = rand.nextInt(75) + 12;
        int note2 = note1 - rand.nextInt(1,13);
        intervalSize = note1 - note2;
        System.out.println(note1 + " " + note2);
        super.playSound(note1);
        super.playSound(note2);
    }

    //User guesses the interval and is asked if they want to try again
    public void playResponse(){
        System.out.println("1:Minor Second\n2:Major Second\n 3:Minor Third\n4:Major Third\n5:Fourth\n6:Tritone 7:Fifth\n" +
                "8:Augmented\n9:Sixth\n10:Dominant Seventh\n11:Major Seventh\n12:Octave");
        int answer = input.nextInt();
        if(answer == intervalSize){
            System.out.println("You Win! Would you like to try again?");
            answer = input.next().toUpperCase().charAt(0);
            if(answer == 'Y'){
                playGame();
            }else{
                return;
            }
        }
    }

    public void playGame(){
        playSound();
        playResponse();
    }

}
