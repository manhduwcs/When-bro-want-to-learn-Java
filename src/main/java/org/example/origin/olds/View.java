package org.example.origin.olds;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class View extends JFrame {
    // Font
    private final Font basicFont = new Font("MV Boli", Font.PLAIN, 22);

    private JPanel main; // main panel, which contains everything
    private JPanel enterInfoPanel;
    private JPanel buttonsControlPanel;
    private JTextField Name;
    private JTextField Age;
    private JButton confirmButton;
    private JButton resetButton;

    private JLabel nameLabel;
    private JLabel ageLabel;


    public View() {
        // Table, Pane
        String[] columns = {"id", "name", "age", ",mark"};
        Object[][] data = {
                {1, "Johnson Baby", 23, 8.8},
                {2, "Olivia Black", 13, 6.7},
                {3, "Jessie Ling", 25, 8.7},
        };

        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable myTable = new JTable(model);
        JScrollPane TablePane = new JScrollPane(myTable);
        main.add(TablePane);

//        String namePlaceholder = "Enter your name";
//        String agePlaceholder = "Enter your age";
//
//       nameLabel.setFont(basicFont);
//       ageLabel.setFont(basicFont);
//
//        settingTextFields(Name, namePlaceholder);
//        settingTextFields(Age, agePlaceholder);
//
//        // buttons
//        settingButtons(confirmButton).addActionListener(e -> {
//            String nText = Name.getText();
//            if (!nText.isBlank() && !nText.equals(namePlaceholder))
//                nameLabel.setText(nText);
//            else nameLabel.setText("Invalid Name !");
//
//            String aText = Age.getText();
//            if (!aText.isBlank() && !aText.equals(agePlaceholder))
//                ageLabel.setText(aText);
//            else ageLabel.setText("Invalid Age !");
//        });
//
//        settingButtons(resetButton);
//        final int[] state = {1}; // use an Array so that this Array's element is modifiable inside Lambda
//        // if we use normal var, it can't be done. Use Array or Object
//        resetButton.addActionListener(e -> {
//            if (state[0] == 1) {
//                enterInfoPanel.setBackground(Color.black);
//                state[0] = 0;
//                return;
//            }
//            if (state[0] == 0) {
//                enterInfoPanel.setBackground(Color.magenta);
//                state[0] = -1;
//                return;
//            }
//            if (state[0] == -1) {
//                enterInfoPanel.setBackground(Color.cyan);
//                state[0] = 1;
//            }
//        });

        // setting Frame
        setContentPane(main);
        setTitle("My Application");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

//    public static void main(String[] args) {
//        new View();
//    }

    public void settingTextFields(JTextField tf, String placeholder) {
        tf.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tf.getText().equals(placeholder)) {
                    tf.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tf.getText().isBlank()) tf.setText(placeholder);
            }
        });

        tf.setFont(basicFont);
    }

    public JButton settingButtons(JButton b) {
        b.setFocusable(false);
        b.setBackground(Color.black);
        b.setBorder(BorderFactory.createEtchedBorder());
        b.setFont(basicFont);
        b.setForeground(Color.white);
        return b;
    }
}
