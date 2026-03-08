package appproject.containers;

import java.awt.*;
import java.awt.event.*;
import appproject.lib.WindowContainer;

// Container (or Scenes) for Navigation
public class MainContainer extends WindowContainer implements ActionListener {
    // This is where you build your GUI code outside the AppWindow and WindowContainer framework.

    // This constructor is an equivalent method to the main() method of AppProject.
    public MainContainer() {
        super();
        setBackground(Color.LIGHT_GRAY);

        setLayout(new BorderLayout());
        add(setUpNavigator(), BorderLayout.WEST);
        add(setUpContent(), BorderLayout.CENTER);

        setVisible(true);
    }

    // Put any functionalities here acquired from doing an action event from any action listener in this container.
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
