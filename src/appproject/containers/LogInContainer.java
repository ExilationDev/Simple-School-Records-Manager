package appproject.containers;

import appproject.lib.WindowContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LogInContainer extends WindowContainer implements ActionListener {

    JPanel panel;
    JLabel StudentIdJLabel, passJLabel;
    JTextField StudentId;
    JPasswordField password;
    JButton login;

    public LogInContainer() {
        setLayout(null);

        StudentIdJLabel = new JLabel("Student Id");
        StudentIdJLabel.setBounds(50, 40, 100, 30);

        StudentId = new JTextField();
        StudentId.setBounds(150, 40, 150, 30);

        passJLabel = new JLabel("Password");
        passJLabel.setBounds(50, 90, 100, 30);

        password = new JPasswordField();
        password.setBounds(150, 90, 150, 30);

        login = new JButton("Login");
        login.setBounds(120, 140, 100, 30);

        add(StudentIdJLabel);
        add(StudentId);
        add(passJLabel);
        add(password);
        add(login);

        setSize(350, 250);
        setVisible(true);

        login.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = StudentId.getText();
        String pass = new String(password.getPassword());

        if (id.equals("admin") && pass.equals("1234")) {
            JOptionPane.showMessageDialog(null, "Login Successful");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Login");
        }
    }
}