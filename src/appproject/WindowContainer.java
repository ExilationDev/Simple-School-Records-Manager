package appproject;

import javax.swing.JComponent;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

public interface WindowContainer {
    public List<JComponent> components = new ArrayList<>();
    
    public void addItem(JComponent component);
    public void addItem(JComponent component, int index);
    public void removeItem(JComponent component);
    public void removeItem(int index);
    public Container getContainer(int index);
}
