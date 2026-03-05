package appproject.containers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import appproject.*;

public class MainContainer extends JPanel implements ActionListener {
    // This is where you build your GUI code outside the AppWindow framework.
    // MainContainer() is an equivalent method to the main() method of AppProject.
    public MainContainer() {
        setBackground(Color.LIGHT_GRAY);
        
        JLabel label = new JLabel("Hello, world!");
        label.setBounds(10, 10, 100, 13);
        add(label);
        
        setLayout(null);
        setVisible(true);
    }

    // Put any functionalities here acquired from doing an action event from any action listener in this container.
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
