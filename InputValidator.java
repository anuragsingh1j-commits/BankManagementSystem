package util;

import java.util.Scanner;

public class InputValidator {

    private InputValidator() {
        // Prevent object creation
    }

    public static int readInt(Scanner sc, String message) {

        while (true) {

            System.out.print(message);

            if (sc.hasNextInt()) {

                int value = sc.nextInt();
                sc.nextLine();

                if (value > 0) {
                    return value;
                }

                System.out.println("Value must be greater than zero.");
            } else {

                System.out.println("Invalid input. Please enter a valid integer.");
                sc.next();
            }
        }
    }

    public static double readAmount(Scanner sc, String message) {

        while (true) {

            System.out.print(message);

            if (sc.hasNextDouble()) {

                double value = sc.nextDouble();
                sc.nextLine();

                if (value > 0) {
                    return value;
                }

                System.out.println("Amount must be greater than zero.");
            } else {

                System.out.println("Invalid amount.");
                sc.next();
            }
        }
    }

    public static String readString(Scanner sc, String message) {

        while (true) {

            System.out.print(message);

            String value = sc.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println("Input cannot be empty.");
        }
    }

    public static String readPhone(Scanner sc, String message) {

        while (true) {

            System.out.print(message);

            String phone = sc.nextLine().trim();

            if (phone.matches("\\d{10}")) {
                return phone;
            }

            System.out.println("Phone number must contain exactly 10 digits.");
        }
    }

    public static String readEmail(Scanner sc, String message) {

        while (true) {

            System.out.print(message);

            String email = sc.nextLine().trim();

            if (email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                return email;
            }

            System.out.println("Invalid email address.");
        }
    }
}