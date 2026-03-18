package appproject.containers.students;

import appproject.lib.*;
import appproject.lib.components.ColorTheme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Enhanced version of StudentLogContainer that follows the usual layout.
 *
 * @author Carl Francis Pacatang, Kristian Vinz Lizardo
 */
public class InsertContainer extends WindowContainer implements ActionListener {
    // This is where you build your GUI code outside the AppWindow and WindowContainer framework.
    JLabel insert_label = new JLabel("Insert Record");
    JLabel id_label = new JLabel("Student ID*");
    JSpinner id_field = new JSpinner(new SpinnerNumberModel(100000, 100000, 999999, 1));
    JLabel fullname_label = new JLabel("Full Name*");
    JTextField fullname_field = new JTextField();
    JLabel address_label = new JLabel("Address*");
    JTextField address_field = new JTextField();
    JLabel age_label = new JLabel("Age*");
    JSpinner age_field = new JSpinner(new SpinnerNumberModel(18, 0, 100, 1));
    JLabel program_label = new JLabel("Program*");
    JComboBox<Programs> program_dropdown = new JComboBox<>();
    JLabel scholar_label = new JLabel("Is Scholar");
    JCheckBox scholar_checkbox = new JCheckBox();
    JButton insert_btn = new JButton("Insert Data");

    JTable table;

    // This constructor is an equivalent method to the main() method of AppProject.
    public InsertContainer(JTable table) {
        setLayout(new BorderLayout());

        // Put content GUI code here
        // Make sure you use the content variable whenever you add components!
        this.table = table;
        setUpClassesGUI();

        add(new JPanel(), BorderLayout.WEST);
        add(getContent(), BorderLayout.CENTER);

        setVisible(true);
    }

    void setUpClassesGUI() {
        insert_label.setBounds(20, 10, 200, 30);
        insert_label.setFont(new Font(null, Font.PLAIN, 20));

        id_label.setBounds(35, 50, 200, 20);
        id_field.setBounds(235, 50, 200, 20);
        id_field.setEditor(new JSpinner.NumberEditor(id_field, "#"));

        fullname_label.setBounds(35, 80, 200, 20);
        fullname_field.setBounds(235, 80, 200, 20);

        address_label.setBounds(35, 110, 200, 20);
        address_field.setBounds(235, 110, 200, 20);

        age_label.setBounds(35, 140, 200, 20);
        age_field.setBounds(235, 140, 200, 20);

        program_label.setBounds(35, 170, 200, 20);
        program_dropdown.setBounds(235, 170, 200, 20);
        for (Programs program : Programs.values()) {
            program_dropdown.addItem(program);
        }

        scholar_label.setBounds(35, 200, 200, 20);
        scholar_checkbox.setBounds(235, 200, 20, 20);

        insert_btn.setBounds(35, 320, 200, 30);
        insert_btn.addActionListener(this);

        getContent().add(insert_label);
        getContent().add(id_label);
        getContent().add(id_field);
        getContent().add(fullname_label);
        getContent().add(fullname_field);
        getContent().add(address_label);
        getContent().add(address_field);
        getContent().add(program_label);
        getContent().add(program_dropdown);
        getContent().add(age_label);
        getContent().add(age_field);
        getContent().add(scholar_label);
        getContent().add(scholar_checkbox);
        getContent().add(insert_btn);
    }

    // repaint function. Put setForegrounds of your JComponent here
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        insert_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        id_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        fullname_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        address_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        program_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        age_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        scholar_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
    }

    // Put any functionalities here acquired from doing an action event from any action listener in this container.
    @Override
    public void actionPerformed(ActionEvent e) {
        for (Component c : getContent().getComponents()) {
            if (!(c instanceof JTextField)) continue;
            if (!((JTextField)c).getText().trim().isEmpty()) continue;
            JOptionPane.showMessageDialog(this, "One or more required fields are empty. Please check your inputs and try again.", "Insert Record", JOptionPane.ERROR_MESSAGE);
            return;
        }

        StudentData data = new StudentData((int)id_field.getValue(), fullname_field.getText(), (int)age_field.getValue(), address_field.getText(), (Programs)program_dropdown.getSelectedItem(), scholar_checkbox.isSelected());
        ((StudentRecordTableModel)table.getModel()).addRecord(data);
        SwingUtilities.getWindowAncestor(this).dispose();
    }
}
