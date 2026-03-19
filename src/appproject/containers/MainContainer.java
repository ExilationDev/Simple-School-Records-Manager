package appproject.containers;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import appproject.lib.WindowContainer;
import appproject.lib.components.ColorTheme;
import appproject.lib.components.FontManager;

// Container (or Scenes) for Navigation
public class MainContainer extends WindowContainer implements ActionListener {

    JLabel test = new JLabel();

    public MainContainer() {
        super();

        // Create welcome panel with background
        JPanel welcomePanel = createWelcomePanel();

        // Add welcome panel
        add(welcomePanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createWelcomePanel() {
        // 🔹 FIXED: Use getClass().getResource() to load image properly
        // Put the image in: src/appproject/images/ folder
        java.net.URL imageUrl = getClass().getResource("/appproject/images/bgum.png");
        
        // Create a custom panel that paints the background image
        JPanel panel = new JPanel(new BorderLayout()) {
            private Image bgImage;
            
            {
                // Load image in instance initializer
                if (imageUrl != null) {
                    bgImage = new ImageIcon(imageUrl).getImage();
                } else {
                    System.err.println("Image not found! Check path: /appproject/images/umlogoo.png");
                }
            }
            
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw background image scaled to panel size
                if (bgImage != null) {
                    g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        // 🔹 Semi-transparent overlay panel
        JPanel overlay = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw semi-transparent black overlay
                g.setColor(new Color(0, 0, 0, 150));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        overlay.setOpaque(false);
        overlay.setBorder(new EmptyBorder(30, 30, 30, 30));

        // 🔹 HTML Styled Text para chuy
        JLabel welcomeLabel = new JLabel(
            "<html><div style='text-align:center;'>" +
            "<h1 style='color:white;'>Welcome to School Record Manager</h1>" +
            "<p style='color:white;font-size:14px;'>" +
            "This application is designed to simplify and organize school operations by providing an efficient way to manage academic records. It helps administrators and staff handle essential data with accuracy, speed, and ease." +
            "</p>" +
            "<br><p style='color:white;font-size:14px;text-align:left;'><b>Features:</b></p>" +
            "<ul style='color:white;font-size:13px;text-align:left;display:inline-block;'>" +
            "<li>Class Management</li>" +
            "<li>Student Management</li>" +
            "<li>Course Management</li>" +
            "<li>Reports</li>" +
            "</ul></div></html>"
        );

        overlay.add(welcomeLabel, BorderLayout.CENTER);
        panel.add(overlay, BorderLayout.CENTER);

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Add actions here if needed
    }
}
