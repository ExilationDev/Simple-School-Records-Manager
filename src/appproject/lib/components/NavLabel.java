package appproject.lib.components;

import javax.swing.*;
import java.awt.*;

public class NavLabel extends JComponent {
    private JLabel label;
    private Color labelColor;

    public NavLabel(String text, Color color) {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setPreferredSize(new Dimension(100, 100));

        label = new JLabel(text);
        label.setForeground(color);
        label.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
        add(label);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(150, 40);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(labelColor);
        g.fillRect(0, getHeight() - 5, getWidth(), 5);
    }


}
