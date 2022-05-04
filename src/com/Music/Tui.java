package com.Music;

import java.util.Random;
import java.util.Scanner;

public class Tui {
    Sound sound = new Sound();
    Random rand = new Random();
    Swing mygui = new Swing(2);

    Tui(){
        select();
    }

    public void select() {
        char select = 0;
        while (select != 'Q') {
            System.out.println("R: PlayRandomSound D: CurrentPath M: PlayManualSound G: GUI");
            Scanner input = new Scanner(System.in);
            select = input.next().charAt(0);
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
                default: System.out.println("Invalid Option");
                break;
            }
        }
    }
}
