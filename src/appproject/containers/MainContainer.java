package appproject.containers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import appproject.AppProject;
import appproject.lib.WindowContainer;

// Container (or Scenes) for Navigation
public class MainContainer extends WindowContainer implements ActionListener {
    // This is where you build your GUI code outside the AppWindow and WindowContainer framework.

    // This constructor is an equivalent method to the main() method of AppProject.
    public MainContainer() {
        setBackground(Color.LIGHT_GRAY);

        setLayout(new BorderLayout());
        add(setUpNavigator(), BorderLayout.WEST);
        add(setUpContent(), BorderLayout.CENTER);

        // setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        setVisible(true);
    }

    JPanel setUpNavigator() {
        JPanel navigator = new JPanel();
        navigator.setBackground(Color.GRAY);
        navigator.setPreferredSize(new Dimension(350, 0));
        // navigator.setBounds(0, 0, 100, 500);

        JLabel home_label = new JLabel("Main");
        home_label.setMaximumSize(new Dimension(Integer.MAX_VALUE, home_label.getMinimumSize().height + 10));
        home_label.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 5));
        navigator.add(home_label);

        JButton home_btn = new JButton("Home");
        home_btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, home_btn.getMinimumSize().height + 20));
        navigator.add(home_btn);
        home_btn.addActionListener((var e) -> {
            AppProject.window.showContentPane(new HelpContainer());
        });

        JButton data_btn = new JButton("Record Database");
        data_btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, data_btn.getMinimumSize().height + 20));
        navigator.add(data_btn);

        JButton setting_btn = new JButton("Settings");
        setting_btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, setting_btn.getMinimumSize().height + 20));
        navigator.add(setting_btn);

        navigator.setLayout(new BoxLayout(navigator, BoxLayout.Y_AXIS));
        navigator.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        navigator.setVisible(true);
        return navigator;
    }

    JPanel setUpContent() {
        JPanel content = new JPanel();
        setOpaque(true);

        JLabel label = new JLabel("Content");
        content.add(label);

        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        content.setVisible(true);
        return content;
    }

    // Put any functionalities here acquired from doing an action event from any action listener in this container.
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
