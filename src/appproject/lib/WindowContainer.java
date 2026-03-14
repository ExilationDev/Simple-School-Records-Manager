package appproject.lib;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import appproject.AppProject;
import appproject.containers.*;
import appproject.lib.components.*;

/**
 * Main window. Panel or navigation handler for layout design.
 * In development.
 *
 * @see javax.swing.JPanel
 * @author ExilationDev (Kristian Vinz Lizardo)
 */
public class WindowContainer extends JPanel {

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

        NavButton dashboard_btn = new NavButton("Dashboard", new ButtonColors(), ColorTheme.NAVPANEL_FONT_COLOR);
        dashboard_btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, dashboard_btn.getMinimumSize().height + 10));
        dashboard_btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        navigator.add(dashboard_btn);
        dashboard_btn.addActionListener((var e) -> {
            // AppProject.window.showContentPane(AppProject.PreloadedContainers.MAIN_CONTAINER);
            AppProject.window.showContent("Dashboard");
        });

        NavLabel record_label = new NavLabel("Record Database", ColorTheme.NAVPANEL_FONT_COLOR);
        record_label.setMaximumSize(new Dimension(Integer.MAX_VALUE, record_label.getMinimumSize().height + 20));
        record_label.setAlignmentX(Component.LEFT_ALIGNMENT);
        navigator.add(record_label);

        NavButton classes_btn = new NavButton("Classes", new ButtonColors(), ColorTheme.NAVPANEL_FONT_COLOR);
        classes_btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, classes_btn.getMinimumSize().height + 10));
        classes_btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        navigator.add(classes_btn);
        classes_btn.addActionListener((var e) -> {
            // AppProject.window.showContentPane(AppProject.PreloadedContainers.CLASSES_CONTAINER);
            AppProject.window.showContent("Classes");
        });

        NavButton students_btn = new NavButton("Students", new ButtonColors(), ColorTheme.NAVPANEL_FONT_COLOR);
        students_btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, students_btn.getMinimumSize().height + 10));
        students_btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        navigator.add(students_btn);
        students_btn.addActionListener((var e) -> {
            AppProject.window.showContentPane(new HelpContainer());
        });
        NavLabel setting_label = new NavLabel("Settings", ColorTheme.NAVPANEL_FONT_COLOR);
        setting_label.setMaximumSize(new Dimension(Integer.MAX_VALUE, setting_label.getMinimumSize().height + 20));
        setting_label.setAlignmentX(Component.LEFT_ALIGNMENT);
        navigator.add(setting_label);

        NavButton setting_btn = new NavButton("Themes", new ButtonColors(), ColorTheme.NAVPANEL_FONT_COLOR);
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
     * Gets the Singleton navigator panel.
     *
     * @see JPanel
     * @return The Singleton navigator.
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

interface ContentUpdateListener extends EventListener {
    public void contentPanelUpdatePerformed(ContentUpdateEvent e);
}

class ContentUpdateEvent extends EventObject {
    public ContentUpdateEvent(Object source) {
        super(source);
    }
}

class ContentUpdateSource {
    final java.util.List<ContentUpdateListener> listeners = new ArrayList<>();

    public void addContentUpdateListener(ContentUpdateListener l) {
        listeners.add(l);
    }

    public void removeContentUpdateListener(ContentUpdateListener l) {
        listeners.remove(l);
    }

    public void invokeEvent() {
        ContentUpdateEvent event = new ContentUpdateEvent(this);
        for (var i : listeners) {
            i.contentPanelUpdatePerformed(event);
        }
    }
}
