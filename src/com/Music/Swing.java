package com.Music;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Swing extends JFrame implements ActionListener {
    Dimension tool = Toolkit.getDefaultToolkit().getScreenSize();
    JButton Interval;
    Sound sound = new Sound();
    Random rand = new Random();
    private int monWidth = (int) tool.getWidth();
    private int monHeight = (int) tool.getHeight();
    int sizeModifier;

    //Constructors
    Swing(int width, int height){
        this.monWidth = width;
        this.monHeight = height;
        swingEnable();
    }

    public String toString(){
        return monWidth + " " + monHeight;
    }

    Swing(int sizeModifier){
        this.sizeModifier = sizeModifier;
        this.monWidth = monWidth / sizeModifier;
        this.monHeight = monHeight / sizeModifier;
        swingEnable();
}

    public void swingEnable(){
      swingSettings();
      placeSwingElements();
    }

    //Methods
    public void swingSettings(){
        this.setVisible(true);
        this.setTitle("Gustav");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(monWidth, monHeight);
    }

    public void placeSwingElements(){
       int sidePanelSize = monWidth / 3;
       int centerPanelSize = monWidth - sidePanelSize;

        ImageIcon image = new ImageIcon("swing/pianoicon.png");
        JPanel sidePanel = new JPanel();
        JPanel centerPanel = new JPanel();
        Interval = new JButton();

        Interval.addActionListener(this);
        Interval.setBounds(0,0,130,50);
        Interval.setText("Test");
        Interval.setFocusable(false);

        sidePanel.setBackground(new Color(0xfef3bd));
        sidePanel.setBounds(0,0,sidePanelSize,monHeight);
        sidePanel.setLayout(null);

        centerPanel.setBackground(Color.darkGray);
        centerPanel.setBounds(sidePanelSize,0,centerPanelSize,monHeight);
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
