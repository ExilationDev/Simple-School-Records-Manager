package appproject.lib;

import javax.swing.*;
import java.awt.*;
import java.util.*;

import appproject.lib.AppWindow;

/**
 * Main window. Panel or navigation handler for layout design.
 * In development.
 *
 * @see javax.swing.JPanel
 * @author ExilationDev (Kristian Vinz Lizardo)
 */
public class WindowContainer extends JPanel {
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
