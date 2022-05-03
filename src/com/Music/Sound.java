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

public class Sound implements SoundInterface {
    Random rand = new Random();
    Scanner input = new Scanner(System.in);
    String[] validNotes = {"cn", "cs", "dn", "ds", "en", "fn", "fs", "gn", "gs", "an", "as", "bn"};
    String[] validLowNotes = {"an", "as", "bn"};
    String[] validHighNotes = {"cn"};
    private static String[] keyboardLength = new String[88];
    private String path;

    public void playSound(){
        try {
            File file = new File(keyboardLength[input.nextInt()]);
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

    @Override
    public void noteToNumber() {
        path = "";
        File file = new File(path);
        int i =0;

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
    }

    @Override
    public int compareNotes() {
        return 0;
    }

}
