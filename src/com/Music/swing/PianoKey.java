package com.music.swing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PianoKey extends Swing {
    int keyID;
    JLabel pic;
    static String path = "";

    //Location of image, and coordinates
    //Currently unused
    public PianoKey(String path, int x, int y, int width, int height, boolean visible) {
        try {
            String keyPath = System.getProperty("user.dir") + "\\" + path;
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

    public PianoKey(int id){
        this.keyID = id;
    }

    public PianoKey(){

    }

    public void setKeyID(int id){
        this.keyID = id;
    }

    public int getKeyID(){
        return this.keyID;
    }

    public void setKey(String path, int x, int y, int width, int height) {
        try {
            String keyPath = System.getProperty("user.dir") + "\\" + path;
            System.out.println("New Key" + pianoSize +":" + " " + keyPath);
            BufferedImage myPicture = ImageIO.read(new File(keyPath));
            pic = new JLabel(new ImageIcon(myPicture));
            pic.setBounds(x, y, width, height);
            centerPanel.add(pic);
        }catch(IOException e){
            e.getMessage();
        }
    }

    public void setVisible(boolean value){
        pic.setVisible(value);
    }

    //Darken or highlight the key
    public void keyDown(){
        System.out.println("Key Down");
    }

    //Return the key to original state
    public void keyUp(){

    }

}
