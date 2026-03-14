package appproject.containers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import appproject.AppProject;
import appproject.lib.WindowContainer;
import appproject.lib.components.ColorTheme;

public class ThemesContainer extends WindowContainer implements ActionListener {
    // This is where you build your GUI code outside the AppWindow and WindowContainer framework.

    JScrollPane scroll_pane = new JScrollPane();
    JPanel component = new JPanel();

    JLabel theme_label = new JLabel("Themes");
    JLabel preset_dropdown_label = new JLabel("Window Preset");
    JComboBox<ColorTheme.Themes> preset_dropdown = new JComboBox<>();
    JLabel navigator_group_label = new JLabel("Navigator");
    JLabel navpanel_label = new JLabel("Navigator Panel");
    JButton navpanel_btn = new JButton("Change Color");
    JLabel navtext_label = new JLabel("Navigator Text");
    JButton navtext_btn = new JButton("Change Color");
    JLabel navbtn_idle_label = new JLabel("Navigator Button Idle");
    JButton navbtn_idle_btn = new JButton("Change Color");
    JLabel navbtn_hover_label = new JLabel("Navigator Button Hover");
    JButton navbtn_hover_btn = new JButton("Change Color");
    JLabel navbtn_selected_label = new JLabel("Navigator Button Selected");
    JButton navbtn_selected_btn = new JButton("Change Color");
    JLabel navbtn_disabled_label = new JLabel("Navigator Button Disabled");
    JButton navbtn_disabled_btn = new JButton("Change Color");
    JLabel content_group_label = new JLabel("Content");
    JLabel contentpanel_label = new JLabel("Content Panel");
    JButton contentpanel_btn = new JButton("Change Color");
    JLabel contenttext_label = new JLabel("Content Text");
    JButton contenttext_btn = new JButton("Change Color");

    // This constructor is an equivalent method to the main() method of AppProject.
    public ThemesContainer() {
        setLayout(new BorderLayout());

        add(getNavigator(), BorderLayout.WEST);
        add(getContent(), BorderLayout.CENTER);

        // Put content GUI code here
        scroll_pane.setBounds(0, 0, 1000, 1000);
        scroll_pane.setOpaque(false);
        scroll_pane.getViewport().setOpaque(false);
        scroll_pane.getViewport().setBackground(new Color(0,0,0,0));
        scroll_pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll_pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        theme_label.setBounds(20, 10, 200, 30);
        theme_label.setFont(new Font(null, Font.PLAIN, 20));

        preset_dropdown_label.setBounds(35, 50, 200, 20);

        preset_dropdown.addItem(ColorTheme.Themes.DEFAULT);
        preset_dropdown.addItem(ColorTheme.Themes.DARK);
        preset_dropdown.addItem(ColorTheme.Themes.UM);
        preset_dropdown.addItem(ColorTheme.Themes.SMC);
        preset_dropdown.setBounds(235, 50, 200, 20);
        preset_dropdown.addActionListener(this);

        navigator_group_label.setBounds(20, 90, 200, 30);
        navigator_group_label.setFont(new Font(null, Font.PLAIN, 20));

        navpanel_label.setBounds(35, 130, 200, 20);
        navpanel_btn.setBounds(235, 130, 200, 20);
        navpanel_btn.addActionListener(this);

        navtext_label.setBounds(35, 160, 200, 20);
        navtext_btn.setBounds(235, 160, 200, 20);
        navtext_btn.addActionListener(this);

        navbtn_idle_label.setBounds(35, 190, 200, 20);
        navbtn_idle_btn.setBounds(235, 190, 200, 20);
        navbtn_idle_btn.addActionListener(this);

        navbtn_hover_label.setBounds(35, 220, 200, 20);
        navbtn_hover_btn.setBounds(235, 220, 200, 20);
        navbtn_hover_btn.addActionListener(this);

        navbtn_selected_label.setBounds(35, 250, 200, 20);
        navbtn_selected_btn.setBounds(235, 250, 200, 20);
        navbtn_selected_btn.addActionListener(this);

        navbtn_disabled_label.setBounds(35, 280, 200, 20);
        navbtn_disabled_btn.setBounds(235, 280, 200, 20);
        navbtn_disabled_btn.addActionListener(this);

        content_group_label.setBounds(20, 320, 200, 30);
        content_group_label.setFont(new Font(null, Font.PLAIN, 20));

        contentpanel_label.setBounds(35, 360, 200, 20);
        contentpanel_btn.setBounds(235, 360, 200, 20);
        contentpanel_btn.addActionListener(this);

        contenttext_label.setBounds(35, 390, 200, 20);
        contenttext_btn.setBounds(235, 390, 200, 20);
        contenttext_btn.addActionListener(this);

        component.setBounds(0, 0, 500, 300);
        component.setPreferredSize(new Dimension(500, 420));
        component.setLayout(null);
        component.setOpaque(false);

        component.add(theme_label);
        component.add(preset_dropdown_label);
        component.add(preset_dropdown);
        component.add(navigator_group_label);
        component.add(navpanel_label);
        component.add(navpanel_btn);
        component.add(navtext_label);
        component.add(navtext_btn);
        component.add(navbtn_idle_label);
        component.add(navbtn_idle_btn);
        component.add(navbtn_hover_label);
        component.add(navbtn_hover_btn);
        component.add(navbtn_selected_label);
        component.add(navbtn_selected_btn);
        component.add(navbtn_disabled_label);
        component.add(navbtn_disabled_btn);
        component.add(content_group_label);
        component.add(contentpanel_label);
        component.add(contentpanel_btn);
        component.add(contenttext_label);
        component.add(contenttext_btn);

        scroll_pane.setViewportView(component);

        getContent().add(scroll_pane);

        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        scroll_pane.setBounds(0, 0, getContent().getWidth(), getContent().getHeight());
        revalidate();

        theme_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        preset_dropdown_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        navigator_group_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        navpanel_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        navtext_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        navbtn_idle_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        navbtn_hover_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        navbtn_selected_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        navbtn_disabled_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        content_group_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        contentpanel_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        contenttext_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
    }

