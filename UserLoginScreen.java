import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class UserLoginScreen extends JFrame {
    
    public UserLoginScreen() {
        // Set the title of the window
        setTitle("User Login");
        
        // Set the size of the window
        setSize(400, 300);
        
        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Vertical layout
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding
        
        // Create and add components to the panel
        JLabel emailLabel = new JLabel("Email Address:");
        JTextField emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(200, 25)); // Set preferred size for the email field
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space
        
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200, 25)); // Set preferred size for the password field
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Add space
        
        // Buttons for login and navigation
        JButton loginButton = new JButton("Login");
        JButton forgotPasswordButton = new JButton("Forgot Password");
        JButton registerButton = new JButton("Register");
        
        // Action listener for the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                
                if (email.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter email and password.");
                } else if (!isValidEmail(email)) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid email address.");
                } else {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    new BookCatalogScreen(); // Open Book Catalog Screen
                    dispose(); // Close the login screen
                }
            }
        });
        
        // Action listener for the forgot password button
        forgotPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = JOptionPane.showInputDialog("Enter your email address:");
                if (email != null && !email.isEmpty()) {
                    // Here you would typically send a password reset link to the email
                    JOptionPane.showMessageDialog(null, "A password reset link has been sent to " + email);
                }
            }
        });
        
        // Action listener for the register button
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserRegistrationScreen(); // Open User Registration Screen
                dispose(); // Close the login screen
            }
        });
        
        // Add buttons to the panel
        panel.add(loginButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space
        panel.add(forgotPasswordButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space
        panel.add(registerButton);
        
        // Add the panel to the frame
        add(panel);
        
        // Set the frame to be visible
        setVisible(true);
    }
    
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
    
    public static void main(String[] args) {
        new UserLoginScreen();
    }
}
