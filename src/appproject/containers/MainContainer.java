package appproject.containers;

import java.awt.*;
import java.awt.event.*;

import appproject.AppProject;
import appproject.lib.WindowContainer;

import javax.swing.*;

// Container (or Scenes) for Navigation
public class MainContainer extends WindowContainer implements ActionListener {
    // This is where you build your GUI code outside the AppWindow and WindowContainer framework.
    JPanel navigator;
    JPanel content;

    // This constructor is an equivalent method to the main() method of AppProject.
    public MainContainer() {
        super();
        setBackground(Color.LIGHT_GRAY);
        setLayout(new BorderLayout());

        add(navigator = setUpNavigator(), BorderLayout.WEST);
        add(content = setUpContent(), BorderLayout.CENTER);

        // Put content GUI code here

        setVisible(true);
    }

    // Put any functionalities here acquired from doing an action event from any action listener in this container.
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
