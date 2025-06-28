import java.io.Serializable;

public class BookLeaf extends CategoryComponent implements Serializable {
    private Book book;

    public BookLeaf(Book book) {
        this.book = book;
    }

    @Override
    public void print() {
        System.out.println("  - " + book);
    }

    public Book getBook() {
        return book;
    }
}