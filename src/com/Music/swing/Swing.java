package com.music.swing;

import com.music.sound.Sound;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Swing extends JFrame implements ActionListener {
    ArrayList<PianoKey> keyArr = new ArrayList<PianoKey>();
    String whiteKey = "assets\\graphic\\virtualpiano\\png\\whitekey1.png";
    String blackKey = "assets\\graphic\\virtualpiano\\png\\blackkey1.png";
    static JPanel sidePanel = new JPanel();
    static JPanel centerPanel = new JPanel();
    Dimension tool = Toolkit.getDefaultToolkit().getScreenSize();
    JButton Interval;
    Sound sound = new Sound();
    Random rand = new Random();
    PianoKey[] key;
    static int pianoSize = 0;

    //is monitor resolution by default
    private int screenWidth = (int) tool.getWidth();
    private int screenHeight = (int) tool.getHeight();

    Swing(int width, int height) {
        this.screenWidth = width;
        this.screenHeight = height;
        swingEnable();
    }

    public Swing(double sizeModifier) {
        this.screenWidth = (int) (screenWidth / sizeModifier);
        this.screenHeight = (int) (screenHeight / sizeModifier);
        swingEnable();
    }

    public Swing() {

    }

    public String toString() {
        return screenWidth + " " + screenHeight;
    }

    public void swingEnable() {
        swingSettings();
        makePiano();
        placeSwingElements();
    }

    public void swingSettings() {
        this.setSize(screenWidth, screenHeight);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("Gustav");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }

    public void placeSwingElements() {
        Interval = new JButton();
        int sidePanelSize = screenWidth / 3;
        int centerPanelSize = screenWidth - sidePanelSize;

        ImageIcon image = new ImageIcon("assets/graphic/pianoicon.png");

        Interval.addActionListener(this);
        Interval.setBounds(0, 0, 130, 50);
        Interval.setText("Test");
        Interval.setFocusable(false);

        sidePanel.setBackground(new Color(0xfef3bd));
        sidePanel.setBounds(0, 0, sidePanelSize, screenHeight);
        sidePanel.setLayout(null);

        centerPanel.setBackground(Color.darkGray);
        centerPanel.setBounds(sidePanelSize, 0, centerPanelSize, screenHeight);
        centerPanel.setLayout(null);
        centerPanel.add(Interval);

        this.setLayout(null);
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.add(sidePanel);
        this.add(centerPanel);
    }

    public void makePiano() {
        String whiteKey = "assets\\graphic\\virtualpiano\\png\\whitekey1.png";
        String blackKey = "assets\\graphic\\virtualpiano\\png\\blackkey1.png";
        int x=10;
        int y=screenHeight - 200;
        int whiteKeyWidth=10;
        int whiteKeyHeight=50;
        int blackKeyWidth=10;
        int blackKeyHeight=35;

        //Create Keys
        for (int i=0; i <=87; i++) {
            keyArr.add(new PianoKey(i));
        }

        pianoloop:
        for(int note=0; note<=11;note++){
            switch(note){
                case 0 -> {
                    keyArr.get(note).setKey(whiteKey, x, y, whiteKeyWidth, whiteKeyHeight);
                    x += whiteKeyWidth;
                }
                case 1 -> {
                    keyArr.get(note).setKey(blackKey, x, y, blackKeyWidth, blackKeyHeight);
                    keyArr.get(note).setVisible(true);
                    x += whiteKeyWidth;
                }
                case 2 -> {
                    keyArr.get(note).setKey(whiteKey, x, y, whiteKeyWidth, whiteKeyHeight);
                    keyArr.get(note).setVisible(true);
                    x += whiteKeyWidth;
                }
                case 3 -> {
                    keyArr.get(note).setKey(whiteKey, x, y, whiteKeyWidth, whiteKeyHeight);
                    keyArr.get(note).setVisible(true);
                    x += whiteKeyWidth;
                }
                case 4 -> {
                    keyArr.get(note).setKey(blackKey, x, y, blackKeyWidth, blackKeyHeight);
                    keyArr.get(note).setVisible(true);
                    x += whiteKeyWidth;
                }
                case 5 -> {
                    keyArr.get(note).setKey(whiteKey, x, y, whiteKeyWidth, whiteKeyHeight);
                    keyArr.get(note).setVisible(true);
                    x += whiteKeyWidth;
                }
                case 6 -> {
                    keyArr.get(note).setKey(blackKey, x, y, blackKeyWidth, blackKeyHeight);
                    keyArr.get(note).setVisible(true);
                    x += whiteKeyWidth;
                }
                case 7 -> {
                    keyArr.get(note).setKey(whiteKey, x, y, whiteKeyWidth, whiteKeyHeight);
                    keyArr.get(note).setVisible(true);
                    x += whiteKeyWidth;
                }
                case 8 -> {
                    keyArr.get(note).setKey(whiteKey, x, y, whiteKeyWidth, whiteKeyHeight);
                    keyArr.get(note).setVisible(true);
                    x += whiteKeyWidth;
                }
                case 9 -> {
                    keyArr.get(note).setKey(blackKey, x, y, blackKeyWidth, blackKeyHeight);
                    keyArr.get(note).setVisible(true);
                    x += whiteKeyWidth;
                }
                case 10 -> {
                    keyArr.get(note).setKey(whiteKey, x, y, whiteKeyWidth, whiteKeyHeight);
                    keyArr.get(note).setVisible(true);
                    x += whiteKeyWidth;
                }
                case 11 -> {
                    keyArr.get(note).setKey(blackKey, x, y, blackKeyWidth, blackKeyHeight);
                    keyArr.get(note).setVisible(true);
                    x += whiteKeyWidth;
                }
            }

            if(pianoSize == 87){
                break pianoloop;
            }
            pianoSize++;
            if(note == 11){
                note = -1;
            }
        }
    }

    //Listeners
    @Override
    public void actionPerformed(ActionEvent e) {
        int note = rand.nextInt(88);
        if (e.getSource() == Interval) {
            sound.playSound(note);
            for(int i=0;i<=87;i++){
                if(keyArr.get(i).getKeyID() == note){
                    System.out.println(keyArr.get(i).getKeyID());
                }
            }
        }
    }
}
