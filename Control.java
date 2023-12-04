import java.util.Scanner;

public class Control {
    // Function to clear the console screen (simulating system("cls"))
    public void clearConsole() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void delay() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void backOrExit() {
        Homepage home = new Homepage();
        Scanner scanner = new Scanner(System.in);

        System.out.print("\n\nPress 1 to go back to homepage or 0 to exit: ");
        int opt1 = scanner.nextInt();

        if (opt1 == 1) {
            clearConsole();
            home.displayMenu();
        } else {
            home.choice = 0;
        }

    }

}
