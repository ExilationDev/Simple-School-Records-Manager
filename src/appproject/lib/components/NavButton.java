package appproject.lib.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class NavButton extends JButton implements MouseListener {
    private JLabel label;
    private ButtonColors buttonColor;
    private Color labelColor;

    enum ButtonStatus {
        IDLE,
        PRESSED,
        MOUSE_ENTER,
        DISABLED
    }

    public ButtonStatus buttonStatus = ButtonStatus.IDLE;

    public NavButton(String text, ButtonColors buttonColor, Color labelColor) {
        this.buttonColor = buttonColor;
        this.labelColor = labelColor;
        setLayout(new GridLayout());
        setForeground(this.buttonColor.DEFAULT);
        setBorderPainted(false);
        addMouseListener(this);

        label = new JLabel(text);
        label.setForeground(this.labelColor);
        label.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(label);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        buttonColor.updateColors();

        labelColor = ColorTheme.NAVPANEL_FONT_COLOR;
        label.setForeground(this.labelColor);
        switch (buttonStatus) {
            case IDLE -> setForeground(buttonColor.DEFAULT);
            case MOUSE_ENTER -> setForeground(buttonColor.HOVER_ENTER);
            case PRESSED -> setForeground(buttonColor.PRESSED);
            case DISABLED -> setForeground(buttonColor.DISABLED);
        }

        g.fillRect(0,  0, getWidth(), getHeight());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        buttonStatus = ButtonStatus.MOUSE_ENTER;
        revalidate();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        buttonStatus = ButtonStatus.PRESSED;
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        buttonStatus = ButtonStatus.IDLE;
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        buttonStatus = ButtonStatus.MOUSE_ENTER;
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        buttonStatus = ButtonStatus.IDLE;
        repaint();
    }
}

