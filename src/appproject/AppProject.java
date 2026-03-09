package appproject;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import appproject.containers.*;
import appproject.lib.AppWindow;

public class AppProject {
    public static AppWindow window = new AppWindow("Application", true);

    // This is where you initialize your Menus and Containers.
    // This is also where you initialize menus for your AppWindow.

    /**
     * The main method of the project.
     *
     * @param args if code is executed on a terminal command-line, this will
     *             contain an array of command arguments.
     */
    static void main(String[] args) {
        // Hello World
            // hello andre
            // Hello Carl
            // Hello guys

        // Menu Bar Setup
        window.setUpMenu("File", new ArrayList<>(List.of(new JMenuItem("Import Record"), window.setUpMenuInMenu("Export Record", new ArrayList<>(List.of(new JMenuItem("As JSON")))))));

        window.setUpMenu("Edit", new ArrayList<>(List.of(window.setUpMenuInMenu("Record", new ArrayList<>(List.of(new JMenuItem("Insert"), new JMenuItem("Remove"), new JMenuItem("Change")))), window.setUpMenuInMenu("Table", new ArrayList<>(List.of(new JMenuItem("Modify"), new JMenuItem("Layout")))))));
        ((JMenu) window.getJMenuBar().getMenu(1).getItem(0)).getItem(0).addActionListener((var e) -> {
            JOptionPane.showMessageDialog(window, "Insert Button Pressed", "Insert", JOptionPane.QUESTION_MESSAGE);
        });

        window.setUpMenu("App", new ArrayList<>(List.of(new JMenuItem("Help"), new JMenuItem("About"), new JMenuItem("Exit"))));
        window.getJMenuBar().getMenu(2).getItem(0).addActionListener((var e) -> {
            window.showContentPaneAsDialog(new HelpContainer(), "Help", 200, 200, true);
        });
        window.getJMenuBar().getMenu(2).getItem(1).addActionListener((var e) -> {
            window.showContentPaneAsDialog(new StudentLogContainer(), "About", 200, 200, true);
        });
        window.getJMenuBar().getMenu(2).getItem(2).addActionListener((var e) -> {
            int res = JOptionPane.showConfirmDialog(window, "Are you sure you want to close the application?", "Exit", JOptionPane.YES_NO_OPTION);
            if (res == 1) return;
            JOptionPane.showMessageDialog(window, "The application will now close.", "Exit", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        });

        window.setUpMenu("Account", new ArrayList<>(List.of(new JMenuItem("Login"))));

        window.showContentPane(new MainContainer());
        // window.showContentPane(new StudentLogContainer());
        // window.showContentPane(new HelpContainer());
    }
}
