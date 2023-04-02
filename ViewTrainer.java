import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewTrainer extends JFrame implements ActionListener {
    private JLabel titleLabel, idLabel, nameLabel, dobLabel;
    private JTextField idField, nameField, dobField, ageField;
    private JButton searchButton, viewAllButton, cancelButton;
    private HomePage homePage;

    public ViewTrainer() {
        // set window properties
        setTitle("View Trainer");
        setSize(500, 250);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // create components
        titleLabel = new JLabel("View Trainer");
        titleLabel.setBounds(20, 20, 300, 30);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 18));
        add(titleLabel);

        idLabel = new JLabel("Trainer ID:");
        idLabel.setBounds(50, 50, 80, 20);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(140, 50, 150, 20);
        add(idField);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 80, 80, 20);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(140, 80, 150, 20);
        add(nameField);

        dobLabel = new JLabel("DOB:");
        dobLabel.setBounds(50, 110, 80, 20);
        add(dobLabel);

        dobField = new JTextField();
        dobField.setBounds(140, 110, 150, 20);
        add(dobField);

        searchButton = new JButton("Search");
        searchButton.setBounds(140, 200, 80, 25);
        searchButton.addActionListener(this);
        add(searchButton);

        viewAllButton = new JButton("View All");
        viewAllButton.setBounds(240, 200, 80, 25);
        viewAllButton.addActionListener(this);
        add(viewAllButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(340, 200, 80, 25);
        cancelButton.addActionListener(this);
        add(cancelButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
            String id = idField.getText();
            String name = nameField.getText();
            String dob = dobField.getText();
    
            if (id.isEmpty() && name.isEmpty() && dob.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter at least one search criteria.");
                return;
            }
            if (e.getSource() == viewAllButton) {
                // TODO: retrieve all trainers from the database and display them
                JOptionPane.showMessageDialog(this, "Displaying all trainers.");
            }

            if (e.getSource() == cancelButton) {
                this.dispose(); // close the window
            }            
    
            // TODO: search for trainer in database and display details
        }
    }
}    
