package com.Music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Sound {
    Random rand = new Random();
    Scanner input = new Scanner(System.in);
    String[] validNotes = {"cn", "cs", "dn", "ds", "en", "fn", "fs", "gn", "gs", "an", "as", "bn"};
    String[] validLowNotes = {"an", "as", "bn"};
    String[] validHighNotes = {"cn"};
    private static String[] keyboardLength = new String[88];
    private String path;

    public void playSound(){
        int i = input.nextInt();
        path = keyboardLength[i];
        try {
            File file = new File(keyboardLength[i]);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        }catch(FileNotFoundException e){
            System.err.println("File Not Found: " + e.getMessage());
        }catch(UnsupportedAudioFileException e){
            System.err.println("Unsupported Audio File: " + e.getMessage());
        }catch(LineUnavailableException e){
            System.err.println("Line Unavailable: " + e.getMessage());
        }catch(IOException e){
            System.err.println("IO Exception: " + e.getMessage());
        }catch(ArrayIndexOutOfBoundsException e){
            System.err.println("Array index out of bounds: " + e.getMessage());
        }
    }

    public void playRandomSound() {
        int octave = rand.nextInt(8);
        String note;

        if (octave == 0) { note = validLowNotes[rand.nextInt(validLowNotes.length)]; }
        else if (octave == 8) {note = validHighNotes[rand.nextInt(validHighNotes.length)];}
        else {note = validNotes[rand.nextInt(validNotes.length)];}
        
        path = System.getProperty("user.dir") +  "\\sounds\\cdp220r\\stgrpno\\" + octave + note + "_cdp220r_stgrpno.wav";
        try {
            File file = new File(path);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        }catch(FileNotFoundException e){
            System.err.println("File Not Found: " + e.getMessage());
        }catch(UnsupportedAudioFileException e){
            System.err.println("Unsupported Audio File: " + e.getMessage());
        }catch(LineUnavailableException e){
            System.err.println("Line Unavailable: " + e.getMessage());
        }catch(IOException e){
            System.err.println("IO Exception:" + e.getMessage());
        }
    }

    public void getSoundDir(){
        System.out.println(path);
    }

    public void noteToNumber() {
        path = "";
        File file = new File(path);
        int i = 0;

            for (int octave = 0; octave <= 8; octave++) {
                for (int noteName = 0; noteName <= validNotes.length - 1; noteName++) {
                    path = System.getProperty("user.dir") + "\\sounds\\cdp220r\\stgrpno\\" + octave + validNotes[noteName] + "_cdp220r_stgrpno.wav";
                    Path myPath = Paths.get(path);
                    if(Files.notExists(myPath)){
                        continue;
                    }
                        keyboardLength[i] = path;
                    System.out.println(keyboardLength[i]);
                        i++;
                }
            }
        System.out.println("Loaded Sounds");
    }
}
