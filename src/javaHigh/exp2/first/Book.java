package javaHigh.exp2.first;

/**
 * @author guiyi
 * @Date 2024/3/27 14:39:07
 * @ClassName javaHigh.exp2.first.Book
 * @function -->
 */
public class Book {
    private String isbn;
    private String title;
    private String author;
    private int year;

    public Book(String isbn, String title, String author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Book book = (Book) obj;
        return isbn.equals(book.isbn);
    }

    @Override
    public int hashCode() {
        return isbn.hashCode();
    }

    @Override
    public String toString() {
        return "Book{" +
                ",ISBN='" + isbn +
                "',Title='" + title +
                "',Author='" + author +
                "',Year='" + year +
                "'}";
    }
}
