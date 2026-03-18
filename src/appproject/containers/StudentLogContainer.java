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

        // Get the content panel from WindowContainer
        JPanel content = getContent();
        content.setLayout(null); // getContent() is already null layout so this is redundant.
        
        
        setLayout(new BorderLayout());
        add(new JPanel(), BorderLayout.WEST);
        add(content, BorderLayout.CENTER);

        // Title
        title.setText("STUDENT INFORMATION");
        title.setFont(new Font(null, Font.BOLD, 20));
        title.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        title.setBounds(90, 20, 250, 30);
        content.add(title);

        // Student ID
        idLabel.setText("Student ID:");
        idLabel.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        idLabel.setBounds(40, 80, 120, 25);
        content.add(idLabel);

        idField.setBounds(160, 80, 200, 25);
        content.add(idField);

        // First name
        firstNameLabel.setText("First Name:");
        firstNameLabel.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        firstNameLabel.setBounds(40, 120, 120, 25);
        content.add(firstNameLabel);

        firstNameField.setBounds(160, 120, 200, 25);
        content.add(firstNameField);

        // Last name
        lastNameLabel.setText("Last Name:");
        lastNameLabel.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        lastNameLabel.setBounds(40, 160, 120, 25);
        content.add(lastNameLabel);

        lastNameField.setBounds(160, 160, 200, 25);
        content.add(lastNameField);

        // Age
        ageLabel.setText("Age:");
        ageLabel.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        ageLabel.setBounds(40, 200, 120, 25);
        content.add(ageLabel);

        ageField.setBounds(160, 200, 200, 25);
        content.add(ageField);

        // Add student button
        addButton.setBounds(90, 270, 140, 35);
        addButton.addActionListener(this);
        content.add(addButton);

        // Delete student button
        deleteButton.setBounds(240, 270, 140, 35);
        deleteButton.addActionListener(this);
        content.add(deleteButton);
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
