package customer_owner;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Owner owner = new Owner();
        Customer customer = new Customer();

        // IMPORTANT: Share same menu
        customer.setMenu(owner.menu);

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n------WELCOME TO RESTAURANT------");
            System.out.println("1) Owner");
            System.out.println("2) Customer");
            System.out.println("3) Exit");

            byte loginAs = sc.nextByte();

            switch (loginAs) {

            case 1:
                System.out.println("Enter username:");
                String uname = sc.next();

                System.out.println("Enter password:");
                String pwd = sc.next();

                if (owner.authorize(uname, pwd)) {
                    Operations.OwnerOperations(owner);
                } else {
                    System.out.println("Invalid login.");
                }
                break;

            case 2:
                Operations.CustomerOperations(customer);
                break;

            case 3:
                System.out.println("Exiting...");
                return;

            default:
                System.out.println("Invalid choice.");
            }
        }
    }
}
