import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewEquipment extends JFrame implements ActionListener {
    private JLabel titleLabel, searchLabel;
    private JTextField searchTextField;
    private JTextArea equipmentTextArea;
    private JButton searchButton, viewButton, editButton, deleteButton, backButton;

    public ViewEquipment() {
        super("View Equipment");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create components
        titleLabel = new JLabel("View Equipment", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        searchLabel = new JLabel("Search:", JLabel.RIGHT);
        searchTextField = new JTextField();
        equipmentTextArea = new JTextArea(20, 50);
        searchButton = new JButton("Search");
        viewButton = new JButton("View");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        backButton = new JButton("Back");

        // Add components to panels
        JPanel inputPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.add(searchLabel);
        inputPanel.add(searchTextField);
        inputPanel.add(searchButton);

        JPanel equipmentPanel = new JPanel(new BorderLayout());
        equipmentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        equipmentPanel.add(new JScrollPane(equipmentTextArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(viewButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(backButton);

        // Add panels to frame
        add(titleLabel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(equipmentPanel, BorderLayout.SOUTH);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners
        searchButton.addActionListener(this);
        viewButton.addActionListener(this);
        editButton.addActionListener(this);
        deleteButton.addActionListener(this);
        backButton.addActionListener(this);

        // Set frame size and visibility
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewButton) {
            String equipmentId = searchTextField.getText().trim();
    
            try {
                // Get the equipment based on equipment ID
                Equipment equipment = EquipmentManager.getEquipmentById(equipmentId);
    
                // Display the equipment
                if (equipment != null) {
                    // Create and display the dialog box with the equipment details
                    EquipmentDialogBox dialogBox = new EquipmentDialogBox(this, equipment);
                    dialogBox.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Equipment with ID " + equipmentId + " not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (EquipmentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == editButton) {
            String equipmentId = searchTextField.getText().trim();
    
            try {
                // Get the equipment based on equipment ID
                Equipment equipment = EquipmentManager.getEquipmentById(equipmentId);
    
                // Display the equipment for editing
                if (equipment != null) {
                    // Create and display the dialog box with the equipment details for editing
                    EquipmentDialogBox dialogBox = new EquipmentDialogBox(this, equipment, true);
                    dialogBox.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Equipment with ID " + equipmentId + " not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (EquipmentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == deleteButton) {
            String equipmentId = searchTextField.getText().trim();
    
            try {
                // Delete the equipment based on equipment ID
                boolean success = EquipmentManager.deleteEquipment(equipmentId);
    
                if (success) {
                    JOptionPane.showMessageDialog(this, "Equipment deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Equipment with ID " + equipmentId + " not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (EquipmentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == backButton) {
            dispose();
            new HomePage();
        }
    }
}    