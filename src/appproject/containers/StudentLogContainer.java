package appproject.containers;

import appproject.lib.WindowContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentLogContainer extends WindowContainer implements ActionListener {
   
    public StudentLogContainer() {
        
        setLayout(null);
        setBackground(Color.WHITE);
        
        JLabel title = new JLabel("STUDENT INFORMATION");
        title.setBounds(20, 20, 200, 30);
        add(title);
        
        JLabel nameLabel = new JLabel("Student ID:");
        nameLabel.setBounds(20, 60, 120, 25);
        add(nameLabel);
        
        JTextField idField = new JTextField();
        idField.setBounds(150, 60, 200, 25);
        add(idField);
        
        JLabel FirstNameLabel = new JLabel("First Name:");
        FirstNameLabel.setBounds(20, 100, 120, 25);
        add(FirstNameLabel);
        
        JTextField FirstNameField = new JTextField();
        FirstNameField.setBounds(150, 100, 200, 25);
        add(FirstNameField);
        
        JLabel LastNameLabel = new JLabel("Last Name:");
        LastNameLabel.setBounds(20, 140, 120, 25);
        add(LastNameLabel);
        
        JTextField LastNameField = new JTextField();
        LastNameField.setBounds(150, 140, 200, 25);
        add(LastNameField);
        
        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(20, 180, 120, 25);
        add(ageLabel);
        
        JTextField ageField = new JTextField();
        ageField.setBounds(150, 180, 200, 25);
        add(ageField);
        
        JLabel courseCodeLabel = new JLabel ("Course Code:");
        courseCodeLabel.setBounds(20, 220, 120, 25);
        add(courseCodeLabel);
        
        JTextField courseCodeField = new JTextField();
        courseCodeField.setBounds(150, 220, 200, 25);
        add(courseCodeField);
        
        JLabel courseNameLabel = new JLabel("Course Name:");
        courseNameLabel.setBounds(20, 260, 120, 25);
        add(courseNameLabel);
        
        JTextField courseNameField = new JTextField();
        courseNameField.setBounds(150, 260, 200, 25);
        add(courseNameField);
        
        JButton addButton = new JButton("ADD STUDENT");
        addButton.setBounds(150, 310, 130, 30);
        add(addButton);
        addButton.addActionListener(this);

       
        JButton deleteButton = new JButton("DELETE STUDENT");
        deleteButton.setBounds(290, 310, 135, 30);
        add(deleteButton);
        deleteButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    JOptionPane.showMessageDialog(this, "Student added successfully!");
    }
}

