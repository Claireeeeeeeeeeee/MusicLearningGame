package com.Music;

import java.util.Scanner;

public class Tui extends Main {
    Scanner input = new Scanner(System.in);
    static String selected;

    Tui(){
        select();
    }

    public void select() {
        char select;
        while (true) {
            System.out.println("M: ManualSound\nR: RandomSound\nI: Interval\nQ: Quit\nT: ToString");
            select = input.next().toUpperCase().charAt(0);
            switch (select) {
                case 'R' -> sound.playSound(rand.nextInt(88));
                case 'D' -> System.out.println(Sound.getPath());
                case 'M' -> sound.playSound(input.nextInt());
                case 'Q' -> {
                    System.out.println("Quitting");
                    System.exit(0);
                }
                case 'I' -> interval.playGame();
                case 'T' -> System.out.println(sound);
                default -> System.out.println("Invalid Option\n");
            }
        }
    }
}
