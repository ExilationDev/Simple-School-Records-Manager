package appproject.containers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import appproject.lib.WindowContainer;

public class HelpContainer extends WindowContainer implements ActionListener {
    // This is where you build your GUI code outside the AppWindow and WindowContainer framework.
    JPanel content;

    // This constructor is an equivalent method to the main() method of AppProject.
    public HelpContainer() {
        super();
        setLayout(new BorderLayout());

        add(content = setUpContent(), BorderLayout.CENTER);

        setVisible(true);
    }

    // Put any functionalities here acquired from doing an action event from any action listener in this container.
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

