package com.Music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;



public class Main {

    public static String getRandomNotePath() {
        Random rand = new Random();
        String[] validNotes = {"cn", "cs", "dn", "ds", "en", "fn", "fs", "gn", "gs", "an", "as", "bn"};
        
        //These two are here because there are not 12 valid notes in octaves 0 or 8
        String[] validLowNotes = {"an", "as", "bn"};
        String[] validHighNotes = {"cn"};

        int octave;
        String note;

        octave = rand.nextInt(8);
        
        if (octave == 0) {
            note = validLowNotes[rand.nextInt(validLowNotes.length)];
        } else if (octave == 8) {
            note = validHighNotes[rand.nextInt(validHighNotes.length)];

        } else {
            note = validNotes[rand.nextInt(validNotes.length)];
        }

        System.out.println(octave);

        System.out.println(note);

        System.out.println(System.getProperty("user.dir"));
        String path = System.getProperty("user.dir") +  "\\sounds\\cdp220r\\stgrpno\\" + octave + note + "_cdp220r_stgrpno.wav";
        System.out.println(path);

        return path;
    }
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException{

        boolean monkeyMode = false; //Only activate in zoos

        System.out.println("\n\n\n");
        try {
            while (true) {
                String path = getRandomNotePath();
                File file = new File(path);
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
                if (monkeyMode == false) {
                    //Anti-Monkey Measures
                    while(clip.getMicrosecondLength() != clip.getMicrosecondPosition()) {}
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("File Not Found");
        }
    }
}
