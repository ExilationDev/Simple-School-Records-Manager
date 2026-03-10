package appproject.lib.components;

import java.awt.Color;

public class ButtonColors {
    public Color DEFAULT;
    public Color HOVER_ENTER;
    public Color PRESSED;
    public Color DISABLED;

    public ButtonColors(Color DEFAULT, Color HOVER_ENTER, Color PRESSED, Color DISABLED) {
        this.DEFAULT = DEFAULT;
        this.HOVER_ENTER = HOVER_ENTER;
        this.PRESSED = PRESSED;
        this.DISABLED = DISABLED;
    }

    public ButtonColors(Color DEFAULT) {
        this.DEFAULT = DEFAULT;
        this.HOVER_ENTER = DEFAULT;
        this.PRESSED = DEFAULT;
        this.DISABLED = DEFAULT;
    }

    public ButtonColors() {
        this.DEFAULT = ColorTheme.NAVBUTTON_DEFAULT;
        this.HOVER_ENTER = ColorTheme.NAVBUTTON_HOVER_ENTER;
        this.PRESSED = ColorTheme.NAVBUTTON_PRESSED;
        this.DISABLED = ColorTheme.NAVBUTTON_DISABLED;
    }
}
