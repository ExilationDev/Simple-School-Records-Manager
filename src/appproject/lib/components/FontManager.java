package appproject.lib.components;

import javax.swing.*;
import java.awt.*;

public class FontManager {
    public static Font currentFont = new Font("Open Sans", Font.PLAIN, 15);

    public static void changeFont(Component component) {
        component.setFont(currentFont);
        if (component instanceof Container) {
            for (Component c : ((Container)component).getComponents()) {
                changeFont(c);
            }
        }
    }
}
