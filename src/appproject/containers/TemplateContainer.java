package appproject.containers;

import appproject.lib.WindowContainer;
import appproject.lib.components.ColorTheme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Container (or Scenes) for Navigation
public class TemplateContainer extends WindowContainer implements ActionListener {
    // This is where you build your GUI code outside the AppWindow and WindowContainer framework.

    // This constructor is an equivalent method to the main() method of AppProject.
    public TemplateContainer() {
        super();

        // Put content GUI code here
        // Make sure you use the content variable whenever you add components!

        setVisible(true);
    }

    // repaint function. Put setForegrounds of your JComponent here to sync with the themes.
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    // Put any functionalities here acquired from doing an action event from any action listener in this container.
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}