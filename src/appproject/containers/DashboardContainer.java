package appproject.containers;

import appproject.lib.WindowContainer;
import appproject.lib.components.ColorTheme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardContainer extends WindowContainer implements ActionListener {
    // This is where you build your GUI code outside the AppWindow and WindowContainer framework.
    JLabel title_label = new JLabel("Dashboard > My Classes");

    // This constructor is an equivalent method to the main() method of AppProject.
    public DashboardContainer() {
        setLayout(new BorderLayout());

        title_label.setBounds(20, 10, 400, 30);
        title_label.setFont(new Font(null, Font.PLAIN, 20));
        getContent().add(title_label);

        add(getNavigator(), BorderLayout.WEST);
        add(getContent(), BorderLayout.CENTER);

        setVisible(true);
    }

    // repaint function. Put setForegrounds of your JComponent here to sync with the themes.
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
