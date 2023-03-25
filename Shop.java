
import java.util.ArrayList;
import java.awt.FileDialog;
import java.io.*;
import java.awt.Frame;
import java.util.*;
/**
 * Class which represents the shop in this project
 *
 * 
 * @version 24/03/2023
 */
public class Shop {
    //stores items
    private HashMap<String, ShopItem> itemList;
    //stores customers
    private HashMap<String, Customer> customerList;
    //stores reservations
    private HashMap<String, ShopItemReservation> itemReservationMap;
    
    public Shop() {
        itemList = new HashMap<String, ShopItem>();
        customerList = new HashMap<String, Customer>();
        itemReservationMap = new HashMap<String, ShopItemReservation>();
    }
    /**
    *
    * Class used to stores an intem in the Shop's inverntory
    * 
    */
    private void storeItem(ShopItem storedItem) {
        itemList.put(storedItem.getItemCode(), storedItem);
    }
    /**
    * Class used to store a reservation in the Shop's reservation list
    * @param(stored reservation)
    * 
    * 
    */
    protected void storeItemReservation(ShopItemReservation storedReservation) throws IOException {
        int valid = 0;
        while (valid == 0) 
        {
           if(itemReservationMap.containsKey(storedReservation.getReservationNo()) == false) //checks to see if this reservation's number is already saved in one of the Map's keys
           { 
              itemReservationMap.put(storedReservation.getReservationNo(), storedReservation); //if it isn't it adds it & prints a line to let you know the reservation was made.
              System.out.println("Reservation made: " + storedReservation.getReservationNo() + "; Item ID:" + storedReservation.getItemID() + "; Customer ID: " + storedReservation.getCustomerID() + "; Start date: " + storedReservation.getStartDate() + ";Number of days: " + storedReservation.getNoOfDays());
              valid = 1; //we go out of while loop
           }
           else //in case it is alerady in the list
             storedReservation.setReservationNo(storedReservation.getReservationNo()); //it calls for a new reservation number and goes back to while loop to check again.
        }
        File file = new File ("C:/Users/theiorga/Desktop/Uni/Programming project/Shop Part 4 Step 1/Reservations.txt"); //after reservation is added to map, a line with its data is also printed to a text file "Reservations.txt"
        PrintWriter p = new PrintWriter("Reservations.txt"); 
        p.println(storedReservation.getReservationNo() + "," + storedReservation.getItemID() + "," + storedReservation.getCustomerID() + "," + storedReservation.getStartDate() + "," + storedReservation.getNoOfDays());
        p.close();
    }
    /**
    * Class used to store a customer in the Shop's customer list
    * @param(stored customer)
    * 
    * 
    */
    private void storeCustomer(Customer storedCustomer) {
        if(storedCustomer.getCustomerID().equals("unknown") == true) //checks to see if the customer's ID is "unknown"
        {   
            while (true) {
                storedCustomer.generateCustomerID("SM-", 6); //generates a new ID for the customer 
                if (customerList.containsKey(storedCustomer.getCustomerID()) == false) //Checks to see if this ID already exists in the map
                   break; //if the ID isn't in the map already it goes ousite the loop
            }
        }
        customerList.put(storedCustomer.getCustomerID(), storedCustomer); //stores customer with their value of ID and all fields
        
    }
    /**
    * Class used to print all the items in the store
    * 
    */
    public void printAllItems() {
        System.out.println("\n\n---Item inventory---\n");
        for (String key : itemList.keySet()) //iterates through the item list's keys
        {
            itemList.get(key).printDetails(); //calls each item stored by its key & prints the details for each item 
        }

    }
    /**
    * Class used to print all the customers of the store
    * 
    */
    public void printAllCustomers()
    {
        System.out.println("\n---Customer list---\n");
        for (String key : customerList.keySet()) //iterates through the customer list's keys
        { 
            customerList.get(key).printDetails(); //calls each customer by their key & prints the details for each customer 
        }
    }
    /**
    * Class used to read item data from a text file chosen by the user,
    * create an item with this data and store them into the map
    */
    public void readItemData()
    {   
        //File Dialog box is created to let the user select a text file to load the data from
        Frame frame = null;
        FileDialog fileBox = new FileDialog(frame, "Open", FileDialog.LOAD);
        fileBox.setVisible(true);
        File dataFile = new File(fileBox.getFile());

        try {
            Scanner scanner = new Scanner(dataFile);//used to read lines from the data file
            int dataType = 0; //used to know which item type we are reading
            while(scanner.hasNext()) //checks to see if there are more lines in the file
            {
               String lineOfText = scanner.nextLine(); //stores line
               if((lineOfText.startsWith("/") == false) && (lineOfText.isBlank() == false)) //checks if the line is blank or is a comment
                { 
                  //if statements to check the line for a label to be able to set the data type for the following lines
                  if(lineOfText.trim().equals("[ElectricTool data]") == true || lineOfText.trim().equals("[electricTool data]") == true)
                  {
                      System.out.println("\n" + lineOfText);
                      dataType = 1;
                  }
                  else if(lineOfText.trim().equals("[HandTool data]") == true)
                  {
                      System.out.println("\n" + lineOfText);
                      dataType = 2;
                  }
                  else if(lineOfText.trim().equals("[Perishable data]") == true)
                  {
                      System.out.println("\n" + lineOfText);
                      dataType = 3;
                  }
                  else if(lineOfText.trim().equals("[Workwear data]") == true)
                  {
                      System.out.println("\n" + lineOfText);
                      dataType = 4;
                  }
                  if(lineOfText.startsWith("[") == false) //checks & excludes label lines from being read
                  {
                  System.out.println(lineOfText.trim());
                  Scanner localScanner = new Scanner(lineOfText); //passes the line to a 2nd scanner
                  localScanner.useDelimiter(","); 
                  ShopItem myItem = new ShopItem();
                  //based on the data type of the item in the line an object of corresponding type is created
                  if (dataType == 1)
                  {myItem = new ElectricTool();}
                  else if (dataType == 2)
                  {myItem = new HandTool();}
                  else if (dataType == 3)
                  {myItem = new Perishable();}
                  else if (dataType == 4)
                  {myItem = new Workwear();}
                  myItem.readData(localScanner); //2nd scanner with the line of text is passed to readData  method insite one of the ShopItem's Subclasses which saves the data in the line in the item's fields
                  storeItem(myItem); //after it has the data in its fields the Item is stored inside the inventory
                  localScanner.close();// 2nd scanner is closed
                  }
                }
            }
            scanner.close();}catch(FileNotFoundException e){
               System.out.println("No file was selected or the file name is incorrect.");
        }
    }
    /**
    * Class used to read customer data from a text file chosen by the user
    * create a customer with this data and store them into the map
    * 
    */
    public void readCustomerData()
    {   
        //File Dialog box is created to let the user select a text file to load the data from
        Frame frame = null;
        FileDialog fileBox = new FileDialog(frame, "Open", FileDialog.LOAD);
        fileBox.setVisible(true);
        File dataFile = new File(fileBox.getFile());
        try{
            Scanner scanner = new Scanner(dataFile); //scanner is created to read lines from the file
            while(scanner.hasNext()) //cheks if there are lines to be read in the file
            {
               String lineOfText = scanner.nextLine(); //reads the next line in the file
               if((lineOfText.startsWith("/") == false) && (lineOfText.isBlank() == false)) //checks if the line isn't blank or a comment
               {
                  System.out.println(lineOfText.trim());
                  Scanner localScanner = new Scanner(lineOfText); //creates 2nd scanner for data line
                  localScanner.useDelimiter(",");
                  Customer myCustomer  = new Customer(); //creates a customer object
                  myCustomer.readData(localScanner); //saves data from scanner to Customer's fields
                  storeCustomer(myCustomer); //stores customer with data from the line into the customer list
                  localScanner.close(); //closes 2nd scanner
               }
            }
        }catch(FileNotFoundException e){
            System.out.println("No file was selected or the file name is incorrect.");
        }
    }
    /**
    * Method used to clear the file before customer data from the list is written
    */
    public void clearCustomerFile() throws IOException {
        File file = new File("customers.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        writer.write("");
    }
    /**
    * Method used to write customer data from the list into a text file customers.txt
    */
    public void writeCustomerData() throws IOException
    {
        clearCustomerFile();
        File file = new File("customers.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
        for(String key : customerList.keySet())
            if(customerList.get(key) != null)
            customerList.get(key).writeData(writer);
        writer.close();
    
    }
    /**
    * Accessor method
    */
    protected ShopItem getItem(String checkID)
    {
        if (itemList.containsKey(checkID) == true)
        {
            return itemList.get(checkID);
        }
        else return null;
    }
        /**
    * Accessor method
    */
    protected Customer getCustomer(String checkID)
    {
        if (customerList.containsKey(checkID) == true)
        {
            return customerList.get(checkID);
        }
        else return null;
    }
    /**
    * Accessor method for a reservation inside the reservation map
    * 
    * checks for provided @param(string key) and returns the corresponding 
    * value if the key is in the Hash map.
    * If the key doesn't exist in the hash map method returns null
    */
    protected ShopItemReservation getItemReservation(String checkID)
    {
        if (itemReservationMap.containsKey(checkID) == true)
        {
            return itemReservationMap.get(checkID);
        }
        else return null;
    }
    
}