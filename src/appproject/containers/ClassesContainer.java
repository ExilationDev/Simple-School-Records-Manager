package appproject.containers;

import appproject.AppProject;
import appproject.lib.ClassData;
import appproject.lib.ClassRecordTableModel;
import appproject.lib.Programs;
import appproject.lib.WindowContainer;
import appproject.lib.components.ColorTheme;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ClassesContainer extends WindowContainer implements ActionListener {

    JPanel navigator;
    JPanel content;

    JPanel formPanel;

    JTextField codefield;
    JTextField classField;
    JTextField namefield;
    JTextField unitsField;

    JLabel classes_label = new JLabel("Classes");
    JButton classes_info_btn = new JButton("Check Info");
    JButton addBtn = new JButton("Insert");
    JButton deleteBtn = new JButton("Delete");
    JButton updateBtn = new JButton("Update");

    int selectedRow = -1;

    public ArrayList<ClassData> list = new ArrayList<>(java.util.List.of(
            new ClassData(1000, "CCE 107", "Intermediate Programming", Programs.BSCS, 3.0, "skibidi sigmas")
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

        classes_info_btn.setBounds(35, 360, 100, 25);
        content.add(classes_info_btn);

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
        classes_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        scroll.setSize(getContent().getWidth() - 70, getContent().getHeight() - 110);
        revalidate();
        classes_info_btn.setLocation(classes_info_btn.getX(), scroll.getHeight() + 60);
        addBtn.setLocation(addBtn.getX(), scroll.getHeight() + 60);
        deleteBtn.setLocation(deleteBtn.getX(), scroll.getHeight() + 60);
        updateBtn.setLocation(updateBtn.getX(), scroll.getHeight() + 60);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(addBtn)) {
            AppProject.window.showContentPaneAsDialog(new InsertContainer(classes_table), "Insert Record", 475, 400, true);
        }
    }
}