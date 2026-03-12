package appproject.containers;

import appproject.lib.WindowContainer;
import appproject.lib.components.ColorTheme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutContainer extends WindowContainer implements ActionListener {
    // This is where you build your GUI code outside the AppWindow and WindowContainer framework.

    JLabel about_label = new JLabel("About Application");
    JLabel description_label = new JLabel(
            "<html>" +
                    "Student Record Manager is a simple productivity application used to manage records set by faculty members. This application was created by UMTC BSCS students." +
                    "<br><br>" +
                    "<h3>Lead Developer (Full-Stack)</h3>Kristian Vinz Lizardo (ExilationDev)<br><br>" +
                    "<h3>Front-end Developers</h3>Andre Quima<br>Carl Francis Pacatang (CarlFran)<br>Jame Cris Yuson<br>Ricky Guiloreza" +
            "</html>"
    );

    // This constructor is an equivalent method to the main() method of AppProject.
    public AboutContainer() {
        setLayout(new BorderLayout());
        add(new JPanel(), BorderLayout.WEST);
        add(getContent(), BorderLayout.CENTER);

        // Put content GUI code here
        // Make sure you use getContent() when you add components!
        about_label.setBounds(20, 20, 200, 20);
        about_label.setFont(new Font(null, Font.PLAIN, 20));

        description_label.setBounds(35, 50, 500, 300);
        description_label.setVerticalAlignment(JLabel.TOP);

        getContent().add(about_label);
        getContent().add(description_label);

        setVisible(true);
    }

    // repaint function. Put setForegrounds of your JComponent here
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        about_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        description_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
    }

    // Put any functionalities here acquired from doing an action event from any action listener in this container.
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
