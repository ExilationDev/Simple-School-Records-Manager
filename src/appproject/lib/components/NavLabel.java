package appproject.lib.components;

import javax.swing.*;
import java.awt.*;

public class NavLabel extends JComponent {

    public NavLabel(String text, Color color) {
        setLayout(new GridLayout());
        setPreferredSize(new Dimension(100, 100));
        setForeground(color);

        JLabel label = new JLabel(text);
        label.setForeground(color);
        // label.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
        label.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(label);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(150, 40);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillRect(0, getHeight() - 3, getWidth(), 3);
    }


}
