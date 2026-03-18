package appproject.containers;

import appproject.AppProject;
import appproject.containers.classes.InfoContainer;
import appproject.containers.classes.InsertContainer;
import appproject.containers.classes.UpdateContainer;
import appproject.lib.ClassData;
import appproject.lib.ClassRecordTableModel;
import appproject.lib.Programs;
import appproject.lib.WindowContainer;
import appproject.lib.components.ColorTheme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ClassesContainer extends WindowContainer implements ActionListener {

    JPanel navigator;
    JPanel content;

    JLabel classes_label = new JLabel("Classes");
    JButton classes_info_btn = new JButton("Check Info");
    JButton add_btn = new JButton("Insert");
    JButton delete_btn = new JButton("Delete");
    JButton update_btn = new JButton("Update");

    public ArrayList<ClassData> list = new ArrayList<>(java.util.List.of(
            new ClassData(1000, "CCE 107", "Intermediate Programming", Programs.BSCS, 3.0, "This course involves mastering object-oriented programming, data structures, version control, and debugging techniques."),
            new ClassData(1001, "CCE 103", "Computer Programming 2", Programs.BSIT, 3.0, "This course covers concepts like inheritance, polymorphism, arrays, and file handling to train students in designing and debugging software.")
    ));
    ClassRecordTableModel model = new ClassRecordTableModel(list);

    JTable classes_table = new JTable(model);
    JScrollPane scroll = new JScrollPane(classes_table);

    public ClassesContainer() {
        setLayout(new BorderLayout());
        navigator = getNavigator();
        content = getContent();

        add(navigator, BorderLayout.WEST);
        add(content, BorderLayout.CENTER);

        content.setLayout(null);

        classes_label.setBounds(20, 10, 200, 30);
        classes_label.setFont(new Font(null, Font.PLAIN, 20));
        content.add(classes_label);

        classes_table.getColumn("Code").setPreferredWidth(30);
        classes_table.getColumn("Class").setPreferredWidth(60);
        classes_table.getColumn("Name").setPreferredWidth(350);
        classes_table.getColumn("Program").setPreferredWidth(50);
        classes_table.getColumn("Units").setPreferredWidth(25);
        scroll.setBounds(35, 50, 600, 300);
        content.add(scroll);

        classes_info_btn.addActionListener(this);
        classes_info_btn.setBounds(35, 360, 100, 25);
        content.add(classes_info_btn);

        add_btn.addActionListener(this);
        add_btn.setBounds(350, 360, 100, 25);
        content.add(add_btn);

        delete_btn.addActionListener(this);
        delete_btn.setBounds(245, 360, 100, 25);
        content.add(delete_btn);

        update_btn.addActionListener(this);
        update_btn.setBounds(140, 360, 100, 25);
        content.add(update_btn);

        setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        classes_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        scroll.setSize(getContent().getWidth() - 70, getContent().getHeight() - 110);
        revalidate();
        classes_info_btn.setLocation(classes_info_btn.getX(), scroll.getHeight() + 60);
        add_btn.setLocation(add_btn.getX(), scroll.getHeight() + 60);
        delete_btn.setLocation(delete_btn.getX(), scroll.getHeight() + 60);
        update_btn.setLocation(update_btn.getX(), scroll.getHeight() + 60);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(add_btn)) {
            AppProject.window.showContentPaneAsDialog(new InsertContainer(classes_table), "Insert Record", 475, 400, true);
        } else if (e.getSource().equals(delete_btn)) {
            int row = classes_table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(AppProject.window, "Cannot get selected record. Did you select a record or item from the database?", "Remove Record", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int res = JOptionPane.showConfirmDialog(AppProject.window, "Do you want to remove the record that you selected? This action cannot be undone.", "Remove Record", JOptionPane.YES_NO_OPTION);
            if (res == 0) ((ClassRecordTableModel)classes_table.getModel()).removeRecord(row);
        } else if (e.getSource().equals(update_btn)) {
            int row = classes_table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(AppProject.window, "Cannot get selected record. Did you select a record or item from the database?", "Update Record", JOptionPane.WARNING_MESSAGE);
                return;
            }
            AppProject.window.showContentPaneAsDialog(new UpdateContainer(classes_table), "Update Record", 475, 400, true);
        } else if (e.getSource().equals(classes_info_btn)) {
            int row = classes_table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(AppProject.window, "Cannot get selected record. Did you select a record or item from the database?", "Information", JOptionPane.WARNING_MESSAGE);
                return;
            }
            AppProject.window.showContentPaneAsDialog(new InfoContainer(classes_table), "Information", 475, 400, false);
        }
    }
}