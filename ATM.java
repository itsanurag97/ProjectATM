import java.util.Scanner;
import java.util.InputMismatchException;

// ATM.java
public class ATM {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scn = new Scanner(System.in);

        while (true) {
            System.out.println("\nInsert Card: ");
            String cardName = scn.nextLine();  // Input for class name (e.g., SBIBankCard)

            try {
                // Load the card class dynamically
                Class<?> cls = Class.forName(cardName);
		//Object obj = cls.newInstance(); // Old method Deprecated, used as per your code

                // Instantiate the card object using modern method
                Object obj = cls.getDeclaredConstructor().newInstance();

                // Ensure the card implements ATMCard interface
                ATMCard card = (ATMCard) obj;

                System.out.println("Card Reading is complete successfully\n");
                System.out.println("Start your Transaction ");

                loop:
                while (true) {
                    System.out.println("\nChoose an option:");
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Balance Enquiry");
                    System.out.println("4. Exit");
                    System.out.print("Enter option number : ");
                    int option;
                    try {
                        option = scn.nextInt();
                        scn.nextLine(); // Clear newline character
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a number.");
                        scn.nextLine(); // Clear wrong input
                        continue;
                    }

                    switch (option) {
                        case 1:
                            while (true) {
                                try {
                                    System.out.print("Enter amount for deposit: ");
                                    double amt = scn.nextDouble();
                                    scn.nextLine();
                                    card.deposit(amt);
                                    System.out.println(amt + " Amount Credited Successfully");
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input. Please enter a valid number.");
                                    scn.nextLine();
                                } catch (NegativeAmountException e) {
                                    System.out.println("Error: " + e.getMessage());
                                }
                            }
                            break;

                        case 2:
                            while (true) {
                                try {
                                    System.out.print("Enter amount for withdraw: ");
                                    double amt = scn.nextDouble();
                                    scn.nextLine();
                                    card.withdraw(amt);
                                    System.out.println(amt + " Amount Debited Successfully");
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input. Please enter only numbers.");
                                    scn.nextLine();
                                } catch (NegativeAmountException | InsufficientFundsException e) {
                                    System.out.println("Error: " + e.getMessage());
                                }
                            }
                            break;

                        case 3:
                            card.currentBalance();
                            break;

                        case 4:
                            System.out.println("Thank you. Please visit again...");
                            break loop;

                        default:
                            System.out.println("Invalid option. Please choose 1 to 4.");
                    }
                }

            } catch (ClassNotFoundException e) {
                System.out.println("Card not recognized. Please insert a valid card.");
            } catch (InstantiationException | IllegalAccessException e) {
                System.out.println("Card initialization failed: " + e.getMessage());
            } catch (ClassCastException e) {
                System.out.println("Inserted card doesn't implement ATMCard interface.");
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }
}
