import java.util.Random;

public class Hotdeals {
    private int code;

    public void hotDeals() {
        

        Random rand = new Random();
        int num = rand.nextInt(5) + 1;

        System.out.println("\n\n\t\t\t\t\t\t\t\t\t\t\t---------------------Hot Deals!!!---------------------\n");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t-Hurry up! When it's gone, it's gone\n\n\n");
        System.out.println("Dear user, here's the offer for YOU ONLY:\n");

        if (num == 1) {
            code = 501;
            System.out.printf("Discount code: %d\nCongratulations! You've got 5%% off on your purchase.\n\n", code);
        } else if (num == 2) {
            code = 502;
            System.out.printf("Discount code: %d\nCongratulations! You've got 3%% off on your purchase.\n\n", code);
        } else if (num == 3) {
            code = 503;
            System.out.printf("Discount code: %d\nCongratulations! You've got 10%% discount on purchasing more than 100 BDT.\n\n", code);
        } else if (num == 4) {
            code = 504;
            System.out.printf("Discount code: %d\nCongratulations! You've got BDT 50 off on your purchase.\nYou have to order at least BDT 150/- to enjoy the discount.\n\n", code);
        } else if (num == 5) {
            code = 505;
            System.out.printf("Discount code: %d\nCongratulations! You've got BDT 30 off on your purchase.\nYou have to order at least BDT 90/- to enjoy the discount.\n\n", code);
        }
    }

}
