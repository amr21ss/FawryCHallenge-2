public class DemoBook extends Books{
    //assuming that we are working by yearly demo
    private int demoDurationInYears ;

    public DemoBook(String isbn, String title, int publictionYear, double price, int demoDurationInYears ) {
        super(isbn, title, publictionYear, price);
        this.demoDurationInYears = demoDurationInYears;
    }
    public int demoDurationInYears() {
        return demoDurationInYears;
    }
    public void setDemoDurationInYears(int demoDurationInYears) {
        this.demoDurationInYears = demoDurationInYears;
    }

    @Override
    //if old outdated or if demo phase ended
    public boolean isOutdated(int currentYear, int outdatedThresholdYears) {
        int age = currentYear - getPublicationYear();
        int demoYears = demoDurationInYears;
        int demoEndYear = getPublicationYear() + demoYears;
        return age > outdatedThresholdYears || currentYear > demoEndYear;

    }


}