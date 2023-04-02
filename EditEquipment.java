import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditEquipment extends JFrame implements ActionListener {
    private JLabel titleLabel, equipmentNameLabel, quantityLabel;
    private JTextField equipmentNameTextField, quantityTextField;
    private JButton saveButton, cancelButton;
    private Equipment equipment;

    public EditEquipment(Equipment equipment) {
        super("Edit Equipment");
        this.equipment = equipment;
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create components
        titleLabel = new JLabel("Edit Equipment", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        equipmentNameLabel = new JLabel("Equipment Name:", JLabel.RIGHT);
        quantityLabel = new JLabel("Quantity:", JLabel.RIGHT);
        equipmentNameTextField = new JTextField(equipment.getName());
        quantityTextField = new JTextField(Integer.toString(equipment.getQuantity()));
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");

        // Add components to panels
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.add(equipmentNameLabel);
        inputPanel.add(equipmentNameTextField);
        inputPanel.add(quantityLabel);
        inputPanel.add(quantityTextField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        // Add panels to frame
        add(titleLabel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners
        saveButton.addActionListener(this);
        cancelButton.addActionListener(this);

        // Set frame size and visibility
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            String equipmentName = equipmentNameTextField.getText().trim();
            String quantityString = quantityTextField.getText().trim();

            // Check if the quantity field is empty
            if (quantityString.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a quantity.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int quantity = Integer.parseInt(quantityString);

            try {
                // Edit the equipment
                equipment.setName(equipmentName);
                equipment.setQuantity(quantity);
                EquipmentManager.editEquipment(equipment);

                // Show success message
                JOptionPane.showMessageDialog(this, "Equipment edited successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Close the edit equipment dialog
                dispose();
            } catch (EquipmentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == cancelButton) {
            // Close the edit equipment dialog
            dispose();
        }
    }

}
