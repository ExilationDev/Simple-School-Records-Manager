package appproject.containers.students;

import appproject.lib.*;
import appproject.lib.components.ColorTheme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoContainer extends WindowContainer implements ActionListener {
    // This is where you build your GUI code outside the AppWindow and WindowContainer framework.

    JLabel student_label = new JLabel("null");
    JLabel id_label = new JLabel("null");
    JLabel age_label = new JLabel("null");
    JLabel address_label = new JLabel("null");

    // This constructor is an equivalent method to the main() method of AppProject.
    public InfoContainer(JTable table) {
        super();
        setLayout(null);

        // Put content GUI code here
        // Make sure you use getContent() when you add components!
        StudentData selectedRow = ((StudentRecordTableModel)table.getModel()).getSelectedRecord(table.getSelectedRow());

        student_label.setText(selectedRow.fullName() + " from " + selectedRow.program());
        student_label.setBounds(20, 20, 400, 30);
        student_label.setFont(new Font(null, Font.PLAIN, 20));

        id_label.setText("Student ID: " + selectedRow.id());
        id_label.setBounds(35, 70, 400, 20);

        age_label.setText("Age: " + selectedRow.age());
        age_label.setBounds(35, 85, 400, 20);

        address_label.setText("Address: " + selectedRow.address());
        address_label.setBounds(35, 100, 400, 20);

        add(student_label);
        add(id_label);
        add(age_label);
        add(address_label);

        setVisible(true);
    }

    // repaint function. Put setForegrounds of your JComponent here
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        student_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        id_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        age_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        address_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
    }

    // Put any functionalities here acquired from doing an action event from any action listener in this container.
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
