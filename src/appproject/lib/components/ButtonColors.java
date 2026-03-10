package appproject.lib.components;

import java.awt.Color;

public class ButtonColors {
    public Color DEFAULT;
    public Color HOVER_ENTER;
    public Color PRESSED;
    public Color DISABLED;

    public ButtonColors() {
        updateColors();
    }

    public void updateColors() {
        this.DEFAULT = ColorTheme.NAVBUTTON_DEFAULT;
        this.HOVER_ENTER = ColorTheme.NAVBUTTON_HOVER_ENTER;
        this.PRESSED = ColorTheme.NAVBUTTON_PRESSED;
        this.DISABLED = ColorTheme.NAVBUTTON_DISABLED;
    }
}
