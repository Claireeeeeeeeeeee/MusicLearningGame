package com.Music;

import java.util.Random;
import java.util.Scanner;

public class Main {
    //FOR GOD SAKES PLEASE MAKE THE SOUNDNAME EQUAL TO THE INSTANCE NAME
    //Default Sound object. Used to access Sound methods, and static variables
    static Sound sound = new Sound();
    Interval interval = new Interval();
    Random rand = new Random();

    public static void main(String[] args){
        sound.loadSound("cdp220r\\stgrpno","cdp220r_stgrpno.wav");
        Swing mygui = new Swing(2);
        mygui.swingEnable();
        Tui t = new Tui();
    }
}