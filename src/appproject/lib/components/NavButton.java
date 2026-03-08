package appproject.lib.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavButton extends JButton implements ActionListener {
    public NavButton(String text) {
        super(text);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("button is press");
    }
}
