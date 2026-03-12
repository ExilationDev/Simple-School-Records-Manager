package appproject.containers;

import appproject.lib.WindowContainer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertContainer extends WindowContainer implements ActionListener {
    // This is where you build your GUI code outside the AppWindow and WindowContainer framework.
    JPanel navigator;
    JPanel content;

    // This constructor is an equivalent method to the main() method of AppProject.
    public InsertContainer() {
        super();
        setLayout(new BorderLayout());

        // add(navigator = setUpNavigator(), BorderLayout.WEST);
        add(getContent(), BorderLayout.CENTER);

        // Put content GUI code here
        // Make sure you use the content variable whenever you add components!

        setVisible(true);
    }

    // repaint function. Put setForegrounds of your JComponent here
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    // Put any functionalities here acquired from doing an action event from any action listener in this container.
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
