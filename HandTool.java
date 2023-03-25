import java.util.Scanner;
/**
 * Sub class which represents a hand tool item
 *
 * 
 * @version (24/03/2023)
 */
public class HandTool extends Tool
{
    // instance variables - replace the example below with your own
    private boolean sharpenable;

    /**
     * Constructor for objects of class Hand Tool
     */
    public HandTool()
    {
        super();
        sharpenable = false;
    }
    /**
     * Accessor method
     */
    private boolean getSharpenable()
    {
        return sharpenable;
    }
    /**
    *  Method used to print details of the Hand tool item from this Subclass but also from Superclasses.
    */
    protected void printDetails()
    {
        System.out.print("Tool type: " + this.getClass().getSimpleName() + ", ");
        super.printDetails();
        System.out.println("sharpenable: " + sharpenable + "\n"); 
    }
    /**
    *  Method used to read the data into fields from the line of text in the 2nd scanner passed by the 
    *  readItemData() in the Shop class
    */
    public void readData(Scanner scanner2)
    {    
        super.readData(scanner2);
        sharpenable = Boolean.parseBoolean(scanner2.next().trim());
    }


}
