import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserRegistrationLogin extends Control {
    public String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public static int isLoggedIn = 0;
    static Scanner scanner = new Scanner(System.in);

    public void authenticationMenu() {
        Homepage home = new Homepage();
        int opt3;
        do {
            clearConsole();
            System.out.println("\n\n---------------------Authentication system---------------------");
            System.out.println("\t\t\t-We value your privacy!\n\n");
            System.out.println("1. Sign up");
            System.out.println("2. Log in");
            System.out.println("3. Back");
            System.out.println("4. Exit");
            System.out.print("\nChoose your operation: ");
            opt3 = scanner.nextInt();
            scanner.nextLine();

            switch (opt3) {
                case 1:
                    register();
                    System.out.println(
                            "\n\nPress 1 to log in now\nor, 2 to back to authentication page\nor, 3 to back to homepage\nor, 0 to exit: ");
                    int opt3_1 = scanner.nextInt();
                    if (opt3_1 == 1) {
                        login();
                    } else if (opt3_1 == 0) {
                        return;
                    }
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    home.displayMenu();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    delay();
                    home.choice = 0;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
                    break;
            }
        } while (opt3 <= 3);
    }

    public void register() {
        try {
            clearConsole();
            System.out.println("\n\n---------------------User Registration---------------------");
            System.out.println("\t\t\t-We value your privacy!\n\n");

            FileWriter writer = new FileWriter("users.txt", true); // Appending to the file
            BufferedWriter bufferWriter = new BufferedWriter(writer);

            System.out.println("\n\t\t--- User Registration ---");
            System.out.print("Enter your first name: ");
            String userfname = scanner.next();
            System.out.print("Enter your last name: ");
            String userlname = scanner.next();
            System.out.print("Enter username: ");
            String username = scanner.next();
            System.out.print("Enter DIU student mail: ");
            String mail = scanner.next();
            System.out.print("Enter your phone number: ");
            String phn = scanner.next();
            System.out.print("Enter student ID: ");
            String id = scanner.next();

            System.out.print("Enter password: ");
            String password = scanner.next();
            System.out.print("\nConfirm your password: ");
            String password2 = scanner.next();

            if (password.equals(password2)) {
                bufferWriter.write(userfname + "," + userlname + "," + username + "," + mail + "," + phn + "," + id
                        + "," + password + "\n");
                bufferWriter.close();
                System.out.println("\n\nUser registration successful, Your username is " + username);
                setUsername(username);

            }

            else {
                System.out.println("\n\nPassword do not match.");
                System.out.println("\nPlease complete the process carefully.\n\n");
                register();

            }

        } catch (IOException e) {
            System.out.println("An error occurred during registration.");
            e.printStackTrace();
        }
    }

    public void login() {
        try {
            clearConsole();
            System.out.println("\n\n---------------------User Login---------------------");
            System.out.println("\t\t\t-We value your privacy!\n\n");

            System.out.print("Enter username: ");
            String lusername = scanner.next();

            System.out.print("Enter password: ");
            String lpassword = scanner.next();

            File file = new File("users.txt");
            Scanner fileScanner = new Scanner(file);

            int isLoggedIn = 0;

            while (fileScanner.hasNextLine()) {
                String data = fileScanner.nextLine();
                String[] userDetails = data.split(",");

                if (userDetails.length >= 7) {
                    if (userDetails[2].equals(lusername) && userDetails[6].equals(lpassword)) {
                        isLoggedIn = 1;
                        break;
                    }
                }
            }

            fileScanner.close();

            if (isLoggedIn == 1) {
                System.out.println("\n\nLogin successful!");

                System.out.println("Do you want to order now???\n\t\t1.Yes\n\t\t2.No");
                int opt_3_2 = scanner.nextInt();
                OrderNow order = new OrderNow();

                if (opt_3_2 == 1) {
                    order.orderNow();
                }

            } else {
                System.out.println("\n\nInvalid username or password.");
                login();
            }
        } catch (FileNotFoundException e) {
            System.out.println("\n\nUser database file not found.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
