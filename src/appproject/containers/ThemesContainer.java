package appproject.containers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import appproject.lib.WindowContainer;
import appproject.lib.components.ColorTheme;

public class ThemesContainer extends WindowContainer implements ActionListener {
    // This is where you build your GUI code outside the AppWindow and WindowContainer framework.
    JPanel navigator;
    JPanel content;

    JLabel theme_label = new JLabel("Themes");
    JLabel theme_dropdown_label = new JLabel("Preset");

    // This constructor is an equivalent method to the main() method of AppProject.
    public ThemesContainer() {
        setLayout(new BorderLayout());

        add(navigator = setUpNavigator(), BorderLayout.WEST);
        add(content = setUpContent(), BorderLayout.CENTER);

        // Put content GUI code here
        theme_label.setBounds(20, 20, 100, 20);
        theme_label.setFont(new Font(null, Font.PLAIN, 20));
        theme_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        content.add(theme_label);

        theme_dropdown_label.setBounds(35, 50, 100, 20);
        theme_dropdown_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        content.add(theme_dropdown_label);

        JComboBox theme_dropdown = new JComboBox();
        theme_dropdown.addItem(ColorTheme.Themes.DEFAULT);
        theme_dropdown.addItem(ColorTheme.Themes.DARK);
        theme_dropdown.addItem(ColorTheme.Themes.UM);
        theme_dropdown.addItem(ColorTheme.Themes.SMC);
        theme_dropdown.setBounds(135, 50, 150, 20);
        theme_dropdown.addActionListener(this);
        content.add(theme_dropdown);

        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        theme_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        theme_dropdown_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
    }

    // Put any functionalities here acquired from doing an action event from any action listener in this container.
    @Override
    public void actionPerformed(ActionEvent e) {
        ColorTheme.ChangeTheme((ColorTheme.Themes)(((JComboBox<ColorTheme.Themes>)e.getSource()).getSelectedItem()));
    }
}
