package appproject.containers;

import appproject.lib.WindowContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpContainer extends WindowContainer implements ActionListener {
    // This is where you build your GUI code outside the AppWindow and WindowContainer framework.

    // This constructor is an equivalent method to the main() method of AppProject.
    public HelpContainer() {
        setBackground(Color.LIGHT_GRAY);
        setOpaque(true);

        JLabel label = new JLabel("Content");
        add(label);

        setLayout(null);
        setVisible(true);
    }

    // Put any functionalities here acquired from doing an action event from any action listener in this container.
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

