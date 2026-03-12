package appproject.containers;

import appproject.lib.WindowContainer;
import appproject.lib.components.ColorTheme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutContainer extends WindowContainer implements ActionListener {
    // This is where you build your GUI code outside the AppWindow and WindowContainer framework.
    // JPanel navigator;
    JPanel content;

    JLabel about_label = new JLabel("About Application");
    JLabel description_label = new JLabel(
            "<html>" +
                    "Student Record Manager is an application created by UM Students." +
                    "<br>" +
                    "Kristian Vinz D. Lizardo (ExilationDev)" +
            "</html>"
    );
    // This constructor is an equivalent method to the main() method of AppProject.
    public AboutContainer() {
        super();
        setLayout(new BorderLayout());

        // add(navigator = setUpNavigator(), BorderLayout.WEST);
        add(content = setUpContent(), BorderLayout.CENTER);

        // Put content GUI code here
        // Make sure you use the content variable whenever you add components!
        about_label.setBounds(20, 20, 200, 20);
        about_label.setFont(new Font(null, Font.PLAIN, 20));

        description_label.setBounds(35, 50, 500, 300);
        description_label.setVerticalAlignment(JLabel.TOP);

        content.add(about_label);
        content.add(description_label);

        setVisible(true);
    }

    // repaint function. Put setForegrounds of your JComponent here
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        about_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        description_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        System.out.println("Repaint from " + getClass().getName());
    }

    // Put any functionalities here acquired from doing an action event from any action listener in this container.
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
