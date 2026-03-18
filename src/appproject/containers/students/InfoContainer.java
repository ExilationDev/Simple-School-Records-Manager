package appproject.containers.students;

import appproject.lib.ClassData;
import appproject.lib.ClassRecordTableModel;
import appproject.lib.WindowContainer;
import appproject.lib.components.ColorTheme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoContainer extends WindowContainer implements ActionListener {
    // This is where you build your GUI code outside the AppWindow and WindowContainer framework.

    JLabel class_label = new JLabel("null");
    JLabel info_label = new JLabel("null");
    JTextArea description_label = new JTextArea();

    // This constructor is an equivalent method to the main() method of AppProject.
    public InfoContainer(JTable table) {
        setLayout(new BorderLayout());
        add(new JPanel(), BorderLayout.WEST);
        add(getContent(), BorderLayout.CENTER);

        // Put content GUI code here
        // Make sure you use getContent() when you add components!
        ClassData selectedRow = ((ClassRecordTableModel)table.getModel()).getSelectedRecord(table.getSelectedRow());

        class_label.setText("Code "+ selectedRow.code() + " as " + selectedRow.class_title());
        class_label.setBounds(20, 20, 400, 20);
        class_label.setFont(new Font(null, Font.PLAIN, 20));

        info_label.setText(selectedRow.class_name() + " for " + selectedRow.program());
        info_label.setBounds(20, 40, 400, 20);

        description_label.setText(selectedRow.description());
        description_label.setLineWrap(true);
        description_label.setWrapStyleWord(true);
        description_label.setEditable(false);

        JScrollPane scroll_pane = new JScrollPane(description_label);
        scroll_pane.setBounds(35, 65, 400, 280);

        getContent().add(class_label);
        getContent().add(info_label);
        getContent().add(scroll_pane);

        setVisible(true);
    }

    // repaint function. Put setForegrounds of your JComponent here
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        class_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
        description_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
    }

    // Put any functionalities here acquired from doing an action event from any action listener in this container.
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
