import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bookstore {
    private List<Book> inventory;
    public Bookstore() {
        this.inventory = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (book != null) {
            inventory.add(book);
            System.out.println("The following book:" book.getTitle()+ "is added to inventory");
        } else {
            System.out.println("Error: Book not found!");
        }
    }

    public List<Book> removeAndReturnOutdatedBooks(int currentYear, int outdatedThresholdYears) {
        List<Book> outdatedBooks = new ArrayList<>();
        Iterator<Book> iterator = inventory.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.isOutdated(currentYear, outdatedThresholdYears)) {
                outdatedBooks.add(book);
                iterator.remove();
                System.out.println("Removed outdated book: " + book.getTitle() + " (ISBN: " + book.getIsbn() + ")");
            }
        }
        System.out.println("Total outdated books removed: " + outdatedBooks.size());
        return outdatedBooks;
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Must be a positive number.");
        }

        Book bookToBuy = null;
        for (Book book : inventory) {
            if (book.getIsbn().equals(isbn)) {
                bookToBuy = book;
                break;
            }
        }

        if (bookToBuy == null) {
            throw new IllegalArgumentException("Book not found");
        }

        double totalAmount = 0.0;

        if (bookToBuy instanceof PaperBook) {
            PaperBook paperBook = (PaperBook) bookToBuy;
            if (paperBook.getQuantity() < quantity) {
                throw new IllegalArgumentException( paperBook.getTitle() + "Is out of stock, Available: " + paperBook.getQuantity());
            }
            if (address == null || address.trim().isEmpty()) {
                throw new IllegalArgumentException("Shipping address requred.");
            }

            paperBook.setQuantity(paperBook.getQuantity() - quantity); /
            totalAmount = paperBook.getPrice() * quantity;
            paperBook.ship(address);
            System.out.println("Bought " + quantity + " copies of " + paperBook.getTitle() + "'. Remaining stock: " + paperBook.getQuantity());

        } else if (bookToBuy instanceof EBook) {
            EBook eBook = (EBook) bookToBuy;
            if (email == null || email.trim().isEmpty()) {
                throw new IllegalArgumentException("Email address is required");
            }
            System.out.println("Bought " + eBook.getTitle() + "'. Emailed to: " + email);

        } else if (bookToBuy instanceof DemoBook) {
            throw new IllegalArgumentException("This is only for Demo  '" + bookToBuy.getTitle() + "' (ISBN: " + isbn + ") is not for sale.");
        } else {
            // Should not happen if all book types are handled
            throw new IllegalArgumentException("Unknown book type for ISBN: " + isbn);
        }

        return totalAmount;
    }


}