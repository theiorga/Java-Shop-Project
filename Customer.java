import java.util.Scanner;
import java.io.*;
import java.util.Random;

/**
 * Write a description of class Customer here.
 *
 * 
 * @version (24/03/2023)
 */
public class Customer
{
    private String customerID;
    private String surname;
    private String firstName;
    private String otherInitials;
    private String title;
    private Random randomGenerator;
    /**
     * Constructor for objects of class Customer
     * 
     * 
     */
    public Customer(String inputSurname, String inputFirstName, String inputOtherInitials, String inputTitle)
    {
        customerID = "unknown";
        surname = inputSurname;
        firstName = inputFirstName;
        otherInitials = inputOtherInitials;
        title = inputTitle;
        randomGenerator = new Random();
    }
    /**
     * No-parameter constructor for objects of class Customer
     */
    public Customer()
    {
        customerID = "unknown";
        surname = "unknown";
        firstName = "unknown";
        otherInitials = "unknown";
        title = "unknown";
        randomGenerator = new Random();
    }
    /**
     * Accessor method.
     * 
     */
    public String getCustomerID()
    {
        return customerID;
    }
    /**
     * Accessor method.
     * 
     */
    public String getSurname()
    {
        return surname;
    }
    public String getFirstName()
    {
        return firstName;
    }
    /**
     * Accessor method.
     * 
     */
    public String getOtherInitials()
    {
        return otherInitials;
    }
    /**
     * Accessor method.
     * 
     */
    public String getTitle()
    {
        return title;
    }
    /**
     * Method used to pick up 
     * @param(scanner containing one line from the data file) 
     * and uses it to pass the required data into the Cusomer's 
     * fields.
     * 
     */
    protected void readData(Scanner scanner2)
    {
        customerID = scanner2.next().trim();
        surname = scanner2.next().trim();
        firstName = scanner2.next().trim();
        otherInitials = scanner2.next().trim();
        title = scanner2.next().trim();
    }
    /**
     * Method used to print all details of the customer into terminal.
     * 
     */
    protected void printDetails()
    {
        System.out.println("Customer ID: " + getCustomerID() + "; Surname: " + getSurname() + "; First name: " + getFirstName() + "; Other initials: " + getOtherInitials() + "; Title: " + getTitle() + "\n");
    }
    /**
     * Method used to print the customer's details into a file
     * using a @param(BufferedWriter writer) passed by the method 
     * writeCustomerData() in the Shop class
     * 
     */
    public void writeData(BufferedWriter output) throws IOException {
        output.write(customerID + ", " + surname + ", " + firstName + ", " + otherInitials + ", " + title + "\n");
    }
    /**
     * 
     * Method used to generate a customer ID given
     * @param(a string prefix of the ID) amd
     * @param(the number of digits which follow the prefix)
     * It sets the customerID to the newly generated ID.
     * 
     */
    public void generateCustomerID(String prefix, int numberOfDigits)
    {
        for (int i = 0; i < numberOfDigits; i++) //iterates through the chosen number of digits
        {
            int number = randomGenerator.nextInt(10); // generates a random digit every time
            prefix = prefix + number; //adds random digit to the prefix string every time
        }
        customerID = prefix; //sets ID to the digit string.
    }
}
