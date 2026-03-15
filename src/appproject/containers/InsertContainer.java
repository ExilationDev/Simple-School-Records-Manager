package appproject.containers;

import appproject.lib.Programs;
import appproject.lib.WindowContainer;
import appproject.lib.components.ColorTheme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertContainer extends WindowContainer implements ActionListener {
    // This is where you build your GUI code outside the AppWindow and WindowContainer framework.
    JLabel insert_label = new JLabel("Insert Record");
    JLabel code_label = new JLabel("Code");
    JTextField code_field = new JTextField();
    JLabel class_title_label = new JLabel("Class Title");
    JTextField class_title_field = new JTextField();
    JLabel class_name_label = new JLabel("Class Name");
    JTextField class_name_field = new JTextField();
    JLabel program_label = new JLabel("Program");
    JComboBox<Programs> program_dropdown = new JComboBox<>();
    JLabel units_label = new JLabel("Units");
    JTextField units_field = new JTextField();
    JButton insert_btn = new JButton("Insert Data");

    // This constructor is an equivalent method to the main() method of AppProject.
    public InsertContainer() {
        setLayout(new BorderLayout());

        // Put content GUI code here
        // Make sure you use the content variable whenever you add components!
        insert_label.setBounds(20, 10, 200, 30);
        insert_label.setFont(new Font(null, Font.PLAIN, 20));

        code_label.setBounds(35, 50, 200, 20);
        code_field.setBounds(235, 50, 200, 20);

        class_title_label.setBounds(35, 80, 200, 20);
        class_title_field.setBounds(235, 80, 200, 20);

        class_name_label.setBounds(35, 110, 200, 20);
        class_name_field.setBounds(235, 110, 200, 20);

        program_label.setBounds(35, 140, 200, 20);
        program_dropdown.setBounds(235, 140, 200, 20);
        program_dropdown.addItem(Programs.BSCS);
        program_dropdown.addItem(Programs.BSIT);
        program_dropdown.addItem(Programs.BSIS);
        program_dropdown.addItem(Programs.BSEMC);
        program_dropdown.addItem(Programs.BSCpE);

        units_label.setBounds(35, 170, 200, 20);
        units_field.setBounds(235, 170, 200, 20);

        insert_btn.setBounds(35, 220, 200, 30);
        insert_btn.addActionListener(this);

        getContent().add(insert_label);
        getContent().add(code_label);
        getContent().add(code_field);
        getContent().add(class_title_label);
        getContent().add(class_title_field);
        getContent().add(class_name_label);
        getContent().add(class_name_field);
        getContent().add(program_label);
        getContent().add(program_dropdown);
        getContent().add(units_label);
        getContent().add(units_field);
        getContent().add(insert_btn);

        add(new JPanel(), BorderLayout.WEST);
        add(getContent(), BorderLayout.CENTER);

        setVisible(true);
    }

    // repaint function. Put setForegrounds of your JComponent here
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        insert_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        code_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        class_title_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        class_name_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        program_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        units_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
    }

    // Put any functionalities here acquired from doing an action event from any action listener in this container.
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
