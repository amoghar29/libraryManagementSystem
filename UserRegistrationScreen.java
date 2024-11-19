import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class UserRegistrationScreen extends JFrame {
    
    public UserRegistrationScreen() {
        // Set the title of the window
        setTitle("User Registration");
        
        // Set the size of the window
        setSize(400, 400);
        
        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Vertical layout
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding
        
        // Create and add components to the panel
        JLabel nameLabel = new JLabel("Full Name:");
        JTextField nameField = new JTextField();
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space
        
        JLabel emailLabel = new JLabel("Email Address:");
        JTextField emailField = new JTextField();
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space
        
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space
        
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        JPasswordField confirmPasswordField = new JPasswordField();
        panel.add(confirmPasswordLabel);
        panel.add(confirmPasswordField);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space
        
        // Radio buttons for user type
        JLabel userTypeLabel = new JLabel("User Type:");
        JPanel userTypePanel = new JPanel();
        JRadioButton studentRadio = new JRadioButton("Student");
        JRadioButton facultyRadio = new JRadioButton("Faculty");
        JRadioButton guestRadio = new JRadioButton("Guest");
        
        // Group the radio buttons
        ButtonGroup userTypeGroup = new ButtonGroup();
        userTypeGroup.add(studentRadio);
        userTypeGroup.add(facultyRadio);
        userTypeGroup.add(guestRadio);
        
        userTypePanel.add(studentRadio);
        userTypePanel.add(facultyRadio);
        userTypePanel.add(guestRadio);
        
        panel.add(userTypeLabel);
        panel.add(userTypePanel);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space
        
        // Checkbox for terms and conditions
        JCheckBox termsCheckBox = new JCheckBox("I agree to the Terms and Conditions");
        panel.add(termsCheckBox);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space
        
        // Buttons for submit and reset
        JButton submitButton = new JButton("Submit");
        JButton resetButton = new JButton("Reset");
        
        // Action listener for the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());
                
                if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields.");
                } else if (!isValidEmail(email)) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid email address.");
                } else if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(null, "Passwords do not match.");
                } else {
                    JOptionPane.showMessageDialog(null, "Registration Successful!");
                    dispose(); // Close the registration screen
                }
            }
        });
        
        // Action listener for the reset button
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                emailField.setText("");
                passwordField.setText("");
                confirmPasswordField.setText("");
                userTypeGroup.clearSelection();
                termsCheckBox.setSelected(false);
            }
        });
        
        // Add buttons to the panel
        panel.add(submitButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space
        panel.add(resetButton);
        
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
        new UserRegistrationScreen();
    }
}
