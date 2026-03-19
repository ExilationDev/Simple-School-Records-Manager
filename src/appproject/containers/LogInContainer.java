package appproject.containers;

import appproject.lib.WindowContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Andre Quima
 */
public class LogInContainer extends WindowContainer implements ActionListener {
    JLabel title_label;
    JLabel username_label, password_label;
    JTextField username_field;
    JPasswordField password_field;
    JButton login;

    public LogInContainer() {
        setLayout(null);

        title_label = new JLabel("Login");
        title_label.setBounds(20, 10, 200, 30);
        title_label.setFont(new Font(null, Font.PLAIN, 20));

        username_label = new JLabel("Faculty Name");
        username_label.setBounds(35, 50, 200, 20);

        username_field = new JTextField();
        username_field.setBounds(235, 50, 200, 20);

        password_label = new JLabel("Password");
        password_label.setBounds(35, 80, 200, 20);

        password_field = new JPasswordField();
        password_field.setBounds(235, 80, 200, 20);

        login = new JButton("Login");
        login.setBounds(35, 320, 200, 30);

        add(title_label);
        add(username_label);
        add(username_field);
        add(password_label);
        add(password_field);
        add(login);

        setSize(350, 250);
        setVisible(true);

        login.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = username_field.getText();
        String pass = new String(password_field.getPassword());

        if (id.equals("admin") && pass.equals("1234")) {
            JOptionPane.showMessageDialog(this, "Login successful!");
            SwingUtilities.getWindowAncestor(this).dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid login. Please try again.");
        }
    }
}