import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Library {

    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }

    public Book searchBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }

        return null;

    }

    public boolean deleteBook(int bookId) {
        Book book = searchBook(bookId);

        if (book != null) {
            books.remove(book);
            return true;
        }
        return false;
    }

    public boolean issueBook(int bookId) {
        Book book = searchBook(bookId);
        if (book == null) {
            return false;
        } else {
            if (book.isIssued()) {
                return false;
            } else {
                book.setIsIssued(true);
                return true;
            }
        }
    }

    public boolean returnBook(int bookId) {
        Book book = searchBook(bookId);
        if (book == null) {
            return false;
        } else {
            if (!book.isIssued()) {
                return false;
            } else {
                book.setIsIssued(false);
                return true;
            }
        }
    }

    public void saveToFile() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("books.txt"));

            for (Book book : books) {
                pw.println(
                        book.getBookId() + "," +
                                book.getTitle() + "," +
                                book.getAuthor() + "," +
                                book.isIssued());
            }

            pw.close();

        } catch (IOException e) {
            System.out.println("Error Saving File");
        }
    }

    public void loadFromFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("books.txt"));

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int bookId = Integer.parseInt(data[0]);
                String title = data[1];
                String author = data[2];
                boolean isIssued = Boolean.parseBoolean(data[3]);

                Book book = new Book(bookId, title, author, isIssued);
                
                books.add(book);
            }

            br.close();
            
        } catch (IOException e) {

        }
    }

}
