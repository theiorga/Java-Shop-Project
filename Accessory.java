import java.util.Scanner;
/**
 * Superclass off perishable and workwear items
 *
 *
 * @version (24/03/2023)
 */
public abstract class Accessory extends ShopItem
{
    private boolean isRecyclable;

    /**
     * Constructor for objects of class Accessory
     */
    public Accessory()
    {
        super();
        isRecyclable = false;
    }

    /**
     * Accessor method
     */
    public boolean getIsRecyclable()
    {
        // put your code here
        return isRecyclable;
    }
    /**
     * Method called by Subclasses to read data from this Superclass' fields
     */
    public void readData(Scanner scanner2)
    {    
        isRecyclable = Boolean.parseBoolean(scanner2.next().trim());
        super.readData(scanner2);
    }
    /**
     * Method called by Subclasses to print data from this Superclass' fields
     */
    protected void printDetails()
    {
        System.out.print("Is Recyclable?: " + getIsRecyclable() + "; ");
        super.printDetails();
    }
}
