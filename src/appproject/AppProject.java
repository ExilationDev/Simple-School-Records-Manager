package appproject;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AppProject {
    /**
     * The main method of the project.
     * 
     * @param args if code is executed on a terminal command-line, this will contain an array of command arguments.
     */
    public static void main(String[] args) {
        AppWindow window = new AppWindow("Application", 100, 100, 500, 500);
        window.setUpMenu("Test", new ArrayList<>(Arrays.asList(new JMenuItem("TestItem"))));
        window.setUpMenu("Test1", new ArrayList<>(Arrays.asList(
                new JMenuItem("TestItem1"),
                new JMenuItem("TestItem2"),
                new JMenuItem("TestItem3")
        )));
    }
}