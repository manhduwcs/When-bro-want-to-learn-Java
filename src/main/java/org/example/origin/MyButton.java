package org.example.origin;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButton extends JButton implements ActionListener {
    MyButton(String buttonText) {
        setFont(new Font("MV Boli", Font.PLAIN, 22));
        setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        setText(buttonText);
        setBackground(Color.gray);
        setForeground(Color.white);
        setFocusable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
