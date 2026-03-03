package appproject;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

public class AppWindow extends JFrame {
    
    JMenuBar menuBar;
    List<WindowContainer> containers;
    
    /**
     * Sets up an application window. AppWindow's constructor.
     * 
     * @param title The application window's title.
     * @param x The x position of the application window.
     * @param y The y position of the application window.
     * @param width The width of the application window.
     * @param height The height of the application window.
     */
    public AppWindow(String title, int x, int y, int width, int height) {
        setTitle(title);
        setBounds(x, y, width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        setVisible(true);
    }
    
    /**
     * Sets up the menu button with or without items.
     * 
     * @param label Button label of the Menu. 
     * @param items Items contained in the Menu.
     */
    public void setUpMenu(String label, ArrayList<JMenuItem> items) {
        JMenu menu = new JMenu(label);
        for (JMenuItem item : items) {
            menu.add(item);
        }
        menuBar.add(menu);
        refreshWindow();
    }
    
    /**
     * Shows the existing container as main pane. Will disable previous pane.
     * @param c Selected container to be shown.
     */
    public void showContentPane(Container c) {
        throw new UnsupportedOperationException("This method isn't supported yet.");
    }
    
    /**
     * Shows the existing container as main pane. Will disable previous pane.
     * @param index Selected index with a container to be shown.
     */
    public void showContentPane(int index) {
        throw new UnsupportedOperationException("This method isn't supported yet.");
    }
    
    /**
     * Refreshes the frame after any changes. Internal function.
     */
    void refreshWindow() {
        revalidate();
        repaint();
    }
}
