import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewMember extends JFrame implements ActionListener {
    private JLabel titleLabel, memberIdLabel, nameLabel, dobLabel;
    private JTextField memberIdField, nameField, dobField;
    private JRadioButton allMembersRadioButton;
    private JButton submitButton;
    
    public ViewMember() {
        // set window properties
        setTitle("View Member");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // create components
        titleLabel = new JLabel("View Member");
        titleLabel.setBounds(20, 20, 200, 30);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 18));
        add(titleLabel);
        
        memberIdLabel = new JLabel("Member ID:");
        memberIdLabel.setBounds(50, 70, 80, 20);
        add(memberIdLabel);
        
        memberIdField = new JTextField();
        memberIdField.setBounds(140, 70, 150, 20);
        add(memberIdField);
        
        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 100, 80, 20);
        add(nameLabel);
        
        nameField = new JTextField();
        nameField.setBounds(140, 100, 150, 20);
        add(nameField);
        
        dobLabel = new JLabel("Date of Birth (dd/mm/yyyy):");
        dobLabel.setBounds(50, 130, 150, 20);
        add(dobLabel);
        
        dobField = new JTextField();
        dobField.setBounds(210, 130, 80, 20);
        add(dobField);
        
        allMembersRadioButton = new JRadioButton("View All Members");
        allMembersRadioButton.setBounds(140, 220, 150, 20);
        add(allMembersRadioButton);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(allMembersRadioButton);
        
        submitButton = new JButton("Submit");
        submitButton.setBounds(140, 260, 80, 25);
        submitButton.addActionListener(this);
        add(submitButton);
    }
    
    public void actionPerformed(ActionEvent e) {
        try {
            if (allMembersRadioButton.isSelected()) {
                // display all members
                // replace this with your code to retrieve all members
                JOptionPane.showMessageDialog(this, "Retrieving all members...");
            } else {
            // display selected member
            String memberId = memberIdField.getText();
            // replace this with your code to retrieve member details
            JOptionPane.showMessageDialog(this, "Retrieving details for member with ID: " + memberId);
            }
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
            }
        }
    
    
