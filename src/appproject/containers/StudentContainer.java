package appproject.containers;

import appproject.AppProject;
import appproject.containers.students.InfoContainer;
import appproject.containers.students.UpdateContainer;
import appproject.containers.students.InsertContainer;
import appproject.lib.*;
import appproject.lib.components.ColorTheme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StudentContainer extends WindowContainer implements ActionListener {

    JPanel content;

    JLabel student_label = new JLabel("Student");
    JButton student_info_btn = new JButton("Check Info");
    JButton add_btn = new JButton("Insert");
    JButton delete_btn = new JButton("Delete");
    JButton update_btn = new JButton("Update");

    int selectedRow = -1;

    public ArrayList<StudentData> list = new ArrayList<>(java.util.List.of(
            new StudentData(152745,"Carl Francis Pacatang", 18,"Tagum City", Programs.BSCS,false),
            new StudentData(152710,"Kristian Vinz Lizardo", 19,"Tagum City", Programs.BSCS,false)
            new StudentData(152710,"Ricky II Guiloreza", 23,"Tagum City", Programs.BSCS,false)
            new StudentData(152710,"Andre Quima", 18,"Tagum City", Programs.BSCS,false)
            new StudentData(152710,"Jame Cris Yuson", 18,"Tagum City", Programs.BSCS,false)
    ));
    StudentRecordTableModel model = new StudentRecordTableModel(list);

    JTable student_table = new JTable(model);
    JScrollPane scroll = new JScrollPane(student_table);

    public StudentContainer() {
        super();
        setLayout(null);

        student_label.setBounds(20, 10, 200, 30);
        student_label.setFont(new Font(null, Font.PLAIN, 20));
        add(student_label);

        student_table.getColumn("Student ID").setPreferredWidth(40);
        student_table.getColumn("Full Name").setPreferredWidth(350);
        student_table.getColumn("Age").setPreferredWidth(20);
        student_table.getColumn("Program").setPreferredWidth(40);
        student_table.getColumn("Scholarship Status").setPreferredWidth(70);
        scroll.setBounds(35, 50, 600, 300);
        add(scroll);

        student_info_btn.addActionListener(this);
        student_info_btn.setBounds(35, 360, 100, 25);
        add(student_info_btn);

        add_btn.addActionListener(this);
        add_btn.setBounds(350, 360, 100, 25);
        add(add_btn);

        delete_btn.addActionListener(this);
        delete_btn.setBounds(245, 360, 100, 25);
        add(delete_btn);

        update_btn.addActionListener(this);
        update_btn.setBounds(140, 360, 100, 25);
        add(update_btn);

        setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        student_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        scroll.setSize(getWidth() - 70, getHeight() - 110);
        revalidate();
        student_info_btn.setLocation(student_info_btn.getX(), scroll.getHeight() + 60);
        add_btn.setLocation(add_btn.getX(), scroll.getHeight() + 60);
        delete_btn.setLocation(delete_btn.getX(), scroll.getHeight() + 60);
        update_btn.setLocation(update_btn.getX(), scroll.getHeight() + 60);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(add_btn)) {
            AppProject.window.showContentPaneAsDialog(new InsertContainer(student_table), "Insert Record", 475, 400, true);
        } else if (e.getSource().equals(delete_btn)) {
            int row = student_table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(AppProject.window, "Cannot get selected record. Did you select a record or item from the database?", "Remove Record", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int res = JOptionPane.showConfirmDialog(AppProject.window, "Do you want to remove the record that you selected? This action cannot be undone.", "Remove Record", JOptionPane.YES_NO_OPTION);
            if (res == 0) ((StudentRecordTableModel)student_table.getModel()).removeRecord(row);
        } else if (e.getSource().equals(update_btn)) {
            int row = student_table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(AppProject.window, "Cannot get selected record. Did you select a record or item from the database?", "Update Record", JOptionPane.WARNING_MESSAGE);
                return;
            }
            AppProject.window.showContentPaneAsDialog(new UpdateContainer(student_table), "Update Record", 475, 400, true);
        } else if (e.getSource().equals(student_info_btn)) {
            int row = student_table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(AppProject.window, "Cannot get selected record. Did you select a record or item from the database?", "Information", JOptionPane.WARNING_MESSAGE);
                return;
            }
            AppProject.window.showContentPaneAsDialog(new InfoContainer(student_table), "Information", 475, 400, false);
        }
    }
}