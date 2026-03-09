package appproject.containers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LogInContainer extends JFrame{

    JPanel panel;
    JLabel StudentIdJLabel, passJLabel;
    JTextField StudentId;
    JPasswordField password;
    JButton login;

    public LogInContainer() {

        panel = new JPanel();
        panel.setLayout(null);

        StudentIdJLabel = new JLabel("Student Id");
        StudentIdJLabel.setBounds(50,40,100,30);

        StudentId = new JTextField();
        StudentId.setBounds(150,40,150,30);

        passJLabel = new JLabel("Password");
        passJLabel.setBounds(50,90,100,30);

        password = new JPasswordField();
        password.setBounds(150,90,150,30);

        login = new JButton("Login");
        login.setBounds(120,140,100,30);

        panel.add(StudentIdJLabel);
        panel.add(StudentId);
        panel.add(passJLabel);
        panel.add(password);
        panel.add(login);

        add(panel);

        setTitle("Login form");
        setSize(350,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String id = StudentId.getText();
                String pass = new String(password.getPassword());

                if(id.equals("admin") && pass.equals("1234")){
                    JOptionPane.showMessageDialog(null, "Login Successful");
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                }
            }
        });
    }


public static void main(String[]args){

    new LogInContainer();
}}