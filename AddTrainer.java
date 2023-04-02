

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class AddTrainer extends JFrame implements ActionListener {
    private JLabel titleLabel, nameLabel, ageLabel, genderLabel, addressLabel, phoneLabel, emailLabel, hireDateLabel, specializationLabel, backgroundLabel;
    private JTextField nameField, ageField, addressField, phoneField, emailField, hireDateField, specializationField;
    private JComboBox<String> genderBox;
    private JButton addButton, cancelButton;
    private HomePage homePage;

    public AddTrainer() {
        // set window properties
        setTitle("Add Trainer");
        setSize(500, 450);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // create components
        titleLabel = new JLabel("ADD TRAINER");
        titleLabel.setBounds(100, 20, 300, 30);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        add(titleLabel);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 50, 80, 20);
        nameLabel.setForeground(Color.WHITE);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(140, 50, 150, 20);
        add(nameField);

        ageLabel = new JLabel("Age:");
        ageLabel.setBounds(50, 80, 80, 20);
        ageLabel.setForeground(Color.WHITE);
        add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(140, 80, 150, 20);
        add(ageField);

        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(50, 110, 80, 20);
        genderLabel.setForeground(Color.WHITE);
        add(genderLabel);

        String[] genders = {"Male", "Female", "Other"};
        genderBox = new JComboBox<>(genders);
        genderBox.setBounds(140, 110, 150, 20);
        add(genderBox);

        addressLabel = new JLabel("Address:");
        addressLabel.setBounds(50, 140, 80, 20);
        addressLabel.setForeground(Color.WHITE);
        add(addressLabel);

        JTextArea addressArea = new JTextArea();
        addressArea.setBounds(140, 140, 150, 60);
        addressArea.setLineWrap(true); // enables line wrapping
        addressArea.setWrapStyleWord(true); // wraps at word boundaries
        addressArea.setBorder(BorderFactory.createLineBorder(Color.GRAY)); // add border
        add(addressArea);

        phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setBounds(50, 210, 100, 20);
        phoneLabel.setForeground(Color.WHITE);
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(140, 210, 150, 20);
        add(phoneField);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 240, 80, 20);
        emailLabel.setForeground(Color.WHITE);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(140, 240, 150, 20);
        add(emailField);

        hireDateLabel = new JLabel("Hire Date:");
        hireDateLabel.setBounds(50, 270, 80, 20);
        hireDateLabel.setForeground(Color.WHITE);
        add(hireDateLabel);

        hireDateField = new JTextField();
        hireDateField.setBounds(140, 270, 150, 20);
        add(hireDateField);

        specializationLabel = new JLabel("Specialization:");
        specializationLabel.setBounds(50, 300, 100, 20);
        specializationLabel.setForeground(Color.WHITE);
        add(specializationLabel);

        specializationField = new JTextField();
        specializationField.setBounds(140, 300, 150, 20);
        add(specializationField);

        addButton = new JButton("Add");
        addButton.setBounds(140, 330, 80, 25);
        addButton.addActionListener(this);
        addButton.setBackground(Color.GREEN);
        add(addButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(230, 330, 80, 25);
        cancelButton.addActionListener(this);
        cancelButton.setBackground(Color.RED);
        add(cancelButton);

        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\risha\\OneDrive\\Desktop\\GMS\\bgTrainer.png");
        backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        add(backgroundLabel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
        String name = nameField.getText();
        String ageStr = ageField.getText();
        String gender = (String)genderBox.getSelectedItem();
        int age = 0;

        try {
            age = Integer.parseInt(ageStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid age format. Please enter a number.");
            return;
        }

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name cannot be empty.");
            return;
        }

        if (addressField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Address cannot be empty.");
            return;
        }

        String phoneRegex = "^\\d{10}$";
        if (!phoneField.getText().matches(phoneRegex)) {
            JOptionPane.showMessageDialog(this, "Invalid phone number format. Please enter a 10-digit number.");
            return;
        }
        
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (!emailField.getText().matches(emailRegex)) {
        JOptionPane.showMessageDialog(this, "Invalid email format. Please enter a valid email address.");
        return;
        }

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);
            Date hireDate = dateFormat.parse(hireDateField.getText());
            if (hireDate.after(new Date())) {
                JOptionPane.showMessageDialog(this, "Hire date cannot be in the future.");
                return;
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Invalid hire date format. Please enter a date in the format yyyy-MM-dd.");
            return;
        }

        if (age < 18 || age > 60) {
            JOptionPane.showMessageDialog(this, "Age should be between 18 and 60.");
            return;
        }

        if (gender == null || gender.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a gender.");
            return;
        }

        if (specializationField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Specialization cannot be empty.");
            return;
        }

        // TODO: add trainer to database or display success message
        JOptionPane.showMessageDialog(this, "Trainer added successfully!");
        dispose();
    }else if (e.getSource() == cancelButton) {
        dispose();
    }
}
}