package customer_owner;

import java.util.*;

public class Operations {

    public static void OwnerOperations(Owner owner) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n---- OWNER OPERATIONS ----");
            System.out.println("1) Add Food Item");
            System.out.println("2) Remove Food Item");
            System.out.println("3) Update Price");
            System.out.println("4) Display Menu");
            System.out.println("5) Exit");

            byte choice = sc.nextByte();
            sc.nextLine();  // FIX newline issue

            String foodItem;
            float price;

            switch (choice) {
            case 1:
                System.out.print("Enter food name: ");
                foodItem = sc.nextLine();

                System.out.print("Enter price: ");
                price = sc.nextFloat();

                owner.addItem(foodItem, price);
                System.out.println("Added successfully.");
                break;

            case 2:
                System.out.print("Enter food to remove: ");
                foodItem = sc.next();

                if (owner.deleteItem(foodItem))
                    System.out.println("Removed successfully.");
                else
                    System.out.println("Not found.");
                break;

            case 3:
                System.out.print("Enter food to update: ");
                foodItem = sc.next();

                if (owner.menu.containsKey(foodItem)) {
                    System.out.print("Enter new price: ");
                    price = sc.nextFloat();
                    owner.update(foodItem, price);
                    System.out.println("Updated.");
                } else {
                    System.out.println("Not found.");
                }
                break;

            case 4:
                owner.displayMenu();
                break;

            case 5:
                return;

            default:
                System.out.println("Invalid choice");
            }
        }
    }

    public static void CustomerOperations(Customer customer) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n---- CUSTOMER OPERATIONS ----");
            System.out.println("1) Display Menu");
            System.out.println("2) Order Food");
            System.out.println("3) Remove Food");
            System.out.println("4) Update Quantity");
            System.out.println("5) Display Order");
            System.out.println("6) Pay Bill");
            System.out.println("7) Exit");

            byte choice = sc.nextByte();
            sc.nextLine(); // FIX

            String foodItem;
            int qty;

            switch (choice) {
            case 1:
                customer.displayMenu();
                break;

            case 2:
                System.out.print("Enter food: ");
                foodItem = sc.next();

                if (Customer.menu.containsKey(foodItem)) {
                    System.out.print("Enter quantity: ");
                    qty = sc.nextInt();
                    customer.orderFood(foodItem, qty);
                    System.out.println("Added to order.");
                } else {
                    System.out.println("Item not available.");
                }
                break;

            case 3:
                System.out.print("Enter food to remove: ");
                foodItem = sc.next();

                if (customer.removeFood(foodItem))
                    System.out.println("Removed.");
                else
                    System.out.println("Not in order.");
                break;

            case 4:
                System.out.print("Enter food to update: ");
                foodItem = sc.next();

                System.out.print("Enter quantity: ");
                qty = sc.nextInt();

                if (customer.update(foodItem, qty))
                    System.out.println("Updated.");
                else
                    System.out.println("Item not in order.");
                break;

            case 5:
                customer.displayOrder();
                break;

            case 6:
                System.out.println("Total Amount = ₹" + customer.totalBill());
                break;

            case 7:
                return;

            default:
                System.out.println("Invalid choice");
            }
        }
    }
}
