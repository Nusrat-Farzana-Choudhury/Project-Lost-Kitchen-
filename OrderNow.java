import java.io.IOException;
import java.util.Scanner;

public class OrderNow extends Hotdeals {

    public String address;

    public String contact;
    int order = 0;

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void orderNow() throws IOException {

        Homepage home = new Homepage();
        BillShow bill = new BillShow();
        Scanner scanner = new Scanner(System.in);

        clearConsole();
        System.out.println("\n\n\t\t\t\t\t\t\t\t\t\t\t---------------------Order Now!!!---------------------");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t-Fresh flavour at the best rate!\n\n\n");

        if (code == 0) {
            System.out.println("You haven't checked your offer yet. Redirecting you to 'Hot deals'.");
            System.out.println("Press Enter to continue...");
            scanner.nextLine();
            hotDeals();
            System.out.println("Press Enter to continue...");
            scanner.nextLine();
        }

        System.out.println("\nYour discount code is " + code);

        if (code == 503) {
            System.out.println("You have to order at least BDT 100/- to enjoy 10% discount.");
        } else if (code == 504) {
            System.out.println("You have to order at least BDT 150/- to enjoy the discount.");
        } else if (code == 505) {
            System.out.println("You have to order at least BDT 90/- to enjoy the discount.\n\n");
        }

        System.out.println("\t\t\t\tBreakfast\t\t\t\n\t\t(Available from 7 a.m. to 12 p.m)\n");
        System.out.println("\t1. Rooti .......................................10/-\n");
        System.out.println("\t2. Paratha .....................................10/-\n");
        System.out.println("\t3. Daal ........................................10/-\n");
        System.out.println("\t4. Sobji .......................................10/-\n");
        System.out.println("\t5. Omlette .....................................15/-\n");
        System.out.println("\t6. Khichuri.....................................30/-\n");
        System.out.println("\t7. Cha .........................................10/-\n");
        System.out.println("\t8. Coffee ......................................15/-\n");
        System.out.println("\t9. Singara .....................................10/-\n");
        System.out.println("\t10. Samusa .....................................15/-\n");
        System.out.println("\n\n\t\t\t\tLunch & Dinner\t\t\t\n\t\t(Available from 12-4 p.m. & 7-11 p.m.)\n");
        System.out.println("\t11. Rice .......................................20/-\n");
        System.out.println("\t12. Chicken (Half) .............................40/-\n");
        System.out.println("\t13. Chicken (Full) .............................65/-\n");
        System.out.println("\t14. Beef (Half) ................................55/-\n");
        System.out.println("\t15. Beef (Full) ................................90/-\n");
        System.out.println("\t16. Egg curry ..................................20/-\n");
        System.out.println("\t17. Fish curry .................................40/-\n");
        System.out.println("\t18. Fish fry   .................................40/-\n");
        System.out.println("\t19. Mixed sobji ................................15/-\n");
        System.out.println("\t20. Aloo vorta .................................10/-\n");
        System.out.println("\t21. Mach vorta .................................10/-\n");
        System.out.println("\t22. Shutki Vorta ...............................10/-\n");
        System.out.println("\t23. Daal .......................................10/-\n");
        System.out.println("\n\n\t\t\tDesserts & Beverages\t\t\t\n\t\t\t(Always Available)\n");
        System.out.println("\t24. Kheer ......................................30/-\n");
        System.out.println("\t25. Roshmalai ..................................30/-\n");
        System.out.println("\t26. Doi ........................................30/-\n");
        System.out.println("\t27. Rosogollah .................................10/-\n");
        System.out.println("\t28. Coca-Cola ..................................25/-\n");
        System.out.println("\t29. Mirinda   ..................................25/-\n");
        System.out.println("\t30. Mineral Water   ............................15/-\n");

        System.out.println("\n\n\tOrder your dish: (Enter 0 to finish order)");
        int[] arID = new int[30];
        int[] arqty = new int[10];
        int[] Bill = new int[10];
        int counter = 0;

        while (true) {
            counter++;
            System.out.print("\t Enter Food ID\t\t: ");
            arID[counter - 1] = scanner.nextInt();

            if (arID[counter - 1] == 0) {
                break;
            } else if (arID[counter - 1] < 0 || arID[counter - 1] > 30) {
                System.out.println("\t\t Wrong food ID!!!");
                counter--;
            } else {
                System.out.print("\t Enter Quantity\t\t: ");
                arqty[counter - 1] = scanner.nextInt();
            }
        }

        counter--;

        clearConsole();
        System.out.print("\nEnter your address (In Ashuliya)\t\t: ");
        scanner.nextLine();
        address = scanner.nextLine();
        setAddress(address);
        System.out.print("Enter your contact no. for confirmation\t: ");
        contact = scanner.nextLine();
        setAddress(contact);

        System.out.println("\n\nPress Enter to continue...");
        scanner.nextLine();

        bill.billShow(arID, arqty, counter);
        order = 1;
        System.out.println("\n\n\nPress enter to continue...");
        scanner.nextLine();
        home.choice = 8;
    }

}
