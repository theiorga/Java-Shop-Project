import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
/**
 * Main class used for testing of code in the Shop project
 *
 * 
 * @version 24/03/2023
 */
public class Main {
    public static void main(String[] args) throws IOException
    {
        Shop myShop = new Shop();
        myShop.readItemData();
        myShop.printAllItems();
        myShop.readCustomerData();
        myShop.printAllCustomers();
        myShop.writeCustomerData();
        ShopItemReservation myReservation = new ShopItemReservation("000123","MT454", "c2", "25-03-2023", 5);
        ShopItemReservation myReservation2 = new ShopItemReservation("000123","MT454", "c2", "25-03-2023", 5);
        myShop.storeItemReservation(myReservation);
        myShop.storeItemReservation(myReservation2);
        System.out.println(myShop.getItemReservation("000113"));
    }
}