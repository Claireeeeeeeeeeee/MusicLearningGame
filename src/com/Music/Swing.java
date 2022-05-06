package com.Music;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Swing extends JFrame{
    Dimension tool = Toolkit.getDefaultToolkit().getScreenSize();
    private int monWidth = (int) tool.getWidth();
    private int monHeight = (int) tool.getHeight();
    int sizeModifier;

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

        ImageIcon image = new ImageIcon("pianoicon.png");
        JPanel sidePanel = new JPanel();
        JPanel centerPanel = new JPanel();
        Border border = BorderFactory.createLineBorder(Color.green,3);

        sidePanel.setBackground(new Color(0xfef3bd));
        sidePanel.setBounds(0,0,sidePanelSize,monHeight);
        sidePanel.setLayout(null);

        centerPanel.setBackground(Color.darkGray);
        centerPanel.setBounds(sidePanelSize,0,centerPanelSize,monHeight);
        centerPanel.setLayout(null);

        this.setLayout(null);
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(255,255,255));
        this.add(sidePanel);
        this.add(centerPanel);
    }

}
