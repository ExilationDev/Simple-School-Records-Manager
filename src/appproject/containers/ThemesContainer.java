package appproject.containers;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import appproject.lib.WindowContainer;

import javax.swing.*;

public class ThemesContainer extends WindowContainer implements ActionListener {
    // This is where you build your GUI code outside the AppWindow and WindowContainer framework.
    JPanel navigator;
    JPanel content;

    // This constructor is an equivalent method to the main() method of AppProject.
    public ThemesContainer() {
        super();
        setLayout(new BorderLayout());

        add(navigator = setUpNavigator(), BorderLayout.WEST);
        add(content = setUpContent(), BorderLayout.CENTER);

        // Put content GUI code here
        JLabel theme_label = new JLabel("Themes");
        theme_label.setBounds(20, 20, 100, 20);
        theme_label.setFont(new Font(null, Font.PLAIN, 20));
        content.add(theme_label);

        JLabel theme_dropdown_label = new JLabel("Preset");
        theme_dropdown_label.setBounds(35, 50, 100, 20);
        content.add(theme_dropdown_label);

        JComboBox theme_dropdown = new JComboBox();
        theme_dropdown.addItem("Default");
        theme_dropdown.addItem("Dark");
        theme_dropdown.addItem("University of Mindanao");
        theme_dropdown.addItem("St. Mary's College");
        theme_dropdown.setBounds(135, 50, 150, 20);
        content.add(theme_dropdown);

        setVisible(true);
    }

    // Put any functionalities here acquired from doing an action event from any action listener in this container.
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
