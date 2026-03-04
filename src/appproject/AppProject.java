package appproject;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import appproject.containers.*;

public class AppProject {

    /**
     * The main method of the project.
     *
     * @param args if code is executed on a terminal command-line, this will
     * contain an array of command arguments.
     */
    public static void main(String[] args) {
        AppWindow window = new AppWindow("Application", true);

        // Menu Bar Setup
        window.setUpMenu("Test", new ArrayList<>(List.of(new JMenuItem("TestItem"))));

        window.setUpMenu("Test1", new ArrayList<>(List.of(
                new JMenuItem("TestItem1"),
                window.setUpMenuInMenu("TestItem2", new ArrayList<>(List.of(
                        new JMenuItem("TestItem2TestItem"),
                        new JMenuItem("TestItem2TestItem1"),
                        new JMenuItem("TestItem2TestItem2")
                ))),
                new JMenuItem("Spawn Dialog")
        )));
        window.configureMenuItem(
                window.getJMenuBar().getMenu(1).getItem(2),
                (var e) -> window.showContentPaneAsDialog(new MainContainer(), "Spawn Dialog", 200, 200, true)
        );

        window.setUpMenu("Button", new ArrayList<>(List.of(new JMenuItem("Send Message"))));
        window.configureMenuItem(
                window.getJMenuBar().getMenu(2).getItem(0),
                (var e) -> JOptionPane.showMessageDialog(
                        window,
                        "Hello, world!",
                        "HelloWorld Title",
                        JOptionPane.QUESTION_MESSAGE
                )
        );

        window.setUpMenu("App", new ArrayList<>(List.of(new JMenuItem("Exit"))));
        window.configureMenuItem(
                window.getJMenuBar().getMenu(3).getItem(0),
                (var e) -> {
                    int res = JOptionPane.showConfirmDialog(
                            window,
                            "Are you sure you want to close the application?",
                            "Exit",
                            JOptionPane.YES_NO_OPTION
                    );
                    if (res == 1) return;
                    JOptionPane.showMessageDialog(
                            window,
                            "The application will now close.",
                            "Exit",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    System.exit(0);
                }
        );

        window.showContentPane(new MainContainer());
    }
}
