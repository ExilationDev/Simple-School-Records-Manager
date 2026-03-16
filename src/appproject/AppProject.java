package appproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import appproject.containers.*;
import appproject.lib.AppWindow;
import appproject.lib.WindowContainer;

/**
 * An application created by UMTC students.
 *
 * @see <a href="https://github.com/ExilationDev/CCE107-Group4Project">Github Project</a>
 * @author Ricky Guiloreza, Kristian Vinz Lizardo, Carl Francis Pacatang, Andre Quima, Jame Cris Yuson
 */
  // hello
public class AppProject {
    public static AppWindow window = new AppWindow("School Record Manager Application", true);

    // This is where you initialize your Menus and Containers.
    // This is also where you initialize menus for your AppWindow.

    /**
     * The main method of the project.
     *
     * @param args if code is executed on a terminal command-line, this will
     *             contain an array of command arguments.
     */
    public static void main(String[] args) {
        // Hello World
        // hello andre
        // Hello Carl
        // Hello guys

        // Menu Bar Setup
        window.setUpMenu("Edit", new ArrayList<>(List.of(
                window.setUpMenuInMenu("Record", new ArrayList<>(List.of(
                        new JMenuItem("Insert"),
                        new JMenuItem("Remove"),
                        new JMenuItem("Edit")
                ))),
                window.setUpMenuInMenu("Table", new ArrayList<>(List.of(
                        new JMenuItem("Modify"),
                        new JMenuItem("Layout")
                ))))));
        ((JMenu) window.getJMenuBar().getMenu(0).getItem(0)).getItem(0).addActionListener((var e) -> {
            for (Component c : ((WindowContainer)window.getCurrentContent()).getContent().getComponents()) {
                // System.out.println(c);
                if (!(c instanceof JScrollPane)) { continue; }
                Component view = ((JScrollPane)c).getViewport().getView();
                if (view instanceof JTable) {
                    window.showContentPaneAsDialog(new InsertContainer((JTable)view), "Insert Record", 475, 400, true);
                    return;
                }
            }
            JOptionPane.showMessageDialog(window, "No records found. Select a table record from the database first.", "Insert Record", JOptionPane.WARNING_MESSAGE);
        });
        ((JMenu) window.getJMenuBar().getMenu(0).getItem(0)).getItem(0).setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        ((JMenu) window.getJMenuBar().getMenu(0).getItem(0)).getItem(1).addActionListener((var e) -> {
            // window.showContentPaneAsDialog(new InsertContainer(), "Remove Record", 300, 300, true);
            JOptionPane.showMessageDialog(window, "No records found. Select a table record from the database first.", "Remove Record", JOptionPane.WARNING_MESSAGE);
        });
        ((JMenu) window.getJMenuBar().getMenu(0).getItem(0)).getItem(1).setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        ((JMenu) window.getJMenuBar().getMenu(0).getItem(0)).getItem(2).addActionListener((var e) -> {
            // window.showContentPaneAsDialog(new InsertContainer(), "Edit Record", 300, 300, true);
            JOptionPane.showMessageDialog(window, "No records found. Select a table record from the database first.", "Edit Record", JOptionPane.WARNING_MESSAGE);
        });
        ((JMenu) window.getJMenuBar().getMenu(0).getItem(0)).getItem(2).setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));

        ((JMenu) window.getJMenuBar().getMenu(0).getItem(1)).getItem(0).addActionListener((var e) -> {
            window.showContentPaneAsDialog(new StudentLogContainer(), "Modify Table", 450, 420, true);
        });

        window.setUpMenu("App", new ArrayList<>(List.of(new JMenuItem("Help"), new JMenuItem("About"), new JMenuItem("Exit"))));
        window.getJMenuBar().getMenu(1).getItem(0).addActionListener((var e) -> {
            window.showContentPaneAsDialog(new HelpContainer(), "Help", 200, 200, true);
        });
        window.getJMenuBar().getMenu(1).getItem(1).addActionListener((var e) -> {
            window.showContentPaneAsDialog(new AboutContainer(), "About", 600, 400, true);
        });
        window.getJMenuBar().getMenu(1).getItem(2).addActionListener((var e) -> {
            int res = JOptionPane.showConfirmDialog(window, "Are you sure you want to close the application?", "Exit", JOptionPane.YES_NO_OPTION);
            if (res == 1) return;
            JOptionPane.showMessageDialog(window, "The application will now close.", "Exit", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        });

        window.setUpMenu("Account", new ArrayList<>(List.of(new JMenuItem("Login"))));

        window.showContent("Dashboard");

        // Always set minimum size to prevent GUI overlapping
        window.setMinimumSize(new Dimension(700, 400));
    }
}
