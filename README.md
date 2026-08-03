# EXIT 411

A Java-based text adventure game developed using Object-Oriented Programming (OOP) principles.

The player wakes up inside a dark abandoned facility and must explore different rooms, survive hazards, locate a security keycard and escape through Exit 411.

---

## Features

- Text-based command system
- 3x3 dungeon exploration
- Room discovery and map tracking
- Inventory system
- Collectable keycard
- Locked exit puzzle
- Health and trap system
- Boundary checking
- Help and utility commands
- Modular Object-Oriented design

---

## Commands

| Command | Description |
|----------|-------------|
| `north`, `south`, `east`, `west` | Move between rooms |
| `n`, `s`, `e`, `w` | Short movement commands |
| `map` | Display discovered rooms |
| `take` | Pick up an item |
| `inventory` / `inv` | Display inventory |
| `health` | Show current health |
| `look` | Redisplay room description |
| `help` | Display available commands |
| `quit` | Exit the game |

---

## Gameplay Objective

The player must:

- Explore the abandoned facility
- Locate the security keycard
- Reach Exit 411
- Escape successfully

Some rooms contain traps which reduce the player's health.

---

## Technologies

- Java
- Object-Oriented Programming (OOP)
- Git
- GitLab

---

## Project Structure

| Class | Responsibility |
|------|----------------|
| Main | Starts the game |
| Game | Main game loop and command handling |
| Player | Stores player state and movement |
| Room | Represents each room |
| DungeonMap | Stores and displays the dungeon |
| Inventory | Stores collected items |
| Item | Represents collectable objects |
| CommandParser | Processes player commands |

---

## Object-Oriented Programming Concepts

### Encapsulation

Private fields are accessed through methods and getters.

Examples include:

- Player stores health and position
- Room stores descriptions, discovery state and traps

### Abstraction

Game logic is separated into reusable methods such as:

- `displayMap()`
- `moveNorth()`
- `handleCommand()`

### Modularity

Each class has a single responsibility, making the project easier to maintain and extend.

---

## Testing

The game was tested using a range of gameplay scenarios and edge cases.

| Feature | Result |
|----------|--------|
| Movement system | ✅ Passed |
| Boundary checking | ✅ Passed |
| Invalid command handling | ✅ Passed |
| Inventory system | ✅ Passed |
| Keycard pickup | ✅ Passed |
| Locked exit condition | ✅ Passed |
| Health and trap system | ✅ Passed |
| Map discovery system | ✅ Passed |

Testing confirmed that all core gameplay systems functioned correctly.

---

## Future Improvements

Potential future improvements include:

- Enemy AI using pathfinding algorithms
- Timed escape sequences
- Combat mechanics
- Procedural room generation
- Save/load functionality
- Graphical user interface
- Multiple endings
- Advanced puzzles and interactive objects

---

## Version Control

Git and GitLab were used throughout development to:

- Track changes
- Manage development progress
- Maintain project backups

---

## Compilation

Compile all Java source files:

```bash
javac src/*.java
```

If PowerShell wildcard expansion causes issues:

```bash
javac src/Main.java src/Game.java src/Player.java src/Room.java src/DungeonMap.java src/Inventory.java src/Item.java src/CommandParser.java
```

---

## Running the Project

```bash
java -cp src Main
```

---

## Skills Demonstrated

- Object-Oriented Programming
- Java Development
- Encapsulation
- Abstraction
- Modularity
- Command Parsing
- Collections
- File Structure Design
- Debugging & Testing
- Version Control with Git

---

## Author

**Khuma Sharneck**

Computer Science student at the University of Reading

Aspiring Software Engineer
