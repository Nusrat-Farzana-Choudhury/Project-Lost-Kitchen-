import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class  BillShow extends Control {

public int order_id;
public void setOrder_id(int order_id) {
    this.order_id = order_id;
}
public void billShow(int[] arID, int[] arqty, int counter) throws IOException {
    Scanner scanner = new Scanner(System.in);
    FileWriter writer = new FileWriter("orderDetails.txt", true); // Appending to the file
        BufferedWriter bufferWriter = new BufferedWriter(writer);
        Hotdeals deal= new Hotdeals();
        OrderNow order= new OrderNow();
        UserRegistrationLogin user = new UserRegistrationLogin();


        clearConsole(); 
        System.out.println("\n\n\t\t\t\t\t\t\t\t\t\t----------LOST KITCHEN-------------");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t-Where every flavor tells a story\n\n\n");
        System.out.println("\n\nHere's your bill:\n\n\n\t\tItem(s)\t\t     Quantity\t\t    Cost\n\n\n\n");

        int[] costs = {10, 10, 10, 10, 15, 30, 10, 15, 10, 15, 20, 40, 65, 55, 90, 20, 40, 40, 15, 10, 10, 10, 10, 30, 30, 30, 10, 25, 25, 15};
        String[] items = {"Rooti", "Paratha", "Daal", "Sobji", "Omlette", "Khichuri", "Cha", "Coffee", "Singara", "Samusa", "Rice", "Chicken (Half)", "Chicken (Full)", "Beef (Half)", "Beef (Full)", "Egg Curry", "Fish Curry", "Fish Fry", "Mixed Sobji", "Aloo Vorta", "Mach Vorta", "Shutki Vorta", "Daal", "Kheer", "Roshmalai", "Doi", "Rosogolla", "Coca-cola", "Mirinda", "Mineral Water"};

        double sum = 0.00;
        double discount = 0.00;
        double sum2 = 0.00;

        for (int i = 0; i < counter; i++) {
            System.out.printf("\t%2d. %-16s ________\t%-5d piece(s) ____ %7d\n", i + 1, items[arID[i] - 1], arqty[i], arqty[i] * costs[arID[i] - 1]);
            sum += (costs[arID[i] - 1] * arqty[i]);
        }

        if (deal.code == 501) {
            discount = sum * 0.05;
            sum2 = sum - discount;
        } else if (deal.code == 502) {
            discount = sum * 0.03;
            sum2 = sum - discount;
        } else if ((deal.code == 503) && (sum >= 100)) {
            discount = sum * 0.10;
            sum2 = sum - discount;
        } else if ((deal.code == 504) && (sum >= 150)) {
            discount = 50;
            sum2 = sum - discount;
        } else if ((deal.code == 505) && (sum >= 90)) {
            discount = 30;
            sum2 = sum - discount;
        }

        order_id = new Random().nextInt(100) + 1000; // Generate an order ID
        setOrder_id(order_id);

        System.out.printf("\n\n\n\n\t\t\t\t\tSub-total\t=%2f", sum);
        System.out.printf("\n\t\t\t\t\tDiscount\t= -%.2f", discount);
        System.out.printf("\n\t\t\t\t\tTotal\t\t= %.2f\n\n\n\n\n", sum2);

        System.out.println("---------------Billing info (in Ashuliya)-----------------");
        System.out.printf("\n\nOder ID\t\t\t: LK-%d", order_id);
        System.out.printf("\nName\t\t\t: %s\nAddress\t\t\t: %s\nPhone\t\t\t: %s", user.username, order.address, order.contact);
        System.out.println("\nPayment method\t\t: COD\n\n");
        bufferWriter.write(order_id + "," + user.username + "," + order.address + "," + order.contact + "," + sum2 + "\n");
        bufferWriter.close(); 

        System.out.println("Thanks for your order. Soon you'll get a call from our representative.");
        System.out.println("Your food will be delivered in 20-30 minutes after confirmation.\n\n\n\n");
        scanner.nextLine();
       
    }

}

