package lab1;

/**
 * A representation of a library of books.
 * @author <a href="mailto:rkhatchadourian@citytech.cuny.edu">Raffi Khatchadourian</a>.
 */
public class Library {
    // TODO: Add the missing implementation to this class
      String address;
    java.util.ArrayList<Book> books;

    public static final String openTime = "9am";
    public static final String closeTime = "5pm";

    public Library(String libraryAddress) {
        address = libraryAddress;
        books = new java.util.ArrayList<Book>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public static void printOpeningHours() {
        System.out.println("Libraries are open daily from " + openTime + " to " + closeTime);
    }
        
    public void printAddress() {
        System.out.println(address);
    }

    public void printAvailableBooks() {
        boolean bookPresent = false;
        for (Book book : books) {
            if (!book.isBorrowed()) {
                System.out.println(book.getTitle());
                bookPresent = true;
            }
        }
        if (!bookPresent) {
            System.out.println("No book in catalog");
        }
    }

    public void borrowBook(String title) {
        int found = 0;
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                if (found == 0) {
                    found = 1;
                    }
                if (!book.isBorrowed()) {
                    book.rented();
                    found = 2;
                    break;
                };
            }
        }
        if (found == 0) {
            System.out.println("Sorry, this book is not in our catalog.");
        } else if (found == 1) {
            System.out.println("Sorry, this book is already borrowed.");
        } else if (found == 2) {
            System.out.println("You successfully borrowed " + title);
        }
    }

    public void returnBook(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equals(title) && book.isBorrowed()) {
                book.returned();
                found = true;
                break;
            }
        }
        if (found) {
           System.out.println("You successfully returned " + title);
        }
    }

    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}
