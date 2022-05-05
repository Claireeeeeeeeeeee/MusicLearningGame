package com.Music;

import java.util.Random;
import java.util.Scanner;

public class Tui extends Main {
    Random rand = new Random();
    Swing mygui = new Swing(2);
    Interval interval = new Interval();
    Scanner input = new Scanner(System.in);
    static String selected;

    Tui(){
        chooseInstrument();
        select();
    }


    public void chooseInstrument(){
        try {
            for (int i = 0; i <= cdp220r_stgrpno.soundFont.size() - 1; i++)
                System.out.println("Choose a soundfont:\n" + i + 1 + ":" + " " + cdp220r_stgrpno.soundFont.get(i));
            selected = cdp220r_stgrpno.soundFont.get(input.nextInt() - 1);
            System.out.println("Selected " + selected + "\n");
        }catch(IndexOutOfBoundsException e){
            System.err.println("Index Out Of Bounds: " + e.getMessage() + "\nSoundfont not found");
            chooseInstrument();
        }
    }

    public void select() {
        char select = 0;
        while (true) {
            System.out.println("M: ManualSound\nR: RandomSound\nI: Interval\nG: GUI\nQ: Quit");
            select = input.next().toUpperCase().charAt(0);
            switch (select) {
                case 'R':
                    cdp220r_stgrpno.playSound(rand.nextInt(88));
                    break;
                case 'D':
                    cdp220r_stgrpno.getSoundDir();
                    break;
                case 'M':
                    cdp220r_stgrpno.playSound();
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
                default:
                    System.out.println("Invalid Option\n");
                break;
            }
        }
    }
}
