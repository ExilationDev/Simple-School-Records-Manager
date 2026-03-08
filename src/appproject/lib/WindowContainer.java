package appproject.lib;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import appproject.AppProject;
import appproject.containers.HelpContainer;
import appproject.lib.components.NavLabel;

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
        navigator.setBackground(Color.GRAY);
        navigator.setPreferredSize(new Dimension(250, 0));

        NavLabel home_label = new NavLabel("Main", Color.WHITE);
        home_label.setMaximumSize(new Dimension(Integer.MAX_VALUE, home_label.getMinimumSize().height + 10));
        navigator.add(home_label);

        JButton home_btn = new JButton("Home");
        home_btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, home_btn.getMinimumSize().height + 20));
        navigator.add(home_btn);
        home_btn.addActionListener((var e) -> {
            AppProject.window.showContentPane(new HelpContainer());
        });

        NavLabel record_label = new NavLabel("Record Database", Color.WHITE);
        record_label.setMaximumSize(new Dimension(Integer.MAX_VALUE, record_label.getMinimumSize().height + 10));
        navigator.add(record_label);

        JButton data_btn = new JButton("Student Records");
        data_btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, data_btn.getMinimumSize().height + 20));
        navigator.add(data_btn);

        JButton setting_btn = new JButton("Settings");
        setting_btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, setting_btn.getMinimumSize().height + 20));
        navigator.add(setting_btn);

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
