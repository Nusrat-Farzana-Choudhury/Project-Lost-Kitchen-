import java.util.Scanner;
public class Homepage{
    private int choice;

    public int getChoice() {
        return choice;
    }
    public void setChoice(int choice){
        this.choice = choice;
    }

    public void displayMenu() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n\n\t\t\t\t\t\t\t\t\t\tWelcome to\n");
            System.out.println("\t\t\t\t\t\t\t\t\t\t----------LOST KITCHEN-------------\n");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t-Where every flavor tells a story\n\n\n");
            System.out.println("1. About us");
            System.out.println("2. User guides");
            System.out.println("3. Register/Log in");
            System.out.println("4. Order now!");
            System.out.println("5. Hot deals!!!");
            System.out.println("6. FAQs");
            System.out.println("7. Review");
            System.out.println("8. Exit");
            System.out.print("\n\nEnter your choice: ");
            choice = scanner.nextInt();
            scanner.close();
        }
    }
