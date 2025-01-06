package org.example.origin.studentManagementProject.view;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StudentView {
    // Constructor của class MyStudentView
    public StudentView() {
        // Chỉnh font chữ
        UIManager.put("Label.font", new Font("Bahnschrift", Font.PLAIN, 14));
        UIManager.put("Button.font", new Font("Bahnschrift", Font.PLAIN, 13));
        UIManager.put("Table.font", new Font("Bahnschrift", Font.PLAIN, 14));
        UIManager.put("TableHeader.font", new Font("Bahnschrift", Font.BOLD, 16));
        UIManager.put("TextField.font", new Font("Bahnschrift", Font.PLAIN, 14));

        // Tạo JFrame và cài đặt cơ bản
        JFrame frame = new JFrame("Student Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Header Panel: Phần tiêu đề phía trên cùng
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(new Color(30, 30, 30)); // Màu đen đậm
        headerPanel.setPreferredSize(new Dimension(800, 80)); // Tăng chiều cao header

        JLabel headerLabel = new JLabel("Student Management System", JLabel.CENTER);
        headerLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 25)); // Font Bahnschrift, đậm, kích thước 30
        headerLabel.setForeground(Color.WHITE); // Màu chữ trắng
        headerPanel.add(headerLabel, BorderLayout.CENTER);
        frame.add(headerPanel, BorderLayout.NORTH);

        // Navigation Panel: Phần chứa các nút bên trái
        JPanel navPanel = new JPanel();
        navPanel.setBackground(new Color(60, 60, 60)); // Màu đen nhạt
        navPanel.setPreferredSize(new Dimension(200, 600));
        navPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        JButton showAllBtn = new JButton("Show All Students");
        JButton editBtn = new JButton("Edit This Student");
        JButton deleteBtn = new JButton("Delete This Student");

        // Cài đặt thuộc tính cho nút
        setupButtonStyle(showAllBtn);
        setupButtonStyle(editBtn);
        setupButtonStyle(deleteBtn);

        // Thêm các nút vào navPanel
        navPanel.add(showAllBtn);
        navPanel.add(editBtn);
        navPanel.add(deleteBtn);
        frame.add(navPanel, BorderLayout.WEST);

        // Table Panel: Phần bảng hiển thị danh sách học sinh
        String[] columns = {"Roll Number", "Name", "Age", "Date of Birth", "Phone Number", "Mark"};
        Object[][] data = {
                {"R001", "Alice", 20, "2004-05-15", "0901234567", 85.5},
                {"R002", "Bob", 22, "2002-07-20", "0912345678", 90.2},
                {"R003", "Charlie", 21, "2003-03-25", "0923456789", 88.0},
                {"R004", "David", 23, "2001-09-30", "0934567890", 92.5},
                {"R005", "Eva", 24, "2000-12-10", "0945678901", 79.3},
                {"R006", "Fay", 19, "2005-06-01", "0956789012", 91.1},
                {"R007", "George", 22, "2002-04-14", "0967890123", 85.7},
                {"R008", "Hannah", 21, "2003-11-18", "0978901234", 87.4},
                {"R009", "Ivy", 20, "2004-02-28", "0989012345", 82.6},
                {"R010", "Jack", 23, "2001-10-03", "0990123456", 94.0},
                {"R011", "Kim", 24, "2000-08-16", "0901234567", 76.8},
                {"R012", "Liam", 19, "2005-01-07", "0912345678", 90.4},
                {"R013", "Mia", 22, "2002-09-21", "0923456789", 84.2},
                {"R014", "Noah", 21, "2003-04-22", "0934567890", 89.5},
                {"R015", "Olivia", 20, "2004-11-11", "0945678901", 80.9},
                {"R016", "Paul", 23, "2001-06-05", "0956789012", 91.7},
                {"R017", "Quinn", 24, "2000-01-12", "0967890123", 78.3},
                {"R018", "Ryan", 19, "2005-12-25", "0978901234", 93.0},
                {"R019", "Sophia", 22, "2002-03-13", "0989012345", 86.4},
                {"R020", "Tom", 21, "2003-10-06", "0990123456", 95.2}
        };


        // setup Table
        DefaultTableModel tableModel = new DefaultTableModel(data, columns);
        JTable studentTable = new JTable(tableModel);
        setupStudentTable(studentTable);


        // Tạo JScrollPane chứa bảng
        JScrollPane tableScrollPane = new JScrollPane(studentTable);
        tableScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        // Đặt JTable vào JScrollPane để có thể cuộn
//        JScrollPane hScrollPane = new JScrollPane(studentTable);
//        hScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        frame.add(tableScrollPane, BorderLayout.CENTER);

        // Event xử lý nút Edit
        editBtn.addActionListener(e -> {
            int selectedRow = studentTable.getSelectedRow(); // Lấy dòng được chọn
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(frame, "Please select a student to edit!", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Hiển thị label và textfield để sửa
            JPanel editPanel = new JPanel(new GridLayout(2, 2, 10, 10));
            JLabel nameLabel = new JLabel("New Name:");
            JTextField nameField = new JTextField((String) studentTable.getValueAt(selectedRow, 1));
            JLabel ageLabel = new JLabel("New Age:");
            JTextField ageField = new JTextField(studentTable.getValueAt(selectedRow, 2).toString());

            editPanel.add(nameLabel);
            editPanel.add(nameField);
            editPanel.add(ageLabel);
            editPanel.add(ageField);

            int result = JOptionPane.showConfirmDialog(frame, editPanel, "Edit Student", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                studentTable.setValueAt(nameField.getText(), selectedRow, 1); // Cập nhật tên mới
                studentTable.setValueAt(Integer.parseInt(ageField.getText()), selectedRow, 2); // Cập nhật tuổi mới
            }
        });

        // Event xử lý nút Delete
        deleteBtn.addActionListener(e -> {
            int selectedRow = studentTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(frame, "Please select a student to delete!", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Xác nhận xóa
            int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete this student?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                tableModel.removeRow(selectedRow); // Xóa dòng được chọn
            }
        });

        // Hiển thị JFrame
        frame.setVisible(true);
    }

    // Hàm : đặt thuộc tính cho Table và Columns
    private void setupStudentTable(JTable table) {
        // không cho phép auto resize làm mất dữ liệu bảng, khi dữ liệu dài
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        // không cho phép chỉnh sửa trực tiếp trên bảng ( phải sửa qua edit student )
        table.setDefaultEditor(Object.class, null);
        // không cho phép xóa dòng
        table.setCellSelectionEnabled(true);
        table.setColumnSelectionAllowed(false);
        table.setRowSelectionAllowed(true);
        // không cho thay đổi thứ tự các cột
        table.getTableHeader().setReorderingAllowed(false);

        // Đặt kích thước bảng để scroll theo chiều ngang
        table.setPreferredScrollableViewportSize(new Dimension(500, 100));
        table.setRowHeight(22);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Cho phép chọn một dòng duy nhất

        // Đặt chiều dài cho từng column
        // Các cột trong JTable có index bắt đầu từ 0.
        // VD : có 6 cột, vậy gọi getColumn cho các số sau : 0 1 2 3 4 5 (6 lỗi)
        table.getColumnModel().getColumn(0).setMinWidth(100);
        // Cột Roll Number (cột 0)
        table.getColumnModel().getColumn(1).setMinWidth(100);

        // Cột Name (cột 2)
        table.getColumnModel().getColumn(2).setMinWidth(200);

        // Cột Age (cột 3)
        table.getColumnModel().getColumn(3).setMinWidth(35);

        // Cột Date of Birth (cột 4)
        table.getColumnModel().getColumn(4).setMinWidth(100);

        // Cột Phone Number (cột 5)
        table.getColumnModel().getColumn(5).setMinWidth(150);
        System.out.println(table.getColumnName(5));

    }


    // Hàm thiết lập style cho nút
    private void setupButtonStyle(JButton button) {
        button.setPreferredSize(new Dimension(165, 30));
        button.setBackground(Color.BLACK); // Màu nền đen
        button.setForeground(Color.WHITE); // Màu chữ trắng
        button.setFocusable(false); // Tắt focus
        button.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED)); // Border dạng etched
    }

    // Main method để chạy chương trình
    public static void main(String[] args) {
        new StudentView(); // Khởi chạy chương trình
    }
}
