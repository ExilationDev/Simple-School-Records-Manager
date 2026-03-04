package appproject.containers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainContainer extends JPanel implements ActionListener {
    public MainContainer() {
        setBackground(Color.LIGHT_GRAY);
        
        JLabel label = new JLabel("Hello, world!");
        label.setBounds(10, 10, 100, 13);
        add(label);
        
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
