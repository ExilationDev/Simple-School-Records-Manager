package appproject.lib;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import appproject.AppProject;
import appproject.containers.HelpContainer;
import appproject.lib.components.ButtonColors;
import appproject.lib.components.NavButton;
import appproject.lib.components.NavLabel;
import appproject.lib.components.ColorTheme;

/**
 * Main window. Panel or navigation handler for layout design.
 * In development.
 *
 * @see javax.swing.JPanel
 * @author ExilationDev (Kristian Vinz Lizardo)
 */
public class WindowContainer extends JPanel {


    protected WindowContainer() {
        ContentUpdateSource contentUpdateSource = new ContentUpdateSource();
        contentUpdateSource.addContentUpdateListener(AppProject.window);
        contentUpdateSource.invokeEvent();
        contentUpdateSource.removeContentUpdateListener(AppProject.window);
    }

    /**
     * Sets up the side navigator panel.
     *
     * @see javax.swing.JPanel
     * @return The JPanel of the navigator.
     */
    public JPanel setUpNavigator() {
        JPanel navigator = new JPanel();
        navigator.setLayout(new BoxLayout(navigator, BoxLayout.Y_AXIS));
        navigator.setBackground(ColorTheme.NAVPANEL_DEFAULT);
        navigator.setPreferredSize(new Dimension(250, 0));

        NavLabel home_label = new NavLabel("Main", Color.WHITE);
        home_label.setMaximumSize(new Dimension(Integer.MAX_VALUE, home_label.getMinimumSize().height + 20));
        home_label.setAlignmentX(Component.LEFT_ALIGNMENT);
        navigator.add(home_label);

        NavButton home_btn = new NavButton(
                "Home",
                new ButtonColors(
                        ColorTheme.NAVBUTTON_DEFAULT,
                        ColorTheme.NAVBUTTON_HOVER_ENTER,
                        ColorTheme.NAVBUTTON_PRESSED,
                        ColorTheme.NAVBUTTON_DISABLED
                ),
                Color.WHITE
        );
        home_btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, home_btn.getMinimumSize().height + 10));
        home_btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        navigator.add(home_btn);
        home_btn.addActionListener((var e) -> {
            AppProject.window.showContentPane(new HelpContainer());
        });

        NavLabel record_label = new NavLabel("Record Database", Color.WHITE);
        record_label.setMaximumSize(new Dimension(Integer.MAX_VALUE, record_label.getMinimumSize().height + 10));
        record_label.setAlignmentX(Component.LEFT_ALIGNMENT);
        navigator.add(record_label);

        NavButton data_btn = new NavButton(
                "Student Data Record",
                new ButtonColors(
                        ColorTheme.NAVBUTTON_DEFAULT,
                        ColorTheme.NAVBUTTON_HOVER_ENTER,
                        ColorTheme.NAVBUTTON_PRESSED,
                        ColorTheme.NAVBUTTON_DISABLED
                ),
                Color.WHITE
        );
        data_btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, data_btn.getMinimumSize().height + 10));
        data_btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        navigator.add(data_btn);
        data_btn.addActionListener((var e) -> {
            AppProject.window.showContentPane(new HelpContainer());
        });

        NavButton setting_btn = new NavButton(
                "Settings",
                new ButtonColors(
                        ColorTheme.NAVBUTTON_DEFAULT,
                        ColorTheme.NAVBUTTON_HOVER_ENTER,
                        ColorTheme.NAVBUTTON_PRESSED,
                        ColorTheme.NAVBUTTON_DISABLED
                ),
                Color.WHITE
        );
        setting_btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, setting_btn.getMinimumSize().height + 10));
        setting_btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        navigator.add(setting_btn);
        setting_btn.addActionListener((var e) -> {
            AppProject.window.showContentPane(new HelpContainer());
        });

        navigator.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        navigator.setVisible(true);
        return navigator;
    }

    /**
     * Sets up the content panel.
     *
     * @see javax.swing.JPanel
     * @return The JPanel of the content.
     */
    public JPanel setUpContent() {
        JPanel content = new JPanel();
        setOpaque(true);

        JLabel label = new JLabel("Content");
        content.add(label);

        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        content.setVisible(true);
        return content;
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
