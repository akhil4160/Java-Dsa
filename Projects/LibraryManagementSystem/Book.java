public class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(int bookId,String title,String author,boolean isIssued) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isIssued = isIssued;
    }

    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isIssued() {
        return isIssued;
    }
    public void setIsIssued(boolean isIssued) {
        this.isIssued = isIssued;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + "\nTitle: " + title + "\nAuthor: " + author + "\nIssued: " + isIssued;
    }
}
