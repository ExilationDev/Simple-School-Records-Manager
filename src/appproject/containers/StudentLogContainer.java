package appproject.containers;

import appproject.lib.WindowContainer;
import appproject.lib.components.ColorTheme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// *author Carl Francis F. Pacatang
// Container used to add or delete student records.
// only handles the UI for now. Actual Student Login Information 
// will be connected once the Student class is finished.

public class StudentLogContainer extends WindowContainer implements ActionListener {
    //Localizing Variables for components in the container
    JLabel title = new JLabel();
    JLabel idLabel = new JLabel();
    JLabel firstNameLabel = new JLabel();
    JLabel lastNameLabel = new JLabel();
    JLabel ageLabel = new JLabel();

    // Input fields
    JTextField idField = new JTextField();
    JTextField firstNameField = new JTextField();
    JTextField lastNameField = new JTextField();
    JTextField ageField = new JTextField();

    // Buttons
    JButton addButton = new JButton("ADD STUDENT");
    JButton deleteButton = new JButton("DELETE STUDENT");

    public StudentLogContainer() {
        super();
        setLayout(null);

        // Title
        title.setText("STUDENT INFORMATION");
        title.setFont(new Font(null, Font.BOLD, 20));
        title.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        title.setBounds(90, 20, 250, 30);
        add(title);

        // Student ID
        idLabel.setText("Student ID:");
        idLabel.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        idLabel.setBounds(40, 80, 120, 25);
        add(idLabel);

        idField.setBounds(160, 80, 200, 25);
        add(idField);

        // First name
        firstNameLabel.setText("First Name:");
        firstNameLabel.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        firstNameLabel.setBounds(40, 120, 120, 25);
        add(firstNameLabel);

        firstNameField.setBounds(160, 120, 200, 25);
        add(firstNameField);

        // Last name
        lastNameLabel.setText("Last Name:");
        lastNameLabel.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        lastNameLabel.setBounds(40, 160, 120, 25);
        add(lastNameLabel);

        lastNameField.setBounds(160, 160, 200, 25);
        add(lastNameField);

        // Age
        ageLabel.setText("Age:");
        ageLabel.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        ageLabel.setBounds(40, 200, 120, 25);
        add(ageLabel);

        ageField.setBounds(160, 200, 200, 25);
        add(ageField);

        // Add student button
        addButton.setBounds(90, 270, 140, 35);
        addButton.addActionListener(this);
        add(addButton);

        // Delete student button
        deleteButton.setBounds(240, 270, 140, 35);
        deleteButton.addActionListener(this);
        add(deleteButton);
    }
    
    // Handles button clicks
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addButton) {
            JOptionPane.showMessageDialog(this, "Student added successfully!");
        }

        if (e.getSource() == deleteButton) {
            JOptionPane.showMessageDialog(this, "Student deleted successfully!");
        }
    }
}
