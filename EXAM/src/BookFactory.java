public class BookFactory {
    public static Book createBook(String title, String author, String publisher, int year, String language) {
        return new Book(title, author, publisher, year, language);
    }
}