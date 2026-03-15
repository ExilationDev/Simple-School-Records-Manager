package appproject.containers;

import appproject.lib.ClassData;
import appproject.lib.Programs;
import appproject.lib.WindowContainer;
import appproject.lib.components.ColorTheme;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class ClassesContainer extends WindowContainer implements ActionListener {

    JPanel navigator;
    JPanel content;

    JButton addBtn;
    JButton deleteBtn;
    JButton updateBtn;
    JButton saveBtn;

    JPanel formPanel;

    JTextField codefield;
    JTextField classField;
    JTextField namefield;
    JTextField unitsField;

    JLabel classes_label = new JLabel("Classes");
    JButton classes_info_btn = new JButton("Check Info");

    int selectedRow = -1;

    public static DefaultTableModel table_model = new DefaultTableModel(
            new Object[][]{
                    {4408, "CCE 107", "Intermediate Programming", Programs.BSCS, 3.0},
                    {4409, "CCE 103", "Computer Programming 2", Programs.BSIT, 3.0},
                    {4410, "CCE 105", "Data Structures and Algorithms", Programs.BSCS, 3.0}
            },
            new String[]{"Code", "Class", "Name", "Program", "Units"}
    ) {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public static JTable classes_table = new JTable(table_model);

    public JPanel setUpFormPanel() {
        formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBounds(650, 50, 250, 300);

        codefield = new JTextField();
        classField = new JTextField();
        namefield = new JTextField();
        unitsField = new JTextField();

        saveBtn = new JButton("Save");
        saveBtn.addActionListener(this);

        codefield.setBounds(20, 20, 200, 25);
        classField.setBounds(20, 60, 200, 25);
        namefield.setBounds(20, 100, 200, 25);
        unitsField.setBounds(20, 140, 200, 25);
        saveBtn.setBounds(70, 210, 100, 30);

        formPanel.add(codefield);
        formPanel.add(classField);
        formPanel.add(namefield);
        formPanel.add(unitsField);
        formPanel.add(saveBtn);

        content.add(formPanel);
        formPanel.setVisible(false);

        return formPanel;
    }

    public ClassesContainer() {
        setLayout(new BorderLayout());
        navigator = getNavigator();
        content = getContent();

        add(navigator, BorderLayout.WEST);
        add(content, BorderLayout.CENTER);

        content.setLayout(null);

        addBtn = new JButton("Add");
        addBtn.addActionListener(this);
        addBtn.setBounds(350, 360, 100, 25);
        content.add(addBtn);

        deleteBtn = new JButton("Delete");
        deleteBtn.addActionListener(this);
        deleteBtn.setBounds(245, 360, 100, 25);
        content.add(deleteBtn);

        updateBtn = new JButton("Update");
        updateBtn.addActionListener(this);
        updateBtn.setBounds(140, 360, 100, 25);
        content.add(updateBtn);

        setUpFormPanel();

        classes_label.setBounds(20, 20, 200, 30);
        classes_label.setFont(new Font(null, Font.PLAIN, 20));
        content.add(classes_label);

        JScrollPane scroll = new JScrollPane(classes_table);
        scroll.setBounds(35, 50, 600, 300);
        content.add(scroll);

        classes_info_btn.setBounds(35, 360, 100, 25);
        content.add(classes_info_btn);

        setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        classes_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
    }

    public void actionPerformed(ActionEvent e) {

        DefaultTableModel model = (DefaultTableModel) classes_table.getModel();

        if (e.getSource() == addBtn) {

            selectedRow = -1;

            codefield.setText("");
            classField.setText("");
            namefield.setText("");
            unitsField.setText("");

            formPanel.setVisible(true);
        } else if (e.getSource() == deleteBtn) {

            int row = classes_table.getSelectedRow();

            if (row != -1) {
                model.removeRow(row);
            }
        } else if (e.getSource() == updateBtn) {

            selectedRow = classes_table.getSelectedRow();

            if (selectedRow != -1) {

                codefield.setText(model.getValueAt(selectedRow, 0).toString());
                classField.setText(model.getValueAt(selectedRow, 1).toString());
                namefield.setText(model.getValueAt(selectedRow, 2).toString());
                unitsField.setText(model.getValueAt(selectedRow, 4).toString());

                formPanel.setVisible(true);
            }
        } else if (e.getSource() == saveBtn) {

            String code = codefield.getText();
            String className = classField.getText();
            String name = namefield.getText();
            double units = Double.parseDouble(unitsField.getText());

            if (selectedRow == -1) {

                model.addRow(new Object[]{code, className, name, Programs.BSCS, units});

            } else {

                model.setValueAt(code, selectedRow, 0);
                model.setValueAt(className, selectedRow, 1);
                model.setValueAt(name, selectedRow, 2);
                model.setValueAt(units, selectedRow, 4);
            }

            formPanel.setVisible(false);
        }
    }
}