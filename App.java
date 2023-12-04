import java.io.IOException;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Homepage home = new Homepage();
        AboutUs about = new AboutUs();
        Userguides userGuide = new Userguides();
        UserRegistrationLogin user = new UserRegistrationLogin();
        FAQs faq = new FAQs();
        Hotdeals deal = new Hotdeals();
        Review review = new Review();
        OrderNow order = new OrderNow();
        Control control = new Control();

        do {
            home.displayMenu();

            switch (home.choice) {
                case 1:
                    about.aboutUs();
                    control.backOrExit();
                    break;
                case 2:
                    userGuide.userGuides();
                    control.backOrExit();
                    break;

                case 3:
                    user.authenticationMenu();
                    control.backOrExit();

                    break;
                case 4:
                    if (user.isLoggedIn == 1) {
                        try {
                            order.orderNow();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        control.delay();
                    } else {
                        System.out.println("You need to log in first to place an order.");
                        System.out.println("Redirecting to the authentication page...");
                        System.out.print("Press any key to continue...");
                        scanner.nextLine();
                        user.authenticationMenu();
                    }
                    break;

                case 5:
                    if (deal.code == 0) {
                        deal.hotDeals();
                    } else {
                        System.out.println("You've already checked your offer!");
                        System.out.println("Your discount code is: " + deal.code);
                    }

                    control.backOrExit();
                    break;
                case 6:
                    faq.faqs();
                    control.backOrExit();
                    break;

                case 7:
                    if (user.isLoggedIn == 1) {
                        review.reviews();
                    } else {
                        System.out.println("You need to log in first to review.");
                    }
                    control.backOrExit();

                    break;

                case 8:
                    System.out.println("Thanks for exploring our service. Hope to see you soon!");
                    System.out.println("Best wishes from Lost Kitchen team! :)");
                    home.choice = 0;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }

        } while ((home.choice <= 8) && (home.choice != 0));

    }

}
