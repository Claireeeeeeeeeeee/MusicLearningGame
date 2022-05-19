package com.music.swing;


import com.music.sound.Sound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Swing extends JFrame implements ActionListener {
    String whiteKey = "assets\\graphic\\virtualpiano\\png\\whitekey1.png";
    String blackKey = "assets\\graphic\\virtualpiano\\png\\blackkey1.png";
    static JPanel sidePanel = new JPanel();
    static JPanel centerPanel = new JPanel();
    Dimension tool = Toolkit.getDefaultToolkit().getScreenSize();
    JButton Interval;
    Sound sound = new Sound();
    Random rand = new Random();
    PianoKey key1;
    PianoKey key2;

    //is monitor resolution by default
    private int screenWidth = (int) tool.getWidth();
    private int screenHeight = (int) tool.getHeight();

    Swing(int width, int height){
        this.screenWidth = width;
        this.screenHeight = height;
        swingEnable();
    }

    public Swing(double sizeModifier){
        this.screenWidth = (int) (screenWidth / sizeModifier);
        this.screenHeight = (int) ( screenHeight / sizeModifier);
        swingEnable();
}

    public Swing() {

    }

    public String toString(){
        return screenWidth + " " + screenHeight;
    }

    public void swingEnable(){
      swingSettings();
      placeSwingElements();
    }

    public void swingSettings(){
        this.setVisible(true);
        this.setTitle("Gustav");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(screenWidth, screenHeight);
    }

    public void placeSwingElements(){
        Interval = new JButton();
        key1 = new PianoKey(blackKey, 100,50,50,50,true);
        key2 = new PianoKey(whiteKey, 50, 50, 50,50,true);

       int sidePanelSize = screenWidth / 3;
       int centerPanelSize = screenWidth - sidePanelSize;

        ImageIcon image = new ImageIcon("swing/pianoicon.png");

        Interval.addActionListener(this);
        Interval.setBounds(0,0,130,50);
        Interval.setText("Test");
        Interval.setFocusable(false);

        sidePanel.setBackground(new Color(0xfef3bd));
        sidePanel.setBounds(0,0,sidePanelSize, screenHeight);
        sidePanel.setLayout(null);

        centerPanel.setBackground(Color.darkGray);
        centerPanel.setBounds(sidePanelSize,0,centerPanelSize, screenHeight);
        centerPanel.setLayout(null);
        centerPanel.add(Interval);

        this.setLayout(null);
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(255,255,255));
        this.add(sidePanel);
        this.add(centerPanel);
    }

    //Listeners
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==Interval){
            sound.playSound(rand.nextInt(88));
        }
    }

}
