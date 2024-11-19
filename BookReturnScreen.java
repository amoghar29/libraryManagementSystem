import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookReturnScreen extends JFrame {
    
    public BookReturnScreen() {
        // Set the title of the window
        setTitle("Book Return");
        
        // Set the size of the window
        setSize(400, 200);
        
        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Vertical layout
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding
        
        // Create and add components to the panel
        JLabel bookLabel = new JLabel("Select Book to Return:");
        JComboBox<String> bookComboBox = new JComboBox<>(new String[] {
            "The Great Gatsby", 
            "To Kill a Mockingbird", 
            "1984", 
            "Pride and Prejudice", 
            "The Catcher in the Rye", 
            "The Hobbit", 
            "Moby Dick", 
            "War and Peace", 
            "The Odyssey", 
            "The Picture of Dorian Gray", 
            "Brave New World", 
            "The Alchemist", 
            "The Kite Runner", 
            "The Da Vinci Code", 
            "The Fault in Our Stars", 
            "The Hunger Games", 
            "The Chronicles of Narnia", 
            "The Grapes of Wrath", 
            "The Road", 
            "The Book Thief"
        });
        panel.add(bookLabel);
        panel.add(bookComboBox);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space
        
        // Buttons for return and cancel
        JButton returnButton = new JButton("Return Book");
        JButton cancelButton = new JButton("Cancel");
        
        // Action listener for the return button
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedBook = (String) bookComboBox.getSelectedItem();
                JOptionPane.showMessageDialog(null, "Book returned successfully: " + selectedBook);
                
                int response = JOptionPane.showConfirmDialog(null, "Do you want to return another book?", "Return Book", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    // Reset the combo box for another selection
                    bookComboBox.setSelectedIndex(0);
                } else {
                    dispose(); // Close the return screen
                }
            }
        });
        
        // Action listener for the cancel button
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the return screen
            }
        });
        
        // Add buttons to the panel
        panel.add(returnButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space
        panel.add(cancelButton);
        
        // Add the panel to the frame
        add(panel);
        
        // Set the frame to be visible
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new BookReturnScreen();
    }
}
