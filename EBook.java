public class EBook extends Book implements Emailable {
    private String fileType;

    public Ebook(String isbn, String title, int publictionYear, double price, String fileType) {
        super(isbn, title, publictionYear, price);
        this.fileType = fileType;
    }
    public String getFileType() {
        return fileType;
    }
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Override
    public boolean isOutdated(int currentYear, int outdatedThreshold) {
        int age = currentYear - getYearPublished();
        return age > outdatedThreshold;
    }

    @Override
    public void sendEmail(String emailAddress) {
        System.out.println("Paper book '" + getTitle() + "' (ISBN: " + getIsbn() + ") is being emailed to: " + emailAddress);
    }
}