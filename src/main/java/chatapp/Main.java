package chatapp;

import java.util.Scanner;

public class Main {

    private static String promptValidUsername(Scanner input, Login login) {
        while (true) {
            System.out.print("Enter username: ");
            String username = input.nextLine();
            System.out.println(login.getUsernameValidationMessage(username));

            if (login.checkUserName(username)) {
                return username;
            }
        }
    }

    private static String promptValidPassword(Scanner input, Login login) {
        while (true) {
            System.out.print("Enter password: ");
            String password = input.nextLine();
            System.out.println(login.getPasswordValidationMessage(password));

            if (login.checkPasswordComplexity(password)) {
                return password;
            }
        }
    }

    private static String promptValidCellNumber(Scanner input, Login login) {
        while (true) {
            System.out.print("Enter cellphone number: ");
            String cellNumber = input.nextLine();
            System.out.println(login.getCellPhoneValidationMessage(cellNumber));

            if (login.checkCellPhoneNumber(cellNumber)) {
                return cellNumber;
            }
        }
    }

    private static void registerUser(Scanner input, Login login) {
        System.out.println("\n=== REGISTER ===");
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        String username = promptValidUsername(input, login);
        String password = promptValidPassword(input, login);
        String cellNumber = promptValidCellNumber(input, login);

        System.out.println(login.registerUser(firstName, lastName, username, password, cellNumber));
    }

    private static void loginUser(Scanner input, Login login) {
        System.out.println("\n=== LOGIN ===");
        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        boolean loginSuccess = login.loginUser(username, password);
        System.out.println(login.returnLoginStatus(loginSuccess));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Login login = new Login();
        boolean running = true;

        while (running) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            String option = input.nextLine();

            if ("1".equals(option)) {
                registerUser(input, login);
            } else if ("2".equals(option)) {
                loginUser(input, login);
            } else if ("3".equals(option)) {
                System.out.println("Goodbye.");
                running = false;
            } else {
                System.out.println("Invalid option.");
            }
        }

        input.close();
    }
}
