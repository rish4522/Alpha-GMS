

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginBox extends JFrame implements ActionListener {
    private JLabel userLabel, passLabel, imageLabel, titleLabel;
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;
    
    public LoginBox() {
        // set window properties
        setTitle("Alpha Gym Management System");
        setSize(410, 250);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // create components
        titleLabel = new JLabel("WELCOME TO ALPHA");
        titleLabel.setBounds(80, 20, 300, 30);
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        add(titleLabel);
        
        imageLabel = new JLabel(new ImageIcon("C:\\Users\\risha\\OneDrive\\Desktop\\GMS\\pic1.png"));
        imageLabel.setBounds(268, 106, 130, 130);
        add(imageLabel);
        
        userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 80, 80, 20);
        add(userLabel);
        
        userField = new JTextField();
        userField.setBounds(140, 80, 150, 20);
        add(userField);
        
        passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 120, 80, 20);
        add(passLabel);
        
        passField = new JPasswordField();
        passField.setBounds(140, 120, 150, 20);
        add(passField);
        
        loginButton = new JButton("Login");
        loginButton.setBounds(140, 160, 80, 25);
        loginButton.addActionListener(this);
        add(loginButton);

    }
    
    public void actionPerformed(ActionEvent e) {
        String user = userField.getText();
        String pass = new String(passField.getPassword());
        if (user.equals("admin") && pass.equals("admin123")) {
            JOptionPane.showMessageDialog(this, "Login successful!");
            HomePage homepage = new HomePage();
            homepage.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.");
        }
    }
    
    public static void main(String[] args) {
        LoginBox loginBox = new LoginBox();
        loginBox.setVisible(true);
    }
}
