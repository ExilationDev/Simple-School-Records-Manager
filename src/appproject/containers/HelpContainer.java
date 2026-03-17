package appproject.containers;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import appproject.lib.WindowContainer;
/**
 * 
 */
public class HelpContainer extends WindowContainer implements ActionListener {
// This is where you build your GUI code outside the AppWindow and WindowContainer framework.
    JPanel content;
// This constructor is an equivalent method to the main() method of AppProject.
   
    public HelpContainer() {
        super();
        setLayout(new BorderLayout());
        setSize(1000, 700);
        add(content = setUpContent(), BorderLayout.CENTER);
        
        setVisible(true);
    }

    // Help UI
    private JPanel setUpContent() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel title = new JLabel("School Record Manager - Help", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));

        JTextArea helpText = new JTextArea();
        helpText.setEditable(false);
        helpText.setLineWrap(true);
        helpText.setWrapStyleWord(true);

        helpText.setText(
            "Welcome to the School Record Manager Help Section.\n\n" +
            "How to use the system:\n" +
            "1. Add Student - Enter student information and save.\n" +
            "2. View Records - Displays the list of students.\n" +
            "3. Edit Record - Select a student and update their details.\n" +
            "4. Delete Record - Remove a student record from the system.\n\n" +
            "Tips:\n" +
            "- Make sure all required fields are filled.\n" +
            "- Double check information before saving.\n" +
            "- Use the menu to navigate between sections."
        );

        // Change font
        helpText.setFont(new Font("Roboto", Font.PLAIN, 15));
       
        JScrollPane scroll = new JScrollPane(helpText);

        panel.add(title, BorderLayout.NORTH);
        panel.add(scroll, BorderLayout.CENTER);

        return panel;
    }
// Put any functionalities here acquired from doing an action event from any action listener in this container.
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}