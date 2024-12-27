package org.example.origin;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame(String title, int width, int height) {
        super(title);
        setSize(width, height);
//        setVisible(true); can only be called as the final step of the code execution
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
