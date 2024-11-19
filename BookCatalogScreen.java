import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookCatalogScreen extends JFrame {
    
    public BookCatalogScreen() {
        // Set the title of the window
        setTitle("Book Catalog");
        
        // Set the size of the window
        setSize(600, 400);
        
        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        // Create a search bar
        JPanel searchPanel = new JPanel();
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        
        // Action listener for the search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = searchField.getText();
                JOptionPane.showMessageDialog(null, "Search functionality not implemented yet.");
            }
        });
        
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        
        // Create a table to display books
        String[] columnNames = {"Title", "Author", "Genre", "Availability"};
        Object[][] data = {
            {"The Great Gatsby", "F. Scott Fitzgerald", "Fiction", "Available"},
            {"To Kill a Mockingbird", "Harper Lee", "Fiction", "Available"},
            {"1984", "George Orwell", "Dystopian", "Checked Out"},
            {"Pride and Prejudice", "Jane Austen", "Romance", "Available"},
            {"The Catcher in the Rye", "J.D. Salinger", "Fiction", "Available"},
            {"The Hobbit", "J.R.R. Tolkien", "Fantasy", "Checked Out"},
            {"Moby Dick", "Herman Melville", "Adventure", "Available"},
            {"War and Peace", "Leo Tolstoy", "Historical", "Available"},
            {"The Odyssey", "Homer", "Epic", "Available"},
            {"The Picture of Dorian Gray", "Oscar Wilde", "Fiction", "Checked Out"},
            {"Brave New World", "Aldous Huxley", "Dystopian", "Available"},
            {"The Alchemist", "Paulo Coelho", "Adventure", "Available"},
            {"The Kite Runner", "Khaled Hosseini", "Fiction", "Available"},
            {"The Da Vinci Code", "Dan Brown", "Mystery", "Checked Out"},
            {"The Fault in Our Stars", "John Green", "Young Adult", "Available"},
            {"The Hunger Games", "Suzanne Collins", "Dystopian", "Available"},
            {"The Chronicles of Narnia", "C.S. Lewis", "Fantasy", "Available"},
            {"The Grapes of Wrath", "John Steinbeck", "Fiction", "Available"},
            {"The Road", "Cormac McCarthy", "Post-Apocalyptic", "Available"},
            {"The Book Thief", "Markus Zusak", "Historical Fiction", "Available"},
        };
        
        JTable bookTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(bookTable);
        
        // Add components to the panel
        panel.add(searchPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // Add a borrow button
        JButton borrowButton = new JButton("Borrow Selected Book");
        borrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = bookTable.getSelectedRow();
                if (selectedRow != -1) {
                    new BookBorrowingScreen(); // Open borrowing screen
                    dispose(); // Close the catalog screen
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a book to borrow.");
                }
            }
        });
        
        // Add a return button
        JButton returnButton = new JButton("Return Selected Book");
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BookReturnScreen(); // Open return screen
                dispose(); // Close the catalog screen
            }
        });
        
        // Add buttons to the panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(borrowButton);
        buttonPanel.add(returnButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        // Add the panel to the frame
        add(panel);
        
        // Set the frame to be visible
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new BookCatalogScreen();
    }
}
