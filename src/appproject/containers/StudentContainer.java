package appproject.containers;

import appproject.AppProject;
import appproject.containers.students.InsertContainer;
import appproject.lib.StudentData;
import appproject.lib.StudentRecordTableModel;
import appproject.lib.Programs;
import appproject.lib.WindowContainer;
import appproject.lib.components.ColorTheme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StudentContainer extends WindowContainer implements ActionListener {

    JPanel navigator;
    JPanel content;

    JLabel student_label = new JLabel("Student");
    JButton student_info_btn = new JButton("Check Info");
    JButton addBtn = new JButton("Insert");
    JButton deleteBtn = new JButton("Delete");
    JButton updateBtn = new JButton("Update");

    int selectedRow = -1;

    public ArrayList<StudentData> list = new ArrayList<>(java.util.List.of(
            new StudentData(152745,"Carl Francis Pacatang", 18,"Tagum City", Programs.BSCS,false),
            new StudentData(152710,"Kristian Vinz Lizardo", 19,"Tagum City", Programs.BSCS,false)
    ));
    StudentRecordTableModel model = new StudentRecordTableModel(list);

    JTable student_table = new JTable(model);
    JScrollPane scroll = new JScrollPane(student_table);

    public StudentContainer() {
        setLayout(new BorderLayout());
        navigator = getNavigator();
        content = getContent();

        add(navigator, BorderLayout.WEST);
        add(content, BorderLayout.CENTER);

        content.setLayout(null);

        student_label.setBounds(20, 10, 200, 30);
        student_label.setFont(new Font(null, Font.PLAIN, 20));
        content.add(student_label);

        student_table.getColumn("Student ID").setPreferredWidth(40);
        student_table.getColumn("Full Name").setPreferredWidth(350);
        student_table.getColumn("Age").setPreferredWidth(20);
        student_table.getColumn("Program").setPreferredWidth(40);
        student_table.getColumn("Scholarship Status").setPreferredWidth(70);
        scroll.setBounds(35, 50, 600, 300);
        content.add(scroll);

        student_info_btn.setBounds(35, 360, 100, 25);
        content.add(student_info_btn);

        addBtn.addActionListener(this);
        addBtn.setBounds(350, 360, 100, 25);
        content.add(addBtn);

        deleteBtn.addActionListener(this);
        deleteBtn.setBounds(245, 360, 100, 25);
        content.add(deleteBtn);

        updateBtn.addActionListener(this);
        updateBtn.setBounds(140, 360, 100, 25);
        content.add(updateBtn);

        setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        student_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        scroll.setSize(getContent().getWidth() - 70, getContent().getHeight() - 110);
        revalidate();
        student_info_btn.setLocation(student_info_btn.getX(), scroll.getHeight() + 60);
        addBtn.setLocation(addBtn.getX(), scroll.getHeight() + 60);
        deleteBtn.setLocation(deleteBtn.getX(), scroll.getHeight() + 60);
        updateBtn.setLocation(updateBtn.getX(), scroll.getHeight() + 60);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(addBtn)) {
            AppProject.window.showContentPaneAsDialog(new InsertContainer(student_table), "Insert Record", 475, 400, true);
        }
    }
}