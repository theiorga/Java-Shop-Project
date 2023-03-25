import java.util.Date;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Class which represents a reservation made by a customer with date about the
 * item, date and duration.xz
 *
 * 
 * @version (24/03/2023)
 */
public class ShopItemReservation
{
    private String reservationNo;
    private String itemID;
    private String customerID;
    private Date startDate;
    private int noOfDays;
    /**
     * Constructor for objects of class ShopItemReservation
     */
    public ShopItemReservation(String inputRreservationNo, String inputItemID, String inputCustomerID, String inputStartDate, int inputNumberOfDays)
    {
        reservationNo = inputRreservationNo;
        itemID = inputItemID;
        customerID = inputCustomerID;
        startDate = DateUtil.convertStringToDate(inputStartDate);
        noOfDays = inputNumberOfDays;
    }

    /**
     * Accessor method
     */
    protected String getReservationNo()
    {
        return reservationNo;
    }
    /**
     * Accessor method
     */
    public String getItemID()
    {
        return itemID;
    }
    /**
     * Accessor method
     */
    public String getCustomerID()
    {
        return customerID;
    }
    /**
     * Accessor method
     */
    public Date getStartDate()
    {
        return startDate;
    }
    /**
     * Accessor method
     */
    public int getNoOfDays()
    {
        return noOfDays;
    }
    /**
     * Method used by the storeItemReservation() method in the Shop class
     * to change the reservation number in case it already exists
     */
    public void setReservationNo(String inputNumber)
    {
        String newNumber = generateReservationNo(Integer.parseInt(inputNumber));
        reservationNo = newNumber;
    }
    /**
     * Method used to generate a reservation number in the requested format
     * which will be 1 higher than the number input as a @param(the last generated
     * reservation number)
     * 
     */
    public static String generateReservationNo(int lastNumber)
    {
        String number = "";
        int zeroes = 6 - String.valueOf(lastNumber).length(); //Checks how many digits is the number to know how many zeroes are needed to reach 6 digits
        for(int i = 0; i < zeroes; i++) //iterates to create the required number of zeroes in the string before the number
        {
            number = number + 0;
        }
        number = number + (lastNumber + 1); // adds new number after the zeroes in the string
        return number;
    }
}
