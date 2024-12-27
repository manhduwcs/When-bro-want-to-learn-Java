package org.example.origin.studentManagementProject.view;

import javax.swing.*;
import java.awt.*;

public class UserView extends JFrame {
    private JPanel contentPane;
    private JPanel informationPanel;
    private JLabel userName;
    private JLabel showName;
    private JLabel userAge;
    private JLabel showAge;
    private JPanel editUserPanel;
    private JPanel buttonControlPanel;
    private JLabel editUserName;
    private JTextField editUserNameTextField;
    private JLabel editUserAge;
    private JTextField editUserAgeTextField;
    private JButton showUserButton;
    private JButton stopUserShowingButton;
    private JButton confirmEditButton;
    private JButton resetEditButton;

    private Font myFont = new Font("MV Boli", Font.PLAIN, 22);
    private Image img = new ImageIcon("src/main/resources/avtCat.jpg").getImage();

    public UserView() {
        informationPanel.setBackground(Color.pink);
        buttonControlPanel.setBackground(Color.pink);
        editUserPanel.setBackground(Color.orange);
        // set text field
        setTextFieldSetting(editUserAgeTextField, editUserNameTextField);

        // set label settings
        setAllLabels(userName, showName, userAge, showAge, editUserAge, editUserName);

        // set button setting
        setButtonSetting(showUserButton, stopUserShowingButton, confirmEditButton, resetEditButton);

        // set Frame setting
        setContentPane(contentPane);
        setTitle("User Application");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void setAllLabels(JLabel... labels) {
        for (JLabel label : labels) {
            label.setFont(myFont);
            label.setBackground(Color.cyan);
        }
    }

    public void setTextFieldSetting(JTextField... txtFields) {
        for (JTextField f : txtFields) {
            f.setFont(myFont);
            f.setBackground(Color.gray);
        }
    }

    public void setButtonSetting(JButton... buttons) {
        for (JButton b : buttons) {
            b.setFont(myFont);
            b.setBorder(BorderFactory.createEtchedBorder());
            b.setBackground(Color.black);
            b.setForeground(Color.white);
            b.setFocusable(false);
        }
    }

//    public static void main(String[] args) {
//        new UserView();
//    }

    public JLabel showName() {
        return showName;
    }

    public JLabel showAge() {
        return showAge;
    }

    public JTextField editUserNameTextField() {
        return editUserNameTextField;
    }

    public JTextField editUserAgeTextField() {
        return editUserAgeTextField;
    }

    public JButton showUserButton() {
        return showUserButton;
    }

    public JButton stopUserShowingButton() {
        return stopUserShowingButton;
    }

    public JButton confirmEditButton() {
        return confirmEditButton;
    }

    public JButton resetEditButton() {
        return resetEditButton;
    }
}
