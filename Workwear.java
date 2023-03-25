 import java.util.Scanner;
/**
 * Subclass which represents a workwear type of item
 *
 * 
 * @version (24/03/2023)
 */
public class Workwear extends Accessory
{
    private String manufacturingStandard;
    private String colour;
    private String size;

    /**
     * Constructor for objects of class Workwear
     */
    public Workwear()
    {
        super();
        manufacturingStandard = null;
        colour = null;
        size = null;
    }
    /**
     * Accessor method
     */
    public String getManufacturingStandard()
    {
        return manufacturingStandard;
    }
    /**
     * Accessor method
     */
    public String getColour()
    {
        return colour;
    }
    /**
     * Accessor method
     */
    public String getSize()
    {
        return size;
    }
    /**
    *  Method used to read the data from the line of text in the 2nd scanner passed by the 
    *  readItemData() in the Shop class
    */
    public void readData(Scanner scanner2)
    {    
        super.readData(scanner2); //calls read data method of Superclass Accassory, which reads data into the Suiperclas' fields
        manufacturingStandard = scanner2.next().trim(); 
        colour = scanner2.next().trim();
        size = scanner2.next().trim();
    }
    /**
    *  Method used to print details of the Workwear item from this Subclass but also from Superclasses.
    */
    protected void printDetails()
    {
        System.out.print("Accessory type: " + this.getClass().getSimpleName() + ", ");
        super.printDetails(); //calls superclass' method to print data stored in Superclass fields
        System.out.println("manufacturing standard: " + getManufacturingStandard() + "; colour: " + getColour() + "; size: " + getSize() + "\n");
    }
}
