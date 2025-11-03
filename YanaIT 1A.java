
		import java.util.Scanner;

public class StudentLogin {
    static String[][] accounts = new String[5][2]; // username and password
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== STUDENT LOGIN MENU ===");
            System.out.println("1. Log in");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear input

            if (choice == 1) {
                register(sc);
            } else if (choice == 2) {
                login(sc);
            } else if (choice == 0) {
                System.out.println("Thank you for using this system!");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        sc.close();
    }

    static void register(Scanner sc) {
        if (count >= accounts.length) {
            System.out.println("User limit reached.");
            return;
        }

        System.out.print("Enter your username: ");
        String user = sc.nextLine();

        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        System.out.print("Confirm your  password: ");
        String confirm = sc.nextLine();

        if (!pass.equals(confirm)) {
            System.out.println("Wrong Password");
            return;
        }

        accounts[count][0] = user;
        accounts[count][1] = pass;
        count++;

        System.out.println(" Welcome, Please Proced on the Registration menu!");
    }

    static void login(Scanner sc) {
        System.out.print("Enter username: ");
        String user = sc.nextLine();

        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (accounts[i][0].equals(user) && accounts[i][1].equals(pass)) {
                System.out.println("Welcome Registration Successful" + user + "!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Wrong username or password.");
        }
    }
}
