package appproject.containers;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import appproject.lib.WindowContainer;
import appproject.lib.components.ColorTheme;
import appproject.lib.components.FontManager;

// Container (or Scenes) for Navigation
public class MainContainer extends WindowContainer implements ActionListener {
    // This is where you build your GUI code outside the AppWindow and WindowContainer framework.
    JLabel title_label = new JLabel("Dashboard > My Classes");

    // This constructor is an equivalent method to the main() method of AppProject.
    public MainContainer() {
        setLayout(new BorderLayout());

        // Put content GUI code here
        title_label.setBounds(20, 10, 400, 30);
        title_label.setFont(new Font(null, Font.PLAIN, 20));
        getContent().add(title_label);

        add(getNavigator(), BorderLayout.WEST);
        add(getContent(), BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        title_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
    }

    // Put any functionalities here acquired from doing an action event from any action listener in this container.
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
