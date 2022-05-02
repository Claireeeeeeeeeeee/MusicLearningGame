package com.Music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException{
        Random rand = new Random();
        char[] notes = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        char[] accidentals = {'n','s'};
        int octave;

        octave = rand.nextInt(8);
        System.out.println(octave);

        Scanner input = new Scanner(System.in);
        String path = "C:\\Users\\Bryson\\Documents\\cdp220r\\stgrpno\\" + octave + "cn_cdp220r_stgrpno.wav";
        File file = new File(path);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
        input.next();
    }
}
