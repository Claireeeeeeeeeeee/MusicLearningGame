package com.Music;

import javax.swing.*;
import java.awt.*;

public class Swing extends JFrame{
    Dimension tool = Toolkit.getDefaultToolkit().getScreenSize();
    private int monWidth = (int) tool.getWidth();
    private int monHeight = (int) tool.getHeight();
    int sizeModifier;
    ImageIcon image = new ImageIcon("pianoicon.png");

    //Constructors

    Swing(int width, int height){
        this.monWidth = width;
        this.monHeight = height;
    }

    Swing(int sizeModifier){
        this.sizeModifier = sizeModifier;
        this.monWidth = monWidth / sizeModifier;
        this.monHeight = monHeight / sizeModifier;
}

    public void swingEnable(){
      this.setVisible(true);
      swingSettings();
      placeSwingElements();
    }

    //Methods

    public void swingSettings(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(monWidth, monHeight);
    }

    public void placeSwingElements(){
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(30,30,30));
    }

}
