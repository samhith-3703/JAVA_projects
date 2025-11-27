package customer_owner;

import java.util.*;

public class Customer {

    public static HashMap<String, Float> menu;  // shared menu
    private HashMap<String, Integer> order = new HashMap<>();

    public void setMenu(HashMap<String, Float> sharedMenu) {
        menu = sharedMenu;
    }

    public void displayMenu() {
        if (menu == null || menu.isEmpty()) {
            System.out.println("Menu is empty.");
        } else {
            System.out.println("------ MENU ------");
            menu.forEach((k, v) -> System.out.println(k + " : ₹" + v));
        }
    }

    public boolean orderFood(String item, int qty) {
        if (!menu.containsKey(item))
            return false;

        order.put(item, order.getOrDefault(item, 0) + qty);
        return true;
    }

    public boolean removeFood(String item) {
        return order.remove(item) != null;
    }

    public boolean update(String item, int qty) {
        if (order.containsKey(item)) {
            order.put(item, qty);
            return true;
        }
        return false;
    }

    public void displayOrder() {
        if (order.isEmpty()) {
            System.out.println("No items ordered.");
            return;
        }

        order.forEach((k, v) -> 
            System.out.println(k + " x " + v + " = ₹" + (menu.get(k) * v)));
    }

    public float totalBill() {
        float total = 0;

        for (String item : order.keySet()) {
            total += menu.get(item) * order.get(item);
        }

        return total;
    }
}

