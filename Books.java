public abstract class Books {
    protected String isbn;
    protected String title;
    protected int publicationYear;
    protected double price;


    public Books(String isbn, String title, int publicationYear, double price) {
        this.isbn = isbn;
        this.title = title;
        this.publicationYear = publicationYear;
        this.price = price;
    }
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title; }

    public int getPublicationYear() {
        return publicationYear;
    }
    public double getPrice() {
        return price;
    }
    public abstract boolean isOutdated(int currentYear, int outdatedThreshold);
}