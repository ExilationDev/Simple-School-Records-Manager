package appproject.containers;

import appproject.lib.ClassesData;
import appproject.lib.WindowContainer;
import appproject.lib.components.ColorTheme;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClassesContainer extends WindowContainer implements ActionListener {
    // This is where you build your GUI code outside the AppWindow and WindowContainer framework.
    JPanel navigator;
    JPanel content;

    JLabel classes_label = new JLabel("Classes");

    // Model Data Types
    // int code, String class, String name, Programs program, double units, *reserved for buttons about full description*
    public static TableModel table_model = new DefaultTableModel(new Object[][]
            {
                {4408, "CCE 107", "Intermediate Programming", ClassesData.Programs.BSCS, 3.0}
            },
            new String[]{"Code", "Class", "Name", "Program", "Units"}
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    public static JTable classes_table = new JTable(table_model);

    // This constructor is an equivalent method to the main() method of AppProject.
    public ClassesContainer() {
        super();
        setLayout(new BorderLayout());

        add(navigator = setUpNavigator(), BorderLayout.WEST);
        add(content = setUpContent(), BorderLayout.CENTER);

        // Put content GUI code here
        // Make sure you use the content variable whenever you add components!
        classes_label.setBounds(20, 20, 100, 20);
        classes_label.setFont(new Font(null, Font.PLAIN, 20));
        content.add(classes_label);

        JScrollPane table_scroll_pane = new JScrollPane(classes_table);
        table_scroll_pane.setBounds(35, 50, 600, 300);
        classes_table.setColumnSelectionAllowed(false);
        classes_table.setRowSelectionAllowed(true);
        classes_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        classes_table.getColumn("Code").setPreferredWidth(30);
        classes_table.getColumn("Class").setPreferredWidth(60);
        classes_table.getColumn("Name").setPreferredWidth(300);
        classes_table.getColumn("Program").setPreferredWidth(50);
        classes_table.getColumn("Units").setPreferredWidth(25);
        content.add(table_scroll_pane);

        setVisible(true);
    }

    // repaint function. Put setForegrounds of your JComponent here
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        classes_label.setForeground(ColorTheme.CONTENT_FONT_COLOR);
    }

    // Put any functionalities here acquired from doing an action event from any action listener in this container.
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
