package com.Music;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Sound sound = new Sound("cdp220r\\stgrpno", "cdp220r_stgrpno.wav");
    Interval interval = new Interval();
    Random rand = new Random();

    public static void main(String[] args){
        new Swing(2);
        new Tui();
    }
}