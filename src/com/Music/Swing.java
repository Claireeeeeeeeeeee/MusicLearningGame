package com.Music;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

public class Swing extends JFrame implements ActionListener {
    static JPanel sidePanel = new JPanel();
    static JPanel centerPanel = new JPanel();
    Dimension tool = Toolkit.getDefaultToolkit().getScreenSize();
    JButton Interval;
    Sound sound = new Sound();
    Random rand = new Random();

    //is monitor resolution by default
    private int screenWidth = (int) tool.getWidth();
    private int screenHeight = (int) tool.getHeight();

    Swing(int width, int height){
        this.screenWidth = width;
        this.screenHeight = height;
        swingEnable();
    }

    Swing(double sizeModifier){
        this.screenWidth = (int) (screenWidth / sizeModifier);
        this.screenHeight = (int) ( screenHeight / sizeModifier);
        swingEnable();
}

    Swing() {

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
        String whiteKey = "swing\\virtualpiano\\png\\whitekey1.png";
        String blackKey = "swing\\virtualpiano\\png\\blackkey1.png";
       int sidePanelSize = screenWidth / 3;
       int centerPanelSize = screenWidth - sidePanelSize;

        ImageIcon image = new ImageIcon("swing/pianoicon.png");
        Interval = new JButton();
        try {
            PianoKey key1 = new PianoKey(whiteKey, 20, 150,20,50);
            PianoKey key2 = new PianoKey(blackKey, 40, 150, 20, 50);
        }catch(IOException e){
            e.getMessage();
        }

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
