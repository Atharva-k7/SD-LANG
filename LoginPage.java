package awt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame implements ActionListener {
    JTextField userField;
    JPasswordField passField;
    JButton loginButton;
    JLabel messageLabel;

    public LoginPage() {
        // Frame settings
        setTitle("Login Page");
        setSize(350, 200);
        setLayout(new GridLayout(4, 3));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Components
        JLabel userLabel = new JLabel("Username:");
        userField = new JTextField();

        JLabel passLabel = new JLabel("Password:");
        passField = new JPasswordField();

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);

        messageLabel = new JLabel("");

        // Add components to frame
        add(userLabel);
        add(userField);
        add(passLabel);
        add(passField);
        add(new JLabel()); // empty cell
        add(loginButton);
        add(messageLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String username = userField.getText();
        String password = new String(passField.getPassword());

        // Simple validation
        if (username.equals("admin") && password.equals("1234")) {
            messageLabel.setText("Login successful!");
        } else {
            messageLabel.setText("Invalid credentials.");
        }
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}