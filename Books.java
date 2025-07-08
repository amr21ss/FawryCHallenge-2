public abstract class Books {
    protected String ISBN;
    protected String name;
    protected int publicationYear;
    protected double price;


    public Product(String ISBN, String name, int publicationYear, double price) {
        this.ISBN = ISBN;
        this.name = name;
        this publicationYear = publicationYear;
        this.price = price;
    }
    //ProductsMethods
    public String getIsbn() {
        return isbn;
    }

    public String getName() {
        return name; }

    public int getPublicationYear() {
        return publicationYear;
    }
    public double getPrice() {
        return price; }

    public  abstract boolean isOutdated(currentYear);

}