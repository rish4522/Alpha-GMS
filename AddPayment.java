import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddPayment extends JFrame {

    private JLabel nameLabel, cardNumberLabel, expirationDateLabel, cvvLabel;
    private JTextField nameTextField, cardNumberTextField, expirationDateTextField, cvvTextField;
    private JButton addButton, viewButton;
    private ArrayList<String> paymentList;
    private HomePage homePage;

    public AddPayment() {
        super("Add Payment");

        paymentList = new ArrayList<>();

        // create and set layout
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        add(panel);

        // create UI components
        nameLabel = new JLabel("Name on Card:");
        cardNumberLabel = new JLabel("Card Number:");
        expirationDateLabel = new JLabel("Expiration Date:");
        cvvLabel = new JLabel("CVV:");
        nameTextField = new JTextField(20);
        cardNumberTextField = new JTextField(20);
        expirationDateTextField = new JTextField(20);
        cvvTextField = new JTextField(20);
        addButton = new JButton("Add Payment");
        viewButton = new JButton("View Payments");

        // add components to panel
        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(cardNumberLabel);
        panel.add(cardNumberTextField);
        panel.add(expirationDateLabel);
        panel.add(expirationDateTextField);
        panel.add(cvvLabel);
        panel.add(cvvTextField);
        panel.add(addButton);
        panel.add(viewButton);

        // add action listeners
        addButton.addActionListener(new AddButtonListener());
        viewButton.addActionListener(new ViewButtonListener());

        // set JFrame properties
        setSize(500, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    // ActionListener for Add Payment button
    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameTextField.getText();
            String cardNumber = cardNumberTextField.getText();
            String expirationDate = expirationDateTextField.getText();
            String cvv = cvvTextField.getText();

            try {
                // add payment to list
                paymentList.add("Name on Card: " + name + " - Card Number: " + cardNumber + " - Expiration Date: " + expirationDate + " - CVV: " + cvv);

                // clear text fields
                nameTextField.setText("");
                cardNumberTextField.setText("");
                expirationDateTextField.setText("");
                cvvTextField.setText("");

                JOptionPane.showMessageDialog(null, "Payment added successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // ActionListener for View Payments button
    private class ViewButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // create text area and display payment list
                JTextArea paymentsTextArea = new JTextArea();
                for (String payment : paymentList) {
                    paymentsTextArea.append(payment + "\n");
                }

                JOptionPane.showMessageDialog(null, new JScrollPane(paymentsTextArea), "Your Payments", JOptionPane.PLAIN_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
