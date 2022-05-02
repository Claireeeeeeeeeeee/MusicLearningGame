package com.Music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException{
        Random rand = new Random();
        String[] notes = {"cn", "cs", "dn", "ds", "en", "fn", "fs", "gn", "gs", "an", "as", "bn"};
        //char[] notes = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        //char[] accidentals = {'n','s'};
        //char[] notesThatCanBeSharp = {'c'}
        //lmao
        int octave;
        String note;

        octave = rand.nextInt(8);
        note = notes[rand.nextInt(notes.length)];
        System.out.println(octave);

        Scanner input = new Scanner(System.in);

        //System.out.println(System.getProperty("user.dir"));
        String path = System.getProperty("user.dir") + "\\sounds\\cdp220r\\stgrpno\\3an_cdp220r_stgrpno.wav";
        System.out.println(path);
        try {
            File file = new File(path);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            input.next();
            input.close();
        }catch(FileNotFoundException e){
            System.out.println("File Not Found");
        }
    }
}
