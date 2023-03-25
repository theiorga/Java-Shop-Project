import java.util.Scanner;
/**
 * Sub class which represents an electric tool item
 *
 * 
 * @version (24/03/2023)
 */
public class ElectricTool extends Tool
{
    private boolean rechargeable;
    private String power;

    /**
     * Constructor for objects of class ElectricTool
     */
    
    public ElectricTool()
    {
        super();
        rechargeable =  false;
        power = null;
    }
    /**
     * Accessor method
     */
    private  String getPower()
    {
        return power;
    }
    /**
     * Accessor method
     */
    private boolean getRechargeable()
    {
        return rechargeable;
    }
    /**
    *  Method used to print details of the Electric tool item from this Subclass but also from Superclasses.
    */
    protected void printDetails()
    {
        System.out.print("Tool type: " + this.getClass().getSimpleName() + ", ");
        super.printDetails();
        System.out.println("rechargeable: " + getRechargeable() + ", power: " + getPower() + "\n"); 
    }
    /**
    *  Method used to read the data into fields from the line of text in the 2nd scanner passed by the 
    *  readItemData() in the Shop class
    */
    public void readData(Scanner scanner2)
    {    
        super.readData(scanner2);
        rechargeable = Boolean.parseBoolean(scanner2.next().trim());
        power = scanner2.next().trim();
    }

}
