import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookValidationTest {

    @Test
    public void testBookCreationWithEmptyTitleThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Book("", "Autore", "Editore", 2023, "Italiano");
        });
    }

    @Test
    public void testBookCreationWithNullTitleThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Book(null, "Autore", "Editore", 2023, "Italiano");
        });
    }
}