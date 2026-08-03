public class CommandParser {

    public String parse(String input) {

        if (input == null) {
            return "";
        }

        input = input.toLowerCase().trim();

        if (input.equals("n")) {
            return "north";
        }

        if (input.equals("s")) {
            return "south";
        }

        if (input.equals("e")) {
            return "east";
        }

        if (input.equals("w")) {
            return "west";
        }

        if (input.startsWith("go ")) {
            return input.substring(3).trim();
        }

        if (input.equals("i")) {
            return "inventory";
        }

        if (input.equals("inv")) {
            return "inventory";
        }

        return input;
    }
}