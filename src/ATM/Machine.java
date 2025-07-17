package ATM;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Machine {
    private static Map<String, Account> account = new HashMap<>();

    static {
        account.put("987654321", new Account("987654321", "9112", 50000));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome To ATM");
        System.out.print("Enter the AccountNumber : ");
        String accNo = sc.nextLine();

        if (account.containsKey(accNo)) {
            Account ac = account.get(accNo);
            System.out.print("Enter the Pincode : ");
            String pincode = sc.nextLine();
            if (ac.Authenticate(pincode)) {
                int choice;

                do {
                    System.out.println("\n1. Balance Check\n2. Withdraw\n3. Deposit\n4. Change PIN\n5. Exit");
                    System.out.print("Enter the choice ");
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.print("Balance " + ac.getBalance());

                            break;
                        case 2:
                            System.out.print("Withdraw");
                            ac.withdraw(sc.nextDouble());
                            break;
                        case 3:
                            System.out.print("Deposite ");
                            ac.deposit(sc.nextDouble());
                            break;
                        case 4:
                            sc.nextLine();
                            System.out.println("Change Pin");
                            ac.pinChange(sc.nextLine());
                            break;
                        case 5:
                            System.out.println("Thank you for using ATM");
                            break;
                        default:
                            System.out.println("Invalid option");
                    }

                } while (choice != 5);

            } else {
                System.out.println("Invalid Pin");
            }


        }


    }

}