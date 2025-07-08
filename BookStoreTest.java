import java.util.List;
public class BookStoreTest {
    public static void main(String[] args) {
        System.out.println("** Starting  Simulation )f Our Bookstore **");
        Bookstore myBookstore = new Bookstore();
        System.out.println("\n** Adding books to the inventory **");
        PaperBook paperBook1 = new PaperBook("433", "Datastruct", 2018, 450.35, 30);
        EBook eBook1 = new EBook("777", "Database", 2021, 30.61, "PDF");
        DemoBook demoBook1 = new DemoBook("007", "Physics", 2023, 0, 1);
        PaperBook paperBook2 = new PaperBook("353", "Mats", 2004, 535.00, 5);
        EBook eBook2 = new EBook("198", "Coding", 2021, 28, "Word");
        DemoBook demoBook2 = new DemoBook("002", "AI ", 2023, 0.00, 2);

        myBookstore.addBook(paperBook1);
        myBookstore.addBook(eBook1);
        myBookstore.addBook(demoBook1);
        myBookstore.addBook(paperBook2);
        myBookstore.addBook(eBook2);
        myBookstore.addBook(demoBook2);

        System.out.println("\n** Removing Outdated Books, Current Year: 2025, Threshold: 5 years **");
        int currentYear = 2025;
        int outdatedThreshold = 5;
        List<Books> removedBooks = myBookstore.removeAndReturnOutdatedBooks(currentYear, outdatedThreshold);
        if (!removedBooks.isEmpty()) {
            System.out.println("Removed " + removedBooks.size() + " books as outdated:");
            for (Books book : removedBooks) {
                System.out.println("* " + book.getTitle() + " (Published: " + book.getPublicationYear() + ")");
            }
        } else {
            System.out.println("No books outdated");
        }

        System.out.println("\n** Testing buying books **");
        //testing first paperbook
        try {
            double paid = myBookstore.buyBook("433", 2, null, "Giza");
            System.out.printf("Successfully bought 2 copies of Datastruct, Total paid: $%.2f\n", paid);
        } catch (IllegalArgumentException e) {
            System.out.println("Purchase failed for Datastruct: " + e.getMessage());
        }
        //testing demo
        try {
            double paid = myBookstore.buyBook("007", 1, null, null);
            System.out.printf("Successfully bought a Demo Book, Total paid: $%.2f\n", paid);
        } catch (IllegalArgumentException e) {
            System.out.println("Purchase failed for  Physics: " + e.getMessage());
        }

        try {
            double paid = myBookstore.buyBook("777", 1, "amr@example.com", null);
            System.out.printf("Successfully bought a copy of database Paid: $%.2f\n", paid);
        } catch (IllegalArgumentException e) {
            System.out.println("Purchase failed for database: " + e.getMessage());
        }

        // buy more PaperBook than available
        try {
            // Assuming paperBook1 had 10, then 2 bought, now 8 remaining. Try to buy 9.
            double paid = myBookstore.buyBook("433", 9, null, "456 ");
            System.out.printf("Successfully bought 9 copies of DataStrict. Paid: $%.2f\n", paid);
        } catch (IllegalArgumentException e) {
            System.out.println("Purchase failed for DataStruct (too many): " + e.getMessage());
        }

        //  buy a non-existent book
        try {
            double paid = myBookstore.buyBook("00024", 1, null, null);
            System.out.printf("Successfully bought --- book. Paid: $%.2f\n", paid);
        } catch (IllegalArgumentException e) {
            System.out.println("Purchase failed for 00024-ISBN: " + e.getMessage());
        }

        System.out.println("\n--- Simulation Complete ---");
    }
}