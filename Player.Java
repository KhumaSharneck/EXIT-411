import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public boolean hasItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equals(itemName.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public void displayInventory() {
        if (items.isEmpty()) {
            System.out.println("Your inventory is empty.");
            return;
        }

        System.out.println("Inventory:");
        for (Item item : items) {
            System.out.println("- " + item.getDisplayName() + ": " + item.getDescription());
        }
    }
}