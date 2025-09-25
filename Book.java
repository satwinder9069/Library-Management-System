package task3_LibraryManagementSystem;

public class Book {
    private final String ISBN;
    private final String title;
    private final Author author;
    private boolean isAvailable = true;

    public Book(String ISBN, String title, Author author) {
        if(ISBN == null || ISBN.trim().isEmpty() || title == null || author == null) {
            throw new IllegalArgumentException("ISBN, title, and author cannot be null!");
        }
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getISBN() { return ISBN;}

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    protected void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public String toString() {
        return "Book{ISBN='" + ISBN + "', title='" + title + "', available=" + isAvailable + "}";
    }
}
