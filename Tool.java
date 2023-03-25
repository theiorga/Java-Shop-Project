    import java.util.Scanner;
    public abstract class Tool extends ShopItem {
    private int timesBorrowed;
    private boolean onLoan;
    private int weight;
    /**
    * Superclass off electric and hand tool classes
    *
    *
    * @version (24/03/2023)
    */
    public Tool()
    {
        super();
        timesBorrowed = 0;
        onLoan = false;
        weight = 0;
    }
    /**
    * Accessor method
    */
    public int getTimesBorrowed()
    {
        return timesBorrowed;
    }
    /**
    * Accessor method
    */
    public boolean getOnLoan()
    {
        return onLoan;
    }
    /**
    * Accessor method
    */
    public int getWeight()
    {
        return weight;
    }
    /**
     * Method called by Subclasses to print data from this Superclass' fields
     */
    protected void printDetails()
    {
        super.printDetails();
        System.out.print("times borrowed: " + getTimesBorrowed() + "; on loan?: " + getOnLoan() + "; weight: " + getWeight() + " grammes, ");
    }
    /**
     * Method called by Subclasses to read data from this Superclass' fields
     */
    protected void readData(Scanner scanner2)
    {         
        super.readData(scanner2);
        timesBorrowed = Integer.parseInt(scanner2.next().trim());
        onLoan = Boolean.parseBoolean(scanner2.next().trim());
        weight = Integer.parseInt(scanner2.next().trim());     
    }
}

