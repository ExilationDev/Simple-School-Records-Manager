package appproject.lib.components;

import java.awt.*;
import appproject.AppProject;

public class ColorTheme {
    // Standard Theme (Default)
    public static Color DEFAULT_COLOR = new Color(255, 255, 255); // this is particularly useless

    public static Color NAVPANEL_DEFAULT = new Color(37, 46, 54);
    public static Color NAVPANEL_FONT_COLOR = new Color(255, 255, 255);

    public static Color NAVBUTTON_DEFAULT = new Color(37, 46, 54);
    public static Color NAVBUTTON_HOVER_ENTER = new Color(72, 95, 115);
    public static Color NAVBUTTON_PRESSED = new Color(143, 176, 204);
    public static Color NAVBUTTON_DISABLED = new Color(25, 30, 36);

    public static Color CONTENT_DEFAULT = new Color(255, 255, 255);
    public static Color CONTENT_FONT_COLOR = new Color(0, 0, 0);

    public enum Themes {
        DEFAULT,
        DARK,
        UM,
        SMC
    }

    public static void ChangeTheme(Themes theme) {
        System.out.println(theme);
        switch (theme) {
            case DEFAULT -> {
                NAVPANEL_DEFAULT = new Color(37, 46, 54);
                NAVPANEL_FONT_COLOR = new Color(255, 255, 255);

                NAVBUTTON_DEFAULT = new Color(37, 46, 54);
                NAVBUTTON_HOVER_ENTER = new Color(72, 95, 115);
                NAVBUTTON_PRESSED = new Color(143, 176, 204);
                NAVBUTTON_DISABLED = new Color(25, 30, 36);

                CONTENT_DEFAULT = new Color(255, 255, 255);
                CONTENT_FONT_COLOR = new Color(0, 0, 0);
            }
            case DARK -> {
                NAVPANEL_DEFAULT = new Color(26, 26, 26);
                NAVPANEL_FONT_COLOR = new Color(255, 255, 255);

                NAVBUTTON_DEFAULT = new Color(26, 26, 26);
                NAVBUTTON_HOVER_ENTER = new Color(60, 60, 60);
                NAVBUTTON_PRESSED = new Color(100, 100, 100);
                NAVBUTTON_DISABLED = new Color(15, 15, 15);

                CONTENT_DEFAULT = new Color(75, 75, 75);
                CONTENT_FONT_COLOR = new Color(255, 255, 255);
            }
            case UM -> {
                NAVPANEL_DEFAULT = new Color(255, 255, 255);
                NAVPANEL_FONT_COLOR = new Color(175, 37, 50);

                NAVBUTTON_DEFAULT = new Color(255, 255, 255);
                NAVBUTTON_HOVER_ENTER = new Color(220, 220, 220);
                NAVBUTTON_PRESSED = new Color(200, 200, 200);
                NAVBUTTON_DISABLED = new Color(150, 150, 150);

                CONTENT_DEFAULT = new Color(238, 238, 238);
                CONTENT_FONT_COLOR = new Color(37, 37, 37);
            }
            case SMC -> {
                NAVPANEL_DEFAULT = new Color(4, 43, 141);
                NAVPANEL_FONT_COLOR = new Color(255, 255, 255);

                NAVBUTTON_DEFAULT = new Color(4, 43, 141);
                NAVBUTTON_HOVER_ENTER = new Color(6, 73, 184);
                NAVBUTTON_PRESSED = new Color(8, 133, 237);
                NAVBUTTON_DISABLED = new Color(1, 15, 48);

                CONTENT_DEFAULT = new Color(255, 255, 255);
                CONTENT_FONT_COLOR = new Color(51, 51, 51);
            }
        }

        AppProject.window.revalidate();
        AppProject.window.repaint();
    }
}
