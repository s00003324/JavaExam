import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.io.File;

public class FileManagerTest {

    @Test
    public void testSaveAndLoadBooks() {
        Category root = new Category("Root");
        root.add(new BookLeaf(BookFactory.createBook("Test", "Author", "Pub", 2020, "IT")));
        String filename = "test_books.dat";

        FileManager.saveBooks(List.of(root), filename);
        List<CategoryComponent> loaded = FileManager.loadBooks(filename);

        assertNotNull(loaded);
        assertEquals(1, loaded.size());
        new File(filename).delete(); // clean up
    }
}
