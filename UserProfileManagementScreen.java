import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserProfileManagementScreen extends JFrame {
    
    public UserProfileManagementScreen() {
        // Set the title of the window
        setTitle("User Profile Management");
        
        // Set the size of the window
        setSize(400, 300);
        
        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2)); // 6 rows, 2 columns
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding
        
        // Create and add components to the panel
        JLabel nameLabel = new JLabel("Full Name:");
        JTextField nameField = new JTextField();
        panel.add(nameLabel);
        panel.add(nameField);
        
        JLabel emailLabel = new JLabel("Email Address:");
        JTextField emailField = new JTextField();
        panel.add(emailLabel);
        panel.add(emailField);
        
        JLabel phoneLabel = new JLabel("Phone Number:");
        JTextField phoneField = new JTextField();
        panel.add(phoneLabel);
        panel.add(phoneField);
        
        JLabel currentPasswordLabel = new JLabel("Current Password:");
        JPasswordField currentPasswordField = new JPasswordField();
        panel.add(currentPasswordLabel);
        panel.add(currentPasswordField);
        
        JLabel newPasswordLabel = new JLabel("New Password:");
        JPasswordField newPasswordField = new JPasswordField();
        panel.add(newPasswordLabel);
        panel.add(newPasswordField);
        
        // Buttons for update and cancel
        JButton updateButton = new JButton("Update Profile");
        JButton cancelButton = new JButton("Cancel");
        
        // Action listener for the update button
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String phone = phoneField.getText();
                String currentPassword = new String(currentPasswordField.getPassword());
                String newPassword = new String(newPasswordField.getPassword());
                
                // Validate input fields
                if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields.");
                } else {
                    // Handle profile update logic here (e.g., save to database)
                    JOptionPane.showMessageDialog(null, "Profile updated successfully!");
                    dispose(); // Close the profile management screen
                }
            }
        });
        
        // Action listener for the cancel button
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the profile management screen
            }
        });
        
        // Add buttons to the panel
        panel.add(updateButton);
        panel.add(cancelButton);
        
        // Add the panel to the frame
        add(panel);
        
        // Set the frame to be visible
        setVisible(true);
    }
    
    public static void main(String[] args) {
        // Create an instance of the User Profile Management Screen
        new UserProfileManagementScreen();
    }
}
