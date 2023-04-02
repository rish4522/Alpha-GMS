import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class AddSchedule extends JFrame implements ActionListener {
    private JLabel titleLabel, dateLabel, startTimeLabel, endTimeLabel, trainerLabel, clientLabel;
    private JTextField dateField, startTimeField, endTimeField;
    private JComboBox<String> trainerBox, clientBox;
    private JButton addButton, cancelButton;
    private HomePage homePage;

    public AddSchedule() {
        super("Add Schedule");
        // set window properties
        setTitle("Add Schedule");
        setSize(500, 350);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.homePage = homePage;

        // create components
        titleLabel = new JLabel("ADD SCHEDULE");
        titleLabel.setBounds(170, 20, 150, 30);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 18));
        titleLabel.setForeground(Color.BLACK);
        add(titleLabel);

        dateLabel = new JLabel("Date (MM/dd/yyyy):");
        dateLabel.setBounds(50, 60, 150, 20);
        dateLabel.setForeground(Color.BLACK);
        add(dateLabel);

        dateField = new JTextField();
        dateField.setBounds(200, 60, 150, 20);
        add(dateField);

        startTimeLabel = new JLabel("Start Time (hh:mm):");
        startTimeLabel.setBounds(50, 90, 150, 20);
        startTimeLabel.setForeground(Color.BLACK);
        add(startTimeLabel);

        startTimeField = new JTextField();
        startTimeField.setBounds(200, 90, 150, 20);
        add(startTimeField);

        endTimeLabel = new JLabel("End Time (hh:mm):");
        endTimeLabel.setBounds(50, 120, 150, 20);
        endTimeLabel.setForeground(Color.BLACK);
        add(endTimeLabel);

        endTimeField = new JTextField();
        endTimeField.setBounds(200, 120, 150, 20);
        add(endTimeField);

        trainerLabel = new JLabel("Trainer:");
        trainerLabel.setBounds(50, 150, 80, 20);
        trainerLabel.setForeground(Color.BLACK);
        add(trainerLabel);

        String[] trainers = {"Trainer 1", "Trainer 2", "Trainer 3"};
        trainerBox = new JComboBox<>(trainers);
        trainerBox.setBounds(200, 150, 150, 20);
        add(trainerBox);

        clientLabel = new JLabel("Client:");
        clientLabel.setBounds(50, 180, 80, 20);
        clientLabel.setForeground(Color.BLACK);
        add(clientLabel);

        String[] clients = {"Client 1", "Client 2", "Client 3"};
        clientBox = new JComboBox<>(clients);
        clientBox.setBounds(200, 180, 150, 20);
        add(clientBox);

        addButton = new JButton("Add");
        addButton.setBounds(200, 220, 80, 25);
        addButton.addActionListener(this);
        addButton.setBackground(Color.GREEN);
        add(addButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(290, 220, 80, 25);
        cancelButton.addActionListener(this);
        cancelButton.setBackground(Color.RED);
        add(cancelButton);

        // set background image
        getContentPane().setBackground(Color.WHITE);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String dateStr = dateField.getText();
            String startTimeStr = startTimeField.getText();
            String endTimeStr = endTimeField.getText();
            
            // validate input
            Date date;
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                date = dateFormat.parse(dateStr);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Invalid date format. Please enter a date in the format MM/dd/yyyy.");
                return;
            }
            
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            int startTime, endTime;
            try {
                startTime = (int) (timeFormat.parse(startTimeStr).getTime() / 60000);
                endTime = (int) (timeFormat.parse(endTimeStr).getTime() / 60000);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Invalid time format. Please enter a time in the format HH:mm.");
                return;
            }
    
            if (startTime < 0 || startTime >= 24 || endTime < 0 || endTime >= 24 || startTime >= endTime) {
                JOptionPane.showMessageDialog(this, "Invalid time range. Please enter a valid range for the start and end times.");
                return;
            }
    
            // create new schedule object and add to home page
            Schedule newSchedule = new Schedule();
            homePage.addSchedule(newSchedule);
    
            // display success message and close window
            JOptionPane.showMessageDialog(this, "Schedule added successfully.");
            dispose();
        } else if (e.getSource() == cancelButton) {
            // close window without saving
            dispose();
        }
    }
}   