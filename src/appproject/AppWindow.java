package appproject;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.util.ArrayList;

public class AppWindow extends JFrame {
    
    JMenuBar menuBar;
    
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
    }
}
