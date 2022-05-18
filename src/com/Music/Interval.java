package com.Music;

import org.w3c.dom.ls.LSOutput;

import java.util.InputMismatchException;
import java.util.Random;

public class Interval extends Sound{
    Random rand = new Random();
    static int intervalSize;

    static int note1;
    static int note2;


    //plays two notes, and compares the two
    public void playSound(){
        note2 = rand.nextInt(75) + 12;
        note1 = note2 - rand.nextInt(1,13);
        intervalSize = note2 - note1;
        System.out.println("DEBUG: " + note2 + " " + note1);
        super.playSound(note1);
        super.playSound(note2);
    }

    public void replaySound(){
        super.playSound(note1);
        super.playSound(note2);
    }

    //User guesses the interval and is asked if they want to try again
    public void playResponse(){
        try {
            System.out.println("1:Minor Second\n2:Major Second\n3:Minor Third\n4:Major Third\n5:Fourth\n6:Tritone\n7:Fifth\n" +
                    "8:Augmented\n9:Sixth\n10:Dominant Seventh\n11:Major Seventh\n12:Octave");
            int answer = input.nextInt();
            if (answer == intervalSize) {
                System.out.print("You Win!");
            } else if(answer == 13){
                replaySound();
                playResponse();
            } else{
                System.out.println("You Lose!");
            }
            System.out.println(" Would you like to try again\nY: Yes\nN: No");
            answer = input.next().toUpperCase().charAt(0);
            if (answer == 'Y') {
                playGame();
            } else {
                return;
            }
        }catch(InputMismatchException e){
            System.err.println("Input Mismatch Exception: Returning to menu");
        }
    }

    public void playGame() throws InputMismatchException {
        playSound();
        playResponse();
    }

}
