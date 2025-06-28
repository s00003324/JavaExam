import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CategoryTest {

    @Test
    public void testAddAndRetrieveBookLeaf() {
        Book book = BookFactory.createBook("Test Title", "Test Author", "Test Publisher", 2022, "Italiano");
        BookLeaf leaf = new BookLeaf(book);
        Category category = new Category("Test Category");
        category.add(leaf);

        CategoryComponent retrieved = category.getChild(0);
        assertNotNull(retrieved);
        assertTrue(retrieved instanceof BookLeaf);
    }
}
