package appproject.containers;

import appproject.lib.WindowContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentLogContainer extends WindowContainer implements ActionListener {

    public StudentLogContainer() {

        JPanel content = getContent();
        content.setLayout(null);

        setLayout(new BorderLayout());
        add(content, BorderLayout.CENTER);

        int labelX = 30;
        int fieldX = 150;
        int width = 210;
        int height = 25;
        int rowGap = 40;

        // Title
        JLabel title = new JLabel("STUDENT INFORMATION");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        title.setBounds(80, 20, 250, 30);
        content.add(title);

        // Student ID
        JLabel nameLabel = new JLabel("Student ID:");
        nameLabel.setBounds(labelX, 60, 120, height);
        content.add(nameLabel);

        JTextField idField = new JTextField();
        idField.setBounds(fieldX, 60, width, height);
        content.add(idField);

        // First Name
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(labelX, 60 + rowGap, 120, height);
        content.add(firstNameLabel);

        JTextField firstNameField = new JTextField();
        firstNameField.setBounds(fieldX, 60 + rowGap, width, height);
        content.add(firstNameField);

        // Last Name
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(labelX, 60 + rowGap * 2, 120, height);
        content.add(lastNameLabel);

        JTextField lastNameField = new JTextField();
        lastNameField.setBounds(fieldX, 60 + rowGap * 2, width, height);
        content.add(lastNameField);

        // Age
        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(labelX, 60 + rowGap * 3, 120, height);
        content.add(ageLabel);

        JTextField ageField = new JTextField();
        ageField.setBounds(fieldX, 60 + rowGap * 3, width, height);
        content.add(ageField);

        // Course Code
        JLabel courseCodeLabel = new JLabel("Course Code:");
        courseCodeLabel.setBounds(labelX, 60 + rowGap * 4, 120, height);
        content.add(courseCodeLabel);

        JTextField courseCodeField = new JTextField();
        courseCodeField.setBounds(fieldX, 60 + rowGap * 4, width, height);
        content.add(courseCodeField);

        // Course Name
        JLabel courseNameLabel = new JLabel("Course Name:");
        courseNameLabel.setBounds(labelX, 60 + rowGap * 5, 120, height);
        content.add(courseNameLabel);

        JTextField courseNameField = new JTextField();
        courseNameField.setBounds(fieldX, 60 + rowGap * 5, width, height);
        content.add(courseNameField);

        // Buttons
        JButton addButton = new JButton("ADD STUDENT");
        addButton.setBounds(120, 320, 130, 30);
        content.add(addButton);
        addButton.addActionListener(this);

        JButton deleteButton = new JButton("DELETE STUDENT");
        deleteButton.setBounds(260, 320, 140, 30);
        content.add(deleteButton);
        deleteButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Student added successfully!");
    }
}
