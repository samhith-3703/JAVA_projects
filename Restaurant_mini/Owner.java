package customer_owner;

import java.util.*;

public class Owner {

    public HashMap<String, Float> menu = new HashMap<>();

    private String username = "admin";
    private String password = "1234";

    public boolean authorize(String uname, String pwd) {
        return username.equals(uname) && password.equals(pwd);
    }

    public boolean addItem(String item, float price) {
        menu.put(item, price);
        return true;
    }

    public boolean deleteItem(String item) {
        return menu.remove(item) != null;
    }

    public boolean update(String item, float price) {
        if (menu.containsKey(item)) {
            menu.put(item, price);
            return true;
        }
        return false;
    }

    public void displayMenu() {
        if (menu.isEmpty()) {
            System.out.println("Menu is empty.");
        } else {
            System.out.println("------ MENU ------");
            menu.forEach((k, v) -> System.out.println(k + " : ₹" + v));
        }
    }
}