    // Put any functionalities here acquired from doing an action event from any action listener in this container.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JComboBox) ColorTheme.ChangeTheme((ColorTheme.Themes)(((JComboBox<ColorTheme.Themes>)e.getSource()).getSelectedItem()));
        else if (e.getSource() instanceof JButton) {
            if (e.getSource().equals(navpanel_btn)) {
                Color c = JColorChooser.showDialog(this, "Navigator Panel Color", ColorTheme.NAVPANEL_DEFAULT);
                ColorTheme.NAVPANEL_DEFAULT = c == null ? ColorTheme.NAVPANEL_DEFAULT : c;
            } else if (e.getSource().equals(navtext_btn)) {
                Color c = JColorChooser.showDialog(this, "Navigator Font Color", ColorTheme.NAVPANEL_FONT_COLOR);
                ColorTheme.NAVPANEL_FONT_COLOR = c == null ? ColorTheme.NAVPANEL_FONT_COLOR : c;
            } else if (e.getSource().equals(navbtn_idle_btn)) {
                Color c = JColorChooser.showDialog(this, "Navigator Button Idle Color", ColorTheme.NAVBUTTON_DEFAULT);
                ColorTheme.NAVBUTTON_DEFAULT = c == null ? ColorTheme.NAVBUTTON_DEFAULT : c;
            } else if (e.getSource().equals(navbtn_hover_btn)) {
                Color c = JColorChooser.showDialog(this, "Navigator Button Hover Color", ColorTheme.NAVBUTTON_HOVER_ENTER);
                ColorTheme.NAVBUTTON_HOVER_ENTER = c == null ? ColorTheme.NAVBUTTON_HOVER_ENTER : c;
            } else if (e.getSource().equals(navbtn_selected_btn)) {
                Color c = JColorChooser.showDialog(this, "Navigator Button Selected Color", ColorTheme.NAVBUTTON_PRESSED);
                ColorTheme.NAVBUTTON_PRESSED = c == null ? ColorTheme.NAVBUTTON_PRESSED : c;
            } else if (e.getSource().equals(navbtn_disabled_btn)) {
                Color c = JColorChooser.showDialog(this, "Navigator Button Disabled Color", ColorTheme.NAVBUTTON_DISABLED);
                ColorTheme.NAVBUTTON_DISABLED = c == null ? ColorTheme.NAVBUTTON_DISABLED : c;
            } else if (e.getSource().equals(contentpanel_btn)) {
                Color c = JColorChooser.showDialog(this, "Content Panel Color", ColorTheme.CONTENT_DEFAULT);
                ColorTheme.CONTENT_DEFAULT = c == null ? ColorTheme.CONTENT_DEFAULT : c;
            } else if (e.getSource().equals(contenttext_btn)) {
                Color c = JColorChooser.showDialog(this, "Content Font Color", ColorTheme.CONTENT_FONT_COLOR);
                ColorTheme.CONTENT_FONT_COLOR = c == null ? ColorTheme.CONTENT_FONT_COLOR : c;
            }
        }
        repaint();
    }
}
