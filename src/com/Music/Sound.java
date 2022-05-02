package com.Music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Sound {
    Random rand = new Random();
    Scanner input = new Scanner(System.in);
    String[] notes = {"cn", "cs", "dn", "ds", "en", "fn", "fs", "gn", "gs", "an", "as", "bn"};
    private String path;

    public void playRandomSound() {
        int octave = rand.nextInt(8);
        String note = notes[rand.nextInt(notes.length - 1)];
        path = System.getProperty("user.dir") +  "\\sounds\\cdp220r\\stgrpno\\" + octave + note + "_cdp220r_stgrpno.wav";
        try {
            File file = new File(path);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        }catch(FileNotFoundException e){
            System.out.println("File Not Found");
        }catch(UnsupportedAudioFileException e){
            System.out.println("Unsupported Audio File");
        }catch(LineUnavailableException e){
            System.out.println("Line Unavailable");
        }catch(IOException e){
            System.out.println("IO Exception");
        }
    }

    public void getSoundDir(){
        System.out.println(path);
    }

}
