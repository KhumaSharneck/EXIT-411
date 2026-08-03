public class DungeonMap {

    private Room[][] rooms;

    public DungeonMap() {
        rooms = new Room[3][3];
        createRooms();
    }

    private void createRooms() {
        rooms[0][0] = new Room("Storage Cell", "Dusty crates line the walls.", false);
        rooms[0][1] = new Room("Broken Corridor", "The lights flicker above you.", false);
        rooms[0][2] = new Room("Generator Room", "A damaged generator hums weakly.", false);

        rooms[1][0] = new Room("Medical Bay", "Old medical supplies are scattered around.", false);
        rooms[1][1] = new Room("Starting Room", "You woke up here.", false);
        rooms[1][2] = new Room("Security Office", "Screens show static.", false);

        rooms[2][0] = new Room("Armoury", "Empty weapon racks cover the walls.", false);
        rooms[2][1] = new Room("Maintenance Tunnel", "Pipes hiss in the darkness.", false);
        rooms[2][2] = new Room("Exit 411", "A sealed exit door stands ahead.", true);

        rooms[1][2].setItem(new Item("keycard", "A damaged security keycard labelled EXIT ACCESS."));

        rooms[0][2].setTrapRoom(true);
    }

    public Room getRoom(int x, int y) {
        if (x < 0 || x >= 3 || y < 0 || y >= 3) {
            return null;
        }

        return rooms[y][x];
    }

    public void revealRoom(int x, int y) {
        Room room = getRoom(x, y);

        if (room != null) {
            room.discover();
        }
    }

    public void displayMap(Player player) {

        System.out.println();
        System.out.println("Map:");

        for (int y = 0; y < 3; y++) {

            for (int x = 0; x < 3; x++) {

                if (player.getX() == x && player.getY() == y) {

                    System.out.print("[P] ");

                } else if (rooms[y][x].isDiscovered()) {

                    System.out.print("[" + rooms[y][x].getName() + "] ");

                } else {

                    System.out.print("[?] ");
                }
            }

            System.out.println();
        }

        System.out.println();
    }
}