package appproject.lib;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import appproject.AppProject;
import appproject.containers.*;
import appproject.lib.components.*;

/**
 * Content and navigation handler for layout design.
 *
 * @see javax.swing.JPanel
 * @author ExilationDev (Kristian Vinz Lizardo)
 */
public class WindowContainer extends JPanel {

    // For some reason, I can't turn this variable into a singleton instance :(
    // The navigator should have been separate :/
    private JPanel navigator;
    private JPanel content;

    /**
     * Sets up the side navigator panel.
     *
     * @see JPanel
     */
    void setUpNavigator() {
        navigator.setLayout(new BoxLayout(navigator, BoxLayout.Y_AXIS));
        navigator.setPreferredSize(new Dimension(200, 100));

        NavLabel home_label = new NavLabel("Home", ColorTheme.NAVPANEL_FONT_COLOR);
        home_label.setMaximumSize(new Dimension(Integer.MAX_VALUE, home_label.getMinimumSize().height + 20));
        home_label.setAlignmentX(Component.LEFT_ALIGNMENT);
        navigator.add(home_label);

        NavButton welcome_btn = new NavButton("Welcome", ColorTheme.NAVPANEL_FONT_COLOR);
        welcome_btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, welcome_btn.getMinimumSize().height + 10));
        welcome_btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        navigator.add(welcome_btn);
        welcome_btn.addActionListener((var e) -> {
            // AppProject.window.showContentPane(AppProject.PreloadedContainers.MAIN_CONTAINER);
            AppProject.window.showContent("Welcome");
        });

        NavButton dashbaord_btn = new NavButton("Dashboard", ColorTheme.NAVPANEL_FONT_COLOR);
        dashbaord_btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, welcome_btn.getMinimumSize().height + 10));
        dashbaord_btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        navigator.add(dashbaord_btn);
        dashbaord_btn.addActionListener((var e) -> {
            // AppProject.window.showContentPane(AppProject.PreloadedContainers.MAIN_CONTAINER);
            AppProject.window.showContent("Dashboard");
        });

        NavLabel record_label = new NavLabel("Record Database", ColorTheme.NAVPANEL_FONT_COLOR);
        record_label.setMaximumSize(new Dimension(Integer.MAX_VALUE, record_label.getMinimumSize().height + 20));
        record_label.setAlignmentX(Component.LEFT_ALIGNMENT);
        navigator.add(record_label);

        NavButton classes_btn = new NavButton("Classes", ColorTheme.NAVPANEL_FONT_COLOR);
        classes_btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, classes_btn.getMinimumSize().height + 10));
        classes_btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        navigator.add(classes_btn);
        classes_btn.addActionListener((var e) -> {
            // AppProject.window.showContentPane(AppProject.PreloadedContainers.CLASSES_CONTAINER);
            AppProject.window.showContent("Classes");
        });

        NavButton students_btn = new NavButton("Students", ColorTheme.NAVPANEL_FONT_COLOR);
        students_btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, students_btn.getMinimumSize().height + 10));
        students_btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        navigator.add(students_btn);
        students_btn.addActionListener((var e) -> {
            AppProject.window.showContent("Students");
            // AppProject.window.showContentPane(new HelpContainer());
        });
        NavLabel setting_label = new NavLabel("Settings", ColorTheme.NAVPANEL_FONT_COLOR);
        setting_label.setMaximumSize(new Dimension(Integer.MAX_VALUE, setting_label.getMinimumSize().height + 20));
        setting_label.setAlignmentX(Component.LEFT_ALIGNMENT);
        navigator.add(setting_label);

        NavButton setting_btn = new NavButton("Themes", ColorTheme.NAVPANEL_FONT_COLOR);
        setting_btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, setting_btn.getMinimumSize().height + 10));
        setting_btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        navigator.add(setting_btn);
        setting_btn.addActionListener((var e) -> {
            // AppProject.window.showContentPane(AppProject.PreloadedContainers.THEMES_CONTAINER);
            AppProject.window.showContent("Themes");
        });

        FontManager.changeFont(navigator);
        navigator.setBackground(ColorTheme.NAVPANEL_DEFAULT);
        navigator.setVisible(true);
    }

    /**
     * Gets the navigator panel.
     *
     * @see JPanel
     * @return The navigator of the content panel.
     */
    public JPanel getNavigator() {
        if (navigator == null) {
            navigator = new JPanel();
            setUpNavigator();
            AppWindow.debugPrintln("Successfully set up navigator!", "INIT");
        }
        return navigator;
    }

    /**
     * Sets up the content panel.
     *
     * @see javax.swing.JPanel
     */
    void setUpContent() {
        content.setLayout(null);

        content.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        content.setBackground(ColorTheme.CONTENT_DEFAULT);
        content.setVisible(true);
    }

    /**
     * Gets the content panel.
     *
     * @see JPanel
     * @return The content of the container panel.
     */
    public JPanel getContent() {
        if (content == null) {
            content = new JPanel();
            setUpContent();
            AppWindow.debugPrintln("Successfully set up content for " + getClass().getName() + "!", "INIT");
        }
        return content;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100, 100);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (navigator != null) navigator.setBackground(ColorTheme.NAVPANEL_DEFAULT);
        content.setBackground(ColorTheme.CONTENT_DEFAULT);
        AppWindow.debugPrintln("Repainting " + getClass().getName() + "...", "UPDATE");
    }
}
