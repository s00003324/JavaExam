import java.util.ArrayList;
import java.util.List;

public class TestFileManager {
    public static void main(String[] args) {
        // Create a Book
        Book book = new Book("A Brief History of Time", "Stephen Hawking", "Bantam", 1988, "English");

        // Wrap it in a BookLeaf
        BookLeaf bookLeaf = new BookLeaf(book);

        // Create a Category and add the BookLeaf
        Category science = new Category("Science");
        science.add(bookLeaf);

        // Store all categories
        List<CategoryComponent> categories = new ArrayList<>();
        categories.add(science);

        // Save to file
        FileManager.saveBooks(categories, "books.dat");

        // Load from file
        List<CategoryComponent> loaded = FileManager.loadBooks("books.dat");

        // Print loaded data
        if (loaded != null) {
            for (CategoryComponent component : loaded) {
                component.print(); // ✅ This must be print()
            }
        } else {
            System.out.println("Failed to load books.");
        }
    }
}
