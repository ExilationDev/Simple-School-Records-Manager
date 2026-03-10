package appproject.lib.components;

import javax.swing.*;
import java.awt.*;

public class NavLabel extends JComponent {
    JLabel label;
    Color color;

    public NavLabel(String text, Color color) {
        label = new JLabel(text);
        setLayout(new GridLayout());
        setPreferredSize(new Dimension(100, 100));

        this.color = color;
        setForeground(this.color);
        label.setForeground(this.color);

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

        setForeground(this.color);
        label.setForeground(this.color);

        g.fillRect(0, getHeight() - 3, getWidth(), 3);

    }


}
