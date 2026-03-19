package appproject.containers;

import appproject.AppProject;
import appproject.lib.components.ColorTheme;
import appproject.lib.components.FontManager;
import appproject.lib.components.NavButton;
import appproject.lib.components.NavLabel;

import javax.swing.*;
import java.awt.*;

public class NavigatorContainer extends JPanel {

    public NavigatorContainer() {
        setUpNavigator();
    }

    /**
     * Sets up the side navigator panel.
     *
     * @see JPanel
     */
    void setUpNavigator() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(200, 100));

        NavLabel home_label = new NavLabel("Home", ColorTheme.NAVPANEL_FONT_COLOR);
        home_label.setMaximumSize(new Dimension(Integer.MAX_VALUE, home_label.getMinimumSize().height + 20));
        home_label.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(home_label);

        NavButton welcome_btn = new NavButton("Welcome", ColorTheme.NAVPANEL_FONT_COLOR);
        welcome_btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, welcome_btn.getMinimumSize().height + 10));
        welcome_btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(welcome_btn);
        welcome_btn.addActionListener((var e) -> {
            // AppProject.window.showContentPane(AppProject.PreloadedContainers.MAIN_CONTAINER);
            AppProject.window.showContent("Welcome");
        });

        NavButton dashbaord_btn = new NavButton("Dashboard", ColorTheme.NAVPANEL_FONT_COLOR);
        dashbaord_btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, welcome_btn.getMinimumSize().height + 10));
        dashbaord_btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(dashbaord_btn);
        dashbaord_btn.addActionListener((var e) -> {
            // AppProject.window.showContentPane(AppProject.PreloadedContainers.MAIN_CONTAINER);
            AppProject.window.showContent("Dashboard");
        });

        NavLabel record_label = new NavLabel("Record Database", ColorTheme.NAVPANEL_FONT_COLOR);
        record_label.setMaximumSize(new Dimension(Integer.MAX_VALUE, record_label.getMinimumSize().height + 20));
        record_label.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(record_label);

        NavButton classes_btn = new NavButton("Classes", ColorTheme.NAVPANEL_FONT_COLOR);
        classes_btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, classes_btn.getMinimumSize().height + 10));
        classes_btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(classes_btn);
        classes_btn.addActionListener((var e) -> {
            // AppProject.window.showContentPane(AppProject.PreloadedContainers.CLASSES_CONTAINER);
            AppProject.window.showContent("Classes");
        });

        NavButton students_btn = new NavButton("Students", ColorTheme.NAVPANEL_FONT_COLOR);
        students_btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, students_btn.getMinimumSize().height + 10));
        students_btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(students_btn);
        students_btn.addActionListener((var e) -> {
            AppProject.window.showContent("Students");
            // AppProject.window.showContentPane(new HelpContainer());
        });
        NavLabel setting_label = new NavLabel("Settings", ColorTheme.NAVPANEL_FONT_COLOR);
        setting_label.setMaximumSize(new Dimension(Integer.MAX_VALUE, setting_label.getMinimumSize().height + 20));
        setting_label.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(setting_label);

        NavButton setting_btn = new NavButton("Themes", ColorTheme.NAVPANEL_FONT_COLOR);
        setting_btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, setting_btn.getMinimumSize().height + 10));
        setting_btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(setting_btn);
        setting_btn.addActionListener((var e) -> {
            // AppProject.window.showContentPane(AppProject.PreloadedContainers.THEMES_CONTAINER);
            AppProject.window.showContent("Themes");
        });

        FontManager.changeFont(this);
        setBackground(ColorTheme.NAVPANEL_DEFAULT);
        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(ColorTheme.NAVPANEL_DEFAULT);
    }
}
