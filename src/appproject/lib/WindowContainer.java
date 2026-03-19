package appproject.lib;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import appproject.containers.*;
import appproject.lib.components.*;

/**
 * Content and navigation handler for layout design.
 *
 * @see javax.swing.JPanel
 * @author ExilationDev (Kristian Vinz Lizardo)
 */
public class WindowContainer extends JPanel {

    /**
     * Sets up the WindowContainer.
     *
     * @see javax.swing.JPanel
     */
    public WindowContainer() {
        setUpContent();
        setLayout(new BorderLayout());
        AppWindow.debugPrintln("Successfully set up content for " + getClass().getName() + "!", "INIT");
    }

    /**
     * Sets up the content panel of WindowContainer.
     *
     * @see javax.swing.JPanel
     */
    void setUpContent() {
        setLayout(new BorderLayout());

        setBackground(ColorTheme.CONTENT_DEFAULT);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100, 100);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(ColorTheme.CONTENT_DEFAULT);
        AppWindow.debugPrintln("Repainting " + getClass().getSimpleName() + "...", "UPDATE");
    }
}
