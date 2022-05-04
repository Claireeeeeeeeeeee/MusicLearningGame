package com.Music;

public class Main {

    public static void main(String[] args){
        Sound sound = new Sound();
        sound.noteToNumber();
        //Bryson, please don't remove the noteToNumber method and then wonder why you can't manually play notes from the array.
        Tui t = new Tui();
    }
}