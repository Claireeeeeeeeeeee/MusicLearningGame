package com.Music;

import java.util.Random;
import java.util.Scanner;

public class Main {
    //FOR GOD SAKES PLEASE MAKE THE SOUNDNAME EQUAL TO THE INSTANCE NAME
    //Default Sound object. Used to access Sound methods, and static variables
    Sound cdp220r_stgrpno = new Sound("cdp220r\\stgrpno","cdp220r_stgrpno.wav",true);
    Swing mygui = new Swing(2);
    Scanner input = new Scanner(System.in);
    Interval interval = new Interval();
    Random rand = new Random();

    public static void main(String[] args){
        Tui t = new Tui();
    }
}