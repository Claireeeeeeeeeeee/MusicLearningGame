package com.Music;

import java.util.Random;
import java.util.Scanner;

public class Tui {
    Sound sound = new Sound();
    Random rand = new Random();
    Swing mygui = new Swing(2);
    Interval interval = new Interval();

    Tui(){
        select();
    }

    public void select() {
        char select = 0;
        while (true) {
            System.out.println("M: ManualSound\nR: RandomSound:\nI: Interval\nG: GUI\nQ: Quit");
            Scanner input = new Scanner(System.in);
            select = input.next().toUpperCase().charAt(0);
            switch (select) {
                case 'R':
                    sound.playSound(rand.nextInt(88));
                    break;
                case 'D':
                    sound.getSoundDir();
                    break;
                case 'M':
                    sound.playSound();
                    break;
                case 'G':
                    mygui.swingEnable();
                    break;
                case 'Q':
                    System.out.println("Quitting");
                    System.exit(0);
                    break;
                case 'I':
                    interval.playGame();
                    break;
                default: System.out.println("Invalid Option");
                break;
            }
        }
    }
}
