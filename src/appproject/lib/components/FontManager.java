package appproject.lib.components;

import appproject.AppProject;
import appproject.lib.AppWindow;

import java.awt.*;
import java.io.File;
import java.io.InputStream;

public class FontManager {

    public Font customFont(File pathName, float size) {
        try (InputStream is = AppProject.class.getResourceAsStream(String.valueOf(pathName))) {
            assert is != null;
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
            font = font.deriveFont(Font.PLAIN, size);
            return font;
        } catch (Exception e) {
            AppWindow.debugPrintln(e.getMessage(), "ERROR");
        }
        return null;
    }

    public static FontManager instance = new FontManager();

    public static void changeFont(Component component) {
        component.setFont(instance.customFont(new File("resources/fonts/OpenSans-Regular.ttf"), 15f));
        AppWindow.debugPrintln("Successfully set up font in component " + component.getClass().getName(), "INIT");
        if (component instanceof Container) {
            for (Component c : ((Container)component).getComponents()) {
                changeFont(c);
            }
        }
    }
}
