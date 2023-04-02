
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class AddMember extends JFrame implements ActionListener {
    private JLabel nameLabel, ageLabel, emailLabel, titleLabel, imageLabel, genderLabel, addressLabel, phoneLabel, joinDateLabel, backgroundLabel;
    private JTextField nameField, ageField, emailField, genderField, addressField, phoneField, joinDateField;
    private JButton addButton, cancelButton;
    private HomePage homePage;
    
    public AddMember(HomePage homePage) {
        this.homePage = homePage;
        
        // set window properties
        setTitle("Add Member");
        setSize(500, 470);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // create components
        titleLabel = new JLabel("Add Member");
        titleLabel.setBounds(20, 20, 300, 30);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 18));
        add(titleLabel);
        
        imageLabel = new JLabel(new ImageIcon("image.png"));
        imageLabel.setBounds(250, 120, 100, 100);
        add(imageLabel);
        
        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 80, 80, 20);
        add(nameLabel);
        
        nameField = new JTextField();
        nameField.setBounds(140, 80, 150, 20);
        add(nameField);
        
        ageLabel = new JLabel("Age:");
        ageLabel.setBounds(50, 120, 80, 20);
        add(ageLabel);
        
        ageField = new JTextField();
        ageField.setBounds(140, 120, 150, 20);
        add(ageField);
        
        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 160, 80, 20);
        add(emailLabel);
        
        emailField = new JTextField();
        emailField.setBounds(140, 160, 150, 20);
        add(emailField);

        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(50, 200, 80, 20);
        add(genderLabel);

        genderField = new JTextField();
        genderField.setBounds(140, 200, 150, 20);
        add(genderField);

        addressLabel = new JLabel("Address:");
        addressLabel.setBounds(50, 240, 80, 20);
        addressLabel.setForeground(Color.WHITE);
        add(addressLabel);

        JTextArea addressArea = new JTextArea();
        addressArea.setBounds(140, 240, 150, 60);
        addressArea.setLineWrap(true); // enables line wrapping
        addressArea.setWrapStyleWord(true); // wraps at word boundaries
        addressArea.setBorder(BorderFactory.createLineBorder(Color.GRAY)); // add border
        add(addressArea);

        phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(50, 320, 80, 20);
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(140, 320, 150, 20);
        add(phoneField);

        joinDateLabel = new JLabel("Join Date:");
        joinDateLabel.setBounds(50, 360, 80, 20);
        add(joinDateLabel);

        joinDateField = new JTextField();
        joinDateField.setBounds(140, 360, 150, 20);
        add(joinDateField);
        
        addButton = new JButton("Add");
        addButton.setBounds(100, 390, 80, 25);
        addButton.addActionListener(this);
        add(addButton);
        
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(190, 390, 80, 25);
        cancelButton.addActionListener(this);
        add(cancelButton);

        ImageIcon backgroundImage = new ImageIcon("bgMember.jpg");
        backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        add(backgroundLabel);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            // validate input
            String name = nameField.getText();
            String ageString = ageField.getText();
            String email = emailField.getText();
            int age = 0;
            String gender = genderField.getText();
            String address = addressField.getText();
            String phone = phoneField.getText();
            String joinDateString = joinDateField.getText();
            Date joinDate = null;
            try {
                age = Integer.parseInt(ageString);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid age. Please enter a number.");
                return;
            }
            if (name.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.");
                return;
            }
            if (age <= 0 || age >= 120) {
                JOptionPane.showMessageDialog(this, "Invalid age. Please enter a valid age.");
                return;
            }
            try {
                joinDate = new SimpleDateFormat("dd/MM/yyyy").parse(joinDateString);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Invalid date format. Please enter in dd/MM/yyyy format.");
                return;
            }
            if (gender.isEmpty() || address.isEmpty() || phone.isEmpty() || joinDateString.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.");
                return;
            }
            if (!phone.matches("\\d{10}")) {
                JOptionPane.showMessageDialog(this, "Invalid phone number. Please enter a 10-digit number.");
                return;
            }
            // add member
            // code to add member to database or storage
            JOptionPane.showMessageDialog(this, "Member added successfully.");
            dispose();
        } else if (e.getSource() == cancelButton) {
            dispose();
        }
    }
}
