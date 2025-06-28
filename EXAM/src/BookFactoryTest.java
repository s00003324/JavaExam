import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookFactoryTest {

    @Test
    public void testCreateBook() {
        Book book = BookFactory.createBook("Title", "Author", "Publisher", 2022, "Italiano");
        assertEquals("Title", book.getTitle());
        assertEquals("Author", book.getAuthor());
        assertEquals("Publisher", book.getPublisher());
        assertEquals(2022, book.getYear());
        assertEquals("Italiano", book.getLanguage());
    }
}
