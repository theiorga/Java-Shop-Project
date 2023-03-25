import java.util.Scanner;
/**
 * Write a description of class ShopItem here.
 *
 *
 * @version (24/03/2023)
 */

public class ShopItem
{
    private String itemName;
    private String itemCode;
    private int cost;
    /**
     * Constructor for objects of class ShopItem
     */
    public ShopItem()
    {
        // initialise instance variables
        itemName = null;
        itemCode = null;
        cost = 0;
    }
    /**
     * Acessor method
     */
    protected String getItemName()
    {
        return itemName;
    }
     /**
     * Acessor method
     */
    protected String getItemCode()
    {
        return itemCode;
    }
     /**
     * Acessor method
     */
    protected int getCost()
    {
        return cost;
    }
    /**
     * Method called by Subclass to read data from this Superclass' fields
     */
    protected void readData(Scanner scanner2)
    {
        itemName = scanner2.next().trim();
        itemCode = scanner2.next().trim();
        cost = Integer.parseInt(scanner2.next().trim());
    }
    /**
     * Method called by Subclass to print data from this Superclass' fields
     */
    protected void printDetails()  
    {
        System.out.println("Item name: " + getItemName() + "; item code: " + getItemCode() + "; cost: " + getCost());
    }
}
