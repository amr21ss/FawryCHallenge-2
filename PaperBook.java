public class PaperBook extends Books implements Shippable {
    private int quantity;

    public PaperBook(String isbn, String title, int publictionYear, double price, int quantity) {
        super(isbn, title, publictionYear, price);
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean isOutdated(int currentYear, int outdatedThreshold) {
        int age = currentYear - getPublicationYear();
        return age > outdatedThreshold;
    }

    @Override
    public void ship(String address) {
        System.out.println("Paper book '" + getTitle() + "' (ISBN: " + getIsbn() + ") is being shipped to: " + address);
    }
}