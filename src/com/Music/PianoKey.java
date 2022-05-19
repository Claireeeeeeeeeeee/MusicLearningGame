package com.Music;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PianoKey extends Swing {
    String keyPath;
    int x,y;

    //Location of image, and coordinates
    public PianoKey(String path, int x, int y, int width, int height) throws IOException {
        keyPath = System.getProperty("user.dir") + "\\" + path;
        System.out.println("key location: " + keyPath);
        this.x = x;
        this.y = y;
        BufferedImage myPicture = ImageIO.read(new File(path));
        JLabel pic = new JLabel(new ImageIcon(myPicture));
        pic.setBounds(x,y,width,height);
        centerPanel.add(pic);
    }

    public void keyDown(){

    }

    public void keyUp(){

    }

}
