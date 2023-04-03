import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShopWithUs extends JFrame {

    private JLabel productNameLabel, priceLabel, quantityLabel;
    private JTextField productNameTextField, priceTextField, quantityTextField;
    private JButton addButton, viewButton, editButton, deleteButton;
    private ArrayList<String> productsList;

    public ShopWithUs() {
        super("Shop With Us");
        productsList = new ArrayList<>();

        // create and set layout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        add(panel);

        // create UI components
        productNameLabel = new JLabel("Product Name:");
        priceLabel = new JLabel("Price:");
        quantityLabel = new JLabel("Quantity:");
        productNameTextField = new JTextField(20);
        priceTextField = new JTextField(20);
        quantityTextField = new JTextField(20);
        addButton = new JButton("Add Product");
        viewButton = new JButton("View Products");
        editButton = new JButton("Edit Product");
        deleteButton = new JButton("Delete Product");

        // add components to panel
        panel.add(productNameLabel, c);
        c.gridx++;
        panel.add(productNameTextField, c);
        c.gridx = 0;
        c.gridy++;
        panel.add(priceLabel, c);
        c.gridx++;
        panel.add(priceTextField, c);
        c.gridx = 0;
        c.gridy++;
        panel.add(quantityLabel, c);
        c.gridx++;
        panel.add(quantityTextField, c);
        c.gridx = 0;
        c.gridy++;
        panel.add(addButton, c);
        c.gridx++;
        panel.add(viewButton, c);
        c.gridx++;
        panel.add(editButton, c);
        c.gridx++;
        panel.add(deleteButton, c);

        // add action listeners
        addButton.addActionListener(new AddButtonListener());
        viewButton.addActionListener(new ViewButtonListener());
        editButton.addActionListener(new EditButtonListener());
        deleteButton.addActionListener(new DeleteButtonListener());

        // set JFrame properties
        setSize(600, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    // ActionListener for Add Product button
    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String productName = productNameTextField.getText();
            String price = priceTextField.getText();
            String quantity = quantityTextField.getText();

            try {
                // add product to list
                productsList.add(productName + " - Price: " + price + " - Quantity: " + quantity);

                // clear text fields
                productNameTextField.setText("");
                priceTextField.setText("");
                quantityTextField.setText("");

                JOptionPane.showMessageDialog(null, "Product added successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

        // ActionListener for View Products button
        private class ViewButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // create text area and display product list
                    JTextArea productsTextArea = new JTextArea();
                    for (String product : productsList) {
                        productsTextArea.append(product + "\n");
                    }

                    JOptionPane.showMessageDialog(null, new JScrollPane(productsTextArea), "Products on Sale", JOptionPane.PLAIN_MESSAGE);
                } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // ActionListener for Delete Product button
        private class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        try {
            // display input dialog box to get product to delete
            String[] productsArray = productsList.toArray(new String[0]);
            String selectedProduct = (String) JOptionPane.showInputDialog(null, "Select a product to delete:", "Delete Product", JOptionPane.PLAIN_MESSAGE, null, productsArray, productsArray[0]);

            if (selectedProduct != null) {
                // remove selected product from productsList
                productsList.remove(selectedProduct);
                JOptionPane.showMessageDialog(null, "Product deleted successfully!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

// ActionListener for Edit Product button
private class EditButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // display input dialog box to get product to edit
            String[] productsArray = productsList.toArray(new String[0]);
            String selectedProduct = (String) JOptionPane.showInputDialog(
                    null, 
                    "Select a product to edit:", 
                    "Edit Product", 
                    JOptionPane.PLAIN_MESSAGE, 
                    null, 
                    productsArray, 
                    productsArray[0]);

            if (selectedProduct != null) {
                // display input dialog box to get new product details
                String[] selectedProductDetails = selectedProduct.split(" - ");
                String newProductName = (String) JOptionPane.showInputDialog(
                        null, 
                        "Enter new product name:", 
                        "Edit Product", 
                        JOptionPane.PLAIN_MESSAGE, 
                        null, 
                        null, 
                        selectedProductDetails[0]);
                String newPrice = (String) JOptionPane.showInputDialog(
                        null, 
                        "Enter new price:", 
                        "Edit Product", 
                        JOptionPane.PLAIN_MESSAGE, 
                        null, 
                        null, 
                        selectedProductDetails[1].substring(8));
                String newQuantity = (String) JOptionPane.showInputDialog(
                        null, 
                        "Enter new quantity:", 
                        "Edit Product", 
                        JOptionPane.PLAIN_MESSAGE, 
                        null, 
                        null, 
                        selectedProductDetails[2].substring(11));

                // update selected product in productsList
                productsList.set(productsList.indexOf(selectedProduct), newProductName + " - Price: " + newPrice + " - Quantity: " + newQuantity);
                JOptionPane.showMessageDialog(null, "Product edited successfully!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

public static void main(String[] args) {
    new ShopWithUs();
}
}
