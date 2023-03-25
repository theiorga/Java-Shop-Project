import java.util.Scanner;

/**
 * Subclass which represents a perishable type of item
 *
 * 
 * @version (24/03/2023)
 */
public class Perishable extends Accessory
{
    // instance variables - replace the example below with your own
    private boolean isIrritant;
    private String useByDate;
    private int volume;

    /**
     * Constructor for objects of class Perishable
     */
    public Perishable()
    {
        // initialise instance variables
        super();
        isIrritant = false;
        useByDate = null;
        volume = 0;
    }

    /**
     * Accessor method
     */
    public boolean  getIsIrritant()
    {
        return isIrritant;
    }
    /**
     * Accessor method
     */
    public String  getUseByDate()
    {
        return useByDate;
    }
    /**
     * Accessor method
     */
    public int getVolume()
    {
        return volume;
    }
    /**
    *  Method used to read the data from the line of text in the 2nd scanner passed by the 
    *  readItemData() in the Shop class
    */
    public void readData(Scanner scanner2)
    {    
        super.readData(scanner2); //calls read data method of Superclass Accessory, which reads data into the Suiperclas' fields
        isIrritant = Boolean.parseBoolean(scanner2.next().trim());
        useByDate = scanner2.next().trim();
        volume = Integer.parseInt(scanner2.next().trim());
    }
   /**
    *  Method used to print details of the Perishable item from this Subclass but also from Superclasses.
    */
    protected void printDetails()
    {
        System.out.print("Accessory type: " + this.getClass().getSimpleName() + ", ");
        super.printDetails(); //calls superclass' method to print data stored in Superclass fields
        System.out.println("is irritant?: " + getIsIrritant() + "; use by date: " + getUseByDate() + "; volume: " + getVolume() + "\n");
    }
}
