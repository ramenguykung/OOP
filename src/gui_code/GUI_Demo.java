package gui_code;

import java.net.*;
import java.awt.*; 
import javax.swing.*;

public class GUI_Demo extends JFrame{
    public static void main(String[] args) {
        URL bgURL = getClass().getResource("null");
        URL actorURL = getClass().getResource("");
        Image bgImg = new ImageIcon(bgURL).getImage();
    }
}