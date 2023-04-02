import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEquipment extends JFrame implements ActionListener {
    private JLabel titleLabel, equipmentNameLabel, quantityLabel;
    private JTextField equipmentNameTextField, quantityTextField;
    private JButton addButton, cancelButton;

    public AddEquipment() {
        super("Add Equipment");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create components
        titleLabel = new JLabel("Add Equipment", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        equipmentNameLabel = new JLabel("Equipment Name:", JLabel.RIGHT);
        quantityLabel = new JLabel("Quantity:", JLabel.RIGHT);
        equipmentNameTextField = new JTextField();
        quantityTextField = new JTextField();
        addButton = new JButton("Add");
        cancelButton = new JButton("Cancel");

        // Add components to panels
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.add(equipmentNameLabel);
        inputPanel.add(equipmentNameTextField);
        inputPanel.add(quantityLabel);
        inputPanel.add(quantityTextField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(cancelButton);

        // Add panels to frame
        add(titleLabel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners
        addButton.addActionListener(this);
        cancelButton.addActionListener(this);

        // Set frame size and visibility
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String equipmentName = equipmentNameTextField.getText().trim();
            int quantity = Integer.parseInt(quantityTextField.getText().trim());

            try {
                // Add the equipment
                EquipmentManager.addEquipment(new Equipment(equipmentName, quantity));

                // Show success message
                JOptionPane.showMessageDialog(this, "Equipment added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Clear the input fields
                equipmentNameTextField.setText("");
                quantityTextField.setText("");
            } catch (EquipmentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == cancelButton) {
            dispose();
            new HomePage();
        }
    }
}
