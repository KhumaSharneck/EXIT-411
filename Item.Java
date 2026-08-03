import java.util.Scanner;

public class Game {

    private boolean running;
    private Scanner scanner;
    private Player player;
    private DungeonMap dungeonMap;
    private CommandParser commandParser;

    public Game() {
        running = true;
        scanner = new Scanner(System.in);
        player = new Player(1, 1);
        dungeonMap = new DungeonMap();
        commandParser = new CommandParser();

        dungeonMap.revealRoom(player.getX(), player.getY());
    }

    public void start() {
        System.out.println("=================================");
        System.out.println("            EXIT 411");
        System.out.println("=================================");
        System.out.println("You wake up in a dark facility.");
        System.out.println("Find the keycard and escape through Exit 411.");
        System.out.println();

        describeCurrentRoom();

        while (running) {
            System.out.print("> ");
            String input = commandParser.parse(scanner.nextLine());

            handleCommand(input);
        }
    }

    private void handleCommand(String input) {
        switch (input) {
            case "north":
                movePlayer(0, -1);
                break;

            case "south":
                movePlayer(0, 1);
                break;

            case "east":
                movePlayer(1, 0);
                break;

            case "west":
                movePlayer(-1, 0);
                break;

            case "look":
                describeCurrentRoom();
                break;

            case "map":
                dungeonMap.displayMap(player);
                break;

            case "take":
                takeItem();
                break;

            case "inventory":
                player.getInventory().displayInventory();
                break;

            case "health":
                System.out.println("Health: " + player.getHealth());
                break;

            case "help":
                showHelp();
                break;

            case "quit":
                System.out.println("Exiting game...");
                running = false;
                break;

            default:
                System.out.println("Invalid command. Type 'help' to see available commands.");
                break;
        }
    }

    private void movePlayer(int dx, int dy) {
        int newX = player.getX() + dx;
        int newY = player.getY() + dy;

        Room nextRoom = dungeonMap.getRoom(newX, newY);

        if (nextRoom == null) {
            System.out.println("You cannot move that way.");
            return;
        }

        if (nextRoom.isExitRoom() && !player.getInventory().hasItem("keycard")) {
            System.out.println("Exit 411 is locked. You need a keycard.");
            return;
        }

        if (dx == 1) {
            player.moveEast();
        } else if (dx == -1) {
            player.moveWest();
        } else if (dy == 1) {
            player.moveSouth();
        } else if (dy == -1) {
            player.moveNorth();
        }

        dungeonMap.revealRoom(player.getX(), player.getY());
        describeCurrentRoom();
        checkCurrentRoomEffects();

        if (nextRoom.isExitRoom()) {
            System.out.println("The keycard works.");
            System.out.println("You found Exit 411. You escaped.");
            running = false;
        }
    }

    private void checkCurrentRoomEffects() {
        Room currentRoom = dungeonMap.getRoom(player.getX(), player.getY());

        if (currentRoom.isTrapRoom() && !currentRoom.hasTrapTriggered()) {
            System.out.println("A floor panel snaps beneath your foot.");
            System.out.println("You are hit by a burst of exposed wiring.");

            player.takeDamage(25);
            currentRoom.triggerTrap();

            System.out.println("Health: " + player.getHealth());

            if (player.isDead()) {
                System.out.println("You collapsed before reaching Exit 411.");
                running = false;
            }
        }
    }

    private void takeItem() {
        Room currentRoom = dungeonMap.getRoom(player.getX(), player.getY());

        if (!currentRoom.hasItem()) {
            System.out.println("There is nothing to take here.");
            return;
        }

        Item item = currentRoom.takeItem();
        player.getInventory().addItem(item);

        System.out.println("You picked up: " + item.getDisplayName());
    }

    private void describeCurrentRoom() {
        Room currentRoom = dungeonMap.getRoom(player.getX(), player.getY());

        System.out.println();
        System.out.println(currentRoom.getName());
        System.out.println(currentRoom.getDescription());

        if (currentRoom.hasItem()) {
            System.out.println("You see a " + currentRoom.getItem().getDisplayName() + ".");
        }

        System.out.println();
    }

    private void showHelp() {
        System.out.println("Commands:");
        System.out.println("north, south, east, west");
        System.out.println("n, s, e, w");
        System.out.println("go north, go south, go east, go west");
        System.out.println("look, map, take, inventory, health, help, quit");
    }
}