import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String author;
    private String publisher;
    private int year;
    private String language;

    public Book(String title, String author, String publisher, int year, String language) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.language = language;
    }

    @Override
    public String toString() {
        return String.format("Book{title='%s', author='%s', publisher='%s', year=%d, language='%s'}",
                title, author, publisher, year, language);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

    public String getLanguage() {
        return language;
    }
}