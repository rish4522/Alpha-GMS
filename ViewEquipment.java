import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.TableModel;

public class ViewEquipment extends JFrame implements ActionListener {
    private JTable equipmentTable;
    private JButton addButton, editButton, deleteButton, closeButton;
    private DefaultTableModel tableModel;
    private Object[] tableHeader = {"Equipment Name", "Quantity"};

    public ViewEquipment() {
        super("View Equipment");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create components
        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        closeButton = new JButton("Close");
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(closeButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Create table
        tableModel = new DefaultTableModel(tableHeader, 0);
        equipmentTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(equipmentTable);
        add(scrollPane, BorderLayout.CENTER);

        // Load data
        loadData();

        // Add action listeners
        addButton.addActionListener(this);
        editButton.addActionListener(this);
        deleteButton.addActionListener(this);
        closeButton.addActionListener(this);

        

        // Set frame size and visibility
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadData() {
        // Get the equipment list from the manager
        ArrayList<Equipment> equipmentList = EquipmentManager.getEquipmentList();

        // Clear the table model
        tableModel.setRowCount(0);

        // Add the equipment to the table model
        for (Equipment equipment : equipmentList) {
            Object[] row = {equipment.getName(), equipment.getQuantity()};
            tableModel.addRow(row);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            new AddEquipment();
        } else if (e.getSource() == editButton) {
            // Get the selected row
            int selectedRow = equipmentTable.getSelectedRow();
            
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select an equipment to edit.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Get the equipment to edit
            Equipment equipment = new Equipment((String) tableModel.getValueAt(selectedRow, 0), (int) tableModel.getValueAt(selectedRow, 1));
            
            // Show the edit equipment dialog
            new EditEquipment(equipment);
        } else if (e.getSource() == deleteButton) {
            // Get the selected row
            int selectedRow = equipmentTable.getSelectedRow();
            
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select an equipment to delete.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Get the equipment to delete
            Equipment equipment = new Equipment((String) tableModel.getValueAt(selectedRow, 0), (int) tableModel.getValueAt(selectedRow, 1));
            
            // Confirm the deletion
            int confirmation = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the equipment?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            
            if (confirmation == JOptionPane.YES_OPTION) {
                try {
                    // Delete the equipment
                    EquipmentManager.deleteEquipment(equipment);
                    
                    // Show success message
                    JOptionPane.showMessageDialog(this, "Equipment deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (EquipmentException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if (e.getSource() == closeButton) {
                dispose(); // close the window
            } 
        }
    }
}    
