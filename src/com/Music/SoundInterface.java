package com.Music;

public interface SoundInterface {

    //Plays a random sound
    public void playRandomSound();

    //Gets the directory of the last played sound
    public void getSoundDir();

    //Place the notes in order from 0 to 88 in an array
    public void toNoteNumber();

    //Subtract highest number from lowest number to get interval size
    public int compareNotes();


}
