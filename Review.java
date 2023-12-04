import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Review extends Control {
    String review = "";

    public void reviews() {
        clearConsole();
        Scanner scanner = new Scanner(System.in);
        UserRegistrationLogin user = new UserRegistrationLogin();
        try (FileWriter writer = new FileWriter("reviews.txt", true)) {
            BufferedWriter bufferWriter = new BufferedWriter(writer);

            System.out.println("\n\n\t\t\t\t\t\t\t\t\t\t--------------------Review--------------------\n");
            System.out.println(
                    "\t\t\t\t\t\t\t\t\t\t\t-Reflection enables us to evaluate the experience,\n\t\t\t\t\t\t\t\t\t\t\t\tlearn from mistakes, repeat success\n\n\n");
            System.out.println(
                    "Rate your experience with our service:\n\t1. Worst\n\t2. Bad\n\t3. Fair\n\t4. Good\n\t5. Excellent\n\nEnter your choice: ");
            int choice7 = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after reading the integer

            System.out.print("\n\nWanna tell more about your experience?\n\t1. Yes\n\t2. No\n\tEnter your choice: ");
            int choiceMoreInfo = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after reading the integer

            if (choiceMoreInfo == 1) {
                System.out.println("\nWrite here about your experience:");
                review = scanner.nextLine();

            }
            bufferWriter.write(user.username + "," + choice7 + "," + review + "\n");
            bufferWriter.close();
            if (choice7 == 7)
                System.out.println(
                        "\nGreetings from Lost Kitchen! We've received your feedback about our service.\n\n\n\t\t\t\t\t\t\t\t\t\t-----------(: Thanks for staying with us :)-----------");
        } catch (IOException e) {

            e.printStackTrace();
        }

    }
}
