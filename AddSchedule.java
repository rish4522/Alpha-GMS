import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddSchedule extends JFrame {
    private JLabel dateLabel, trainerLabel, memberLabel;
    private JTextField dateField, trainerField, memberField;
    private JButton submitButton;

    public AddSchedule() {
        setTitle("Add Schedule");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        dateLabel = new JLabel("Date (dd-MM-yyyy):");
        trainerLabel = new JLabel("Trainer Name:");
        memberLabel = new JLabel("Member Name:");

        dateField = new JTextField();
        trainerField = new JTextField();
        memberField = new JTextField();

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validateInputs();
                    addSchedule();
                    clearInputs();
                    JOptionPane.showMessageDialog(null, "Schedule added successfully!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        add(dateLabel);
        add(dateField);
        add(trainerLabel);
        add(trainerField);
        add(memberLabel);
        add(memberField);
        add(new JLabel());
        add(submitButton);

        setVisible(true);
    }

    private void validateInputs() throws Exception {
        String dateStr = dateField.getText().trim();
        String trainerName = trainerField.getText().trim();
        String memberName = memberField.getText().trim();

        // Check for empty fields
        if (dateStr.isEmpty() || trainerName.isEmpty() || memberName.isEmpty()) {
            throw new Exception("All fields are required.");
        }

        // Validate date format
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        try {
            Date date = sdf.parse(dateStr);
            // Check if date is in the past
            if (date.before(new Date())) {
                throw new Exception("Date must be in the future.");
            }
        } catch (ParseException e) {
            throw new Exception("Invalid date format. Use dd-MM-yyyy.");
        }

        // Check trainer and member names are valid
        if (!isValidName(trainerName)) {
            throw new Exception("Invalid trainer name.");
        }
        if (!isValidName(memberName)) {
            throw new Exception("Invalid member name.");
        }
    }

    private boolean isValidName(String name) {
        // Check for empty or numeric names
        if (name.isEmpty() || name.matches(".*\\d.*")) {
            return false;
        }
        // Check for special characters
        for (char c : name.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }

    private void addSchedule() {
        // TODO: Add schedule to database or file
        System.out.println("Schedule added.");
    }

    private void clearInputs() {
        dateField.setText("");
        trainerField.setText("");
        memberField.setText("");
    }

    public static void main(String[] args) {
        new AddSchedule();
    }
}
