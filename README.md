public class Room {

    private String name;
    private String description;
    private boolean exitRoom;
    private boolean discovered;
    private boolean trapRoom;
    private boolean trapTriggered;
    private Item item;

    public Room(String name, String description, boolean exitRoom) {
        this.name = name;
        this.description = description;
        this.exitRoom = exitRoom;
        this.discovered = false;
        this.trapRoom = false;
        this.trapTriggered = false;
        this.item = null;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isExitRoom() {
        return exitRoom;
    }

    public boolean isDiscovered() {
        return discovered;
    }

    public void discover() {
        discovered = true;
    }

    public void setTrapRoom(boolean trapRoom) {
        this.trapRoom = trapRoom;
    }

    public boolean isTrapRoom() {
        return trapRoom;
    }

    public boolean hasTrapTriggered() {
        return trapTriggered;
    }

    public void triggerTrap() {
        trapTriggered = true;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public boolean hasItem() {
        return item != null;
    }

    public Item takeItem() {
        Item collectedItem = item;
        item = null;
        return collectedItem;
    }
}