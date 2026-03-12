package appproject.containers;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import appproject.lib.WindowContainer;

// Container (or Scenes) for Navigation
public class MainContainer extends WindowContainer implements ActionListener {
    // This is where you build your GUI code outside the AppWindow and WindowContainer framework.

    // This constructor is an equivalent method to the main() method of AppProject.
    public MainContainer() {
        setLayout(new BorderLayout());

        add(getNavigator(), BorderLayout.WEST);
        add(getContent(), BorderLayout.CENTER);

        // Put content GUI code here

        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    // Put any functionalities here acquired from doing an action event from any action listener in this container.
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
