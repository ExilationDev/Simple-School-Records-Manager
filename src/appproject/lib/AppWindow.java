package appproject.lib;

import appproject.AppProject;

import javax.swing.*;
import javax.swing.event.MenuListener;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * <i>Completely original backend code.</i><br>
 * Flexible window application manager for easy and simple use.
 * <p style="color:#ff8a8a">Not beginner friendly.<p/><br>
 *
 * @see javax.swing.JFrame
 * @author ExilationDev (Kristian Vinz Lizardo)
 */
@SuppressWarnings("unused")
public class AppWindow extends JFrame implements ContentUpdateListener {

    ContentUpdateSource contentUpdateSource = new ContentUpdateSource();

    /**
     * <h5>AppWindow - INITIALIZATION</h5>
     * Sets up an application window.<br>
     *
     * @param title The application window's title.
     * @param x The x position of the application window.
     * @param y The y position of the application window.
     * @param width The width of the application window.
     * @param height The height of the application window.
     * @param resizable If window is resizable.
     */
    public AppWindow(String title, int x, int y, int width, int height, boolean resizable) {
        setTitle(title);
        setResizable(resizable);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        setBounds(x, y, width, height);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * <h5>AppWindow - INITIALIZATION</h5>
     * Sets up a <b><i>centered</i></b> application window.<br>
     * Width and height values are acquired from any active monitor resolution.<br>
     *
     * @param title The application window's title.
     * @param resizable If window is resizable.
     */
    public AppWindow(String title, boolean resizable) {
        setTitle(title);
        setResizable(resizable);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        int desktopWidth = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int desktopHeight = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        int width = (int)(desktopWidth/1.25);
        int height = (int)(desktopHeight/1.25);
        setSize(width, height);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Sets up the menu button with or without items.<br>
     * Initializes in the AppWindow's menuBar.<br>
     *
     * @param label Button label of the Menu.
     * @param items Items contained in the Menu.
     */
    public void setUpMenu(String label, ArrayList<JMenuItem> items) {
        JMenu menu = new JMenu(label);
        if (items != null) items.forEach((var item) -> menu.add(item));
        getJMenuBar().add(menu);
        refreshWindow();
    }

    /**
     * Sets up the menu button with or without items in an existing menu.<br>
     *
     * @param label Button label of the Menu.
     * @param items Items contained in the Menu.
     * @return The JMenu.
     */
    public JMenu setUpMenuInMenu(String label, ArrayList<JMenuItem> items) {
        JMenu menu = new JMenu(label);
        if (items != null) items.forEach((var item) -> menu.add(item));
        refreshWindow();
        return menu;
    }

    /**
     * Configures the listener for the JMenu.<br>
     *
     * @deprecated Use JMenu.addMenuListener() instead.
     * @param menu The JMenu to be configured.
     * @param l The configured listener.
     */
    public void configureMenu(JMenu menu, MenuListener l) {
        menu.addMenuListener(l);
    }

    /**
     * Configures the action listener for the JMenuItem.<br>
     *
     * @deprecated Use JMenuItem.addActionListener() instead.
     * @param menuItem The JMenuItem to be configured.
     * @param l The configured listener.
     */
    public void configureMenuItem(JMenuItem menuItem, ActionListener l) {
        menuItem.addActionListener(l);
    }

    /**
     * Shows the existing container as main pane. Will disable previous pane.<br>
     *
     * @see javax.swing.JPanel
     * @param c Selected container to be shown.
     * @return The shown JPanel.
     */
    public WindowContainer showContentPane(WindowContainer c) {
        // System.out.println(getContentPane().getName());
        if (c == getContentPane()) return null;
        setContentPane(c);
        contentUpdateSource.addContentUpdateListener(AppProject.window);
        contentUpdateSource.invokeEvent();
        contentUpdateSource.removeContentUpdateListener(AppProject.window);
        return (WindowContainer)getContentPane();
    }

    /**
     * Shows the existing container as a separate window or dialog.<br>
     *
     * @see javax.swing.JDialog
     * @param c Selected container to be shown.
     * @param title The title of the dialog.
     * @param width The width of the dialog.
     * @param height The height of the dialog.
     * @param modal The mode of the dialog.
     * @return The shown JDialog with the container.
     */
    public JDialog showContentPaneAsDialog(WindowContainer c, String title, int width, int height, boolean modal) {
        JDialog dialog = new JDialog(this, title, modal);
        dialog.setContentPane(c);
        dialog.setSize(width, height);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
        return dialog;
    }

    /**
     * Refreshes the frame after any changes. Internal function.<br>
     */
    void refreshWindow() {
        revalidate();
        repaint();
    }

    @Override
    public void contentPanelUpdatePerformed(ContentUpdateEvent e) {
        System.out.println("Content was updated! " + e.getSource().getClass().getName());
        refreshWindow();
    }
}
