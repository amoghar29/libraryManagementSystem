import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookBorrowingScreen extends JFrame {
    
    public BookBorrowingScreen() {
        // Set the title of the window
        setTitle("Book Borrowing");
        
        // Set the size of the window
        setSize(400, 300);
        
        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Vertical layout
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding
        
        // Create and add components to the panel
        JLabel bookLabel = new JLabel("Select Book:");
        JComboBox<String> bookComboBox = new JComboBox<>(new String[] {
            "The Great Gatsby", 
            "To Kill a Mockingbird", 
            "1984" // Add more book options as needed
        });
        panel.add(bookLabel);
        panel.add(bookComboBox);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space
        
        JLabel borrowerLabel = new JLabel("Borrower Name:");
        JTextField borrowerField = new JTextField();
        panel.add(borrowerLabel);
        panel.add(borrowerField);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space
        
        // Buttons for submit and cancel
        JButton submitButton = new JButton("Submit");
        JButton cancelButton = new JButton("Cancel");
        
        // Action listener for the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String borrowerName = borrowerField.getText();
                String selectedBook = (String) bookComboBox.getSelectedItem();
                
                if (borrowerName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter your name.");
                } else {
                    JOptionPane.showMessageDialog(null, "Book borrowed successfully!");
                    
                    // Ask if the user wants to borrow another book
                    int response = JOptionPane.showConfirmDialog(null, "Do you want to borrow another book?", "Borrow Book", JOptionPane.YES_NO_OPTION);
                    if (response == JOptionPane.YES_OPTION) {
                        // Redirect to the BookCatalogScreen
                        new BookCatalogScreen(); // Open the catalog screen
                        dispose(); // Close the borrowing screen
                    } else {
                        dispose(); // Close the borrowing screen
                    }
                }
            }
        });
        
        // Action listener for the cancel button
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the borrowing screen
            }
        });
        
        // Add buttons to the panel
        panel.add(submitButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space
        panel.add(cancelButton);
        
        // Add the panel to the frame
        add(panel);
        
        // Set the frame to be visible
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new BookBorrowingScreen();
    }
}
