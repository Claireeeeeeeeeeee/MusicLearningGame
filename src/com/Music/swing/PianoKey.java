package com.music.swing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PianoKey extends Swing {
    String keyPath;
    int x,y;
    JLabel pic;

    //Location of image, and coordinates
    public PianoKey(String path, int x, int y, int width, int height, boolean visible) {
        try {
            keyPath = System.getProperty("user.dir") + "\\" + path;
            System.out.println("key location: " + keyPath);
            this.x = x;
            this.y = y;
            BufferedImage myPicture = ImageIO.read(new File(path));
            pic = new JLabel(new ImageIcon(myPicture));
            pic.setBounds(x, y, width, height);
            if (!visible) {
                pic.setVisible(false);
            } else centerPanel.add(pic);
        }catch(IOException e){
            e.getMessage();
        }
    }

    public void setVisible(boolean value){
        pic.setVisible(value);
    }

    public void keyDown(){

    }

    public void keyUp(){

    }

}
