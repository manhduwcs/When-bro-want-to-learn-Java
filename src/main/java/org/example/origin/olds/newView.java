package org.example.origin.olds;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class newView extends JFrame {
    private JPanel mainPane;
    private JTable myTable;

    public newView() {
        // table
        String[] columns = {"id", "name", "age", ",mark"};
        Object[][] data = {
                {1, "Johnson Baby", 23, 8.8},
                {2, "Olivia Black", 13, 6.7},
                {3, "Jessie Ling", 25, 8.7},
        };

        DefaultTableModel tableModel = new DefaultTableModel(data, columns);
        myTable.setModel(tableModel);


        // setting Frame
        setContentPane(mainPane);
        setTitle("My Application");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new newView();
    }
}
