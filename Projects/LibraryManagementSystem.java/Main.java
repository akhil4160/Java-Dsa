import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        library.loadFromFile();

        int choice;

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add book");
            System.out.println("2. Display Sbook");
            System.out.println("3. Search book");
            System.out.println("4. Delete book");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book Id: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter author: ");
                    String author = sc.nextLine();

                    Book book = new Book(bookId, title, author, false);
                    library.addBook(book);
                    library.saveToFile();

                    System.out.println("Book Added Successfully");
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter Book Id: ");
                    bookId = sc.nextInt();

                    Book foundBook = library.searchBook(bookId);

                    if (foundBook != null) {
                        System.out.println(foundBook);
                    } else {
                        System.out.println("Book Not Found");
                    }
                    break;

                case 4:
                    System.out.print("Enter Book Id: ");
                    bookId = sc.nextInt();

                    if (library.deleteBook(bookId)) {
                        library.saveToFile();
                        System.out.println("Book Deleted Successfully");
                    } else {
                        System.out.println("Book Not Found");
                    }
                    break;

                case 5:
                    System.out.print("Enter Book Id: ");
                    bookId = sc.nextInt();

                    if (library.issueBook(bookId)) {
                        library.saveToFile();
                        System.out.println("Book Issued Successfully");
                    } else {
                        System.out.println("Cannot Issue Book");
                    }
                    break;

                case 6:
                    System.out.print("Enter Book Id: ");
                    bookId = sc.nextInt();

                    if (library.returnBook(bookId)) {
                        library.saveToFile();
                        System.out.println("Book Returned Successfully");
                    } else {
                        System.out.println("Cannot Return Book");
                    }
                    break;

                case 7:
                    System.out.println("Thank You!");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
