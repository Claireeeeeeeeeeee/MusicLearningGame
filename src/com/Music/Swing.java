package com.Music;

import javax.swing.*;
import java.awt.*;

public class Swing {
    JFrame frame = new JFrame("Gustav");
    Dimension tool = Toolkit.getDefaultToolkit().getScreenSize();
    private int monWidth = (int) tool.getWidth();
    private int monHeight = (int) tool.getHeight();
    int sizeModifier;

    ImageIcon image = new ImageIcon("pianoicon.png");

    Swing(){

    }

    Swing(int height, int width){
        this.monHeight = height;
        this.monWidth = width;
    }

    Swing(int sizeModifier){
        this.sizeModifier = sizeModifier;
}

    public void swingEnable(){
      frame.setVisible(true);
      swingSettings();
      placeSwingElements();
    }

    public void swingSettings(){
        try {
            int scaledMonWidth = monWidth / sizeModifier;
            int scaledMonHeight = monHeight / sizeModifier;
            frame.setSize(scaledMonWidth, scaledMonHeight);
            frame.setIconImage(image.getImage());
        }catch(ArithmeticException e) {
            int scaledMonWidth = monWidth;
            int scaledMonHeight = monHeight;
            frame.setIconImage(image.getImage());
            frame.setSize(scaledMonWidth, scaledMonHeight);

        }finally{
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
    }

    public void placeSwingElements(){

    }

}
