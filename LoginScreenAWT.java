package awt;

import java.awt.*;
import java.awt.event.*;

class InvalidLoginException extends Exception {
    public InvalidLoginException(String message) {
        super(message);
    }
}

public class LoginScreenAWT extends Frame implements ActionListener {
    Label lblUser, lblPass, lblMessage;
    TextField txtUser, txtPass;
    Button btnLogin, btnClear;
    int attempts = 0;

    public LoginScreenAWT() {
        setLayout(null);
        setTitle("Login Screen");
        setSize(400, 250);
        setVisible(true);

        lblUser = new Label("Username:");
        lblUser.setBounds(50, 50, 80, 30);
        add(lblUser);

        txtUser = new TextField();
        txtUser.setBounds(150, 50, 150, 30);
        add(txtUser);

        lblPass = new Label("Password:");
        lblPass.setBounds(50, 100, 80, 30);
        add(lblPass);

        txtPass = new TextField();
        txtPass.setEchoChar('*');
        txtPass.setBounds(150, 100, 150, 30);
        add(txtPass);

        btnLogin = new Button("Login");
        btnLogin.setBounds(80, 160, 80, 30);
        btnLogin.addActionListener(this);
        add(btnLogin);

        btnClear = new Button("Clear");
        btnClear.setBounds(200, 160, 80, 30);
        btnClear.addActionListener(this);
        add(btnClear);

        lblMessage = new Label("");
        lblMessage.setBounds(50, 200, 300, 30);
        add(lblMessage);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnLogin) {
            String username = txtUser.getText();
            String password = txtPass.getText();

            try {
                if (!username.equals(password)) {
                    attempts++;
                    throw new InvalidLoginException("Username and Password must be the same.");
                } else {
                    lblMessage.setText("Login Successful!");
                    lblMessage.setForeground(Color.GREEN);
                }
            } catch (InvalidLoginException e) {
                if (attempts >= 3) {
                    lblMessage.setText("Maximum login attempts exceeded.");
                    btnLogin.setEnabled(false);
                } else {
                    lblMessage.setText(e.getMessage() + " Attempts left: " + (3 - attempts));
                    lblMessage.setForeground(Color.RED);
                }
            }
        } else if (ae.getSource() == btnClear) {
            txtUser.setText("");
            txtPass.setText("");
            lblMessage.setText("");
        }
    }

    public static void main(String[] args) {
        new LoginScreenAWT();
    }
}
