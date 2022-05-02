package com.Music;

import javax.swing.*;
import java.awt.*;

public class Swing {
    JFrame frame = new JFrame();
    Dimension tool = Toolkit.getDefaultToolkit().getScreenSize();
    private final int scaledMonWidth = (int) tool.getWidth() / 2;
    private final int scaledMonHeight = (int) tool.getHeight() / 2;

    public void swingEnable(){
        System.out.println("Resolution is " + scaledMonWidth + " " + scaledMonHeight);
      frame.setVisible(true);
      swingSettings();
      placeSwingElements();
    }

    public void swingSettings(){
        frame.setSize(scaledMonWidth, scaledMonHeight);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void placeSwingElements(){

    }

}
