package worldofzuul;

public class Game {

    private Parser parser;
    private Room currentRoom;

    public Game() {
        createRooms();
        parser = new Parser();
    }

    private void createRooms() {
        Room start, r1M, r2C, r3M, r4M, r5C, r6M, r7M, r8C, r9M;
        Room r10C, r11M, r12M, r13M, r14C, r15M, r16M, r17M, r18C, r19M;
        Room r20M, r21C, r22M, r23M, r24C, r25C, r26M, r27M, r28M, r29M;
        Room r30C, r31M, r32M, r33M, r34M, r35M, r36M, r37M, r38M, r39M;
        Room r40C;

        start = new Room("standing outside the ugly house");
        r1M = new Room("meeting a mighty monster, a slime who is level 1");
        r2C = new Room("getting hit by a CURSE, you loose your weapon");
        r4M = new Room("smelling something awful, it is a golbin that hasn't showered!");
        r3M = new Room("kicking in a find a dragon! He is so muscular!");
        r5C = new Room("falling down into the dungeon, you are stuck in the dungeon now");
        r6M = new Room("");
        r7M = new Room("");
        r8C = new Room("");
        r9M = new Room("");
        r10C = new Room("");
        r11M = new Room("");
        r12M = new Room("");
        r13M = new Room("");
        r14C = new Room("");
        r15M = new Room("");
        r16M = new Room("");
        r17M = new Room("");
        r18C = new Room("");
        r19M = new Room("");
        r20M = new Room("");
        r21C = new Room("");
        r22M = new Room("");
        r23M = new Room("");
        r24C = new Room("");
        r25C = new Room("");
        r26M = new Room("");
        r27M = new Room("");
        r28M = new Room("");
        r29M = new Room("");
        r30C = new Room("");
        r31M = new Room("");
        r32M = new Room("");
        r33M = new Room("");
        r34M = new Room("");
        r35M = new Room("");
        r36M = new Room("");
        r37M = new Room("");
        r38M = new Room("");
        r39M = new Room("");
        r40C = new Room("");

        start.setExit("south", r1M);

        r1M.setExit("north", start);
        r1M.setExit("south", r3M);
        r1M.setExit("east", r2C);

        r2C.setExit("west", r1M);
        r2C.setExit("east", r4M);

        r3M.setExit("north", r1M);
        r3M.setExit("down", r5C);

        r4M.setExit("west", r2C);

        r5C.setExit("west", r6M);
        r5C.setExit("south", r7M);
        r5C.setExit("east", r8C);

        r6M.setExit("east", r5C);

        r7M.setExit("north", r5C);
        r7M.setExit("south", r11M);
        r7M.setExit("west", r19M);

        r8C.setExit("west", r5C);
        r8C.setExit("east", r9M);

        r9M.setExit("west", r8C);
        r9M.setExit("south", r10C);
        r9M.setExit("east", r12M);

        r10C.setExit("north", r9M);
        r10C.setExit("south", r16M);

        r11M.setExit("north", r7M);
        r11M.setExit("east", r14C);

        r12M.setExit("north", r13M);
        r12M.setExit("west", r9M);
        r12M.setExit("east", r40C);

        r13M.setExit("south", r12M);

        r14C.setExit("west", r11M);
        r14C.setExit("south", r15M);

        r15M.setExit("north", r14C);
        r15M.setExit("south", r23M);

        r16M.setExit("north", r10C);
        r16M.setExit("east", r17M);

        r17M.setExit("west", r16M);
        r17M.setExit("south", r18C);

        r18C.setExit("north", r17M);
        r18C.setExit("south", r20M);
        r18C.setExit("east", r28M);

        r19M.setExit("east", r7M);
        r19M.setExit("south", r21C);

        r20M.setExit("north", r18C);
        r20M.setExit("west", r22M);

        r21C.setExit("north", r19M);
        r21C.setExit("south", r33M);

        r22M.setExit("east", r20M);
        r22M.setExit("west", r23M);
        r22M.setExit("south", r37M);

        r23M.setExit("north", r15M);
        r23M.setExit("east", r22M);
        r23M.setExit("west", r24C);
        r23M.setExit("south", r25C);

        r24C.setExit("east", r23M);
        r24C.setExit("sout", r26M);

        r25C.setExit("north", r23M);
        r25C.setExit("west", r26M);

        r26M.setExit("north", r24C);
        r26M.setExit("east", r25C);
        r26M.setExit("south", r27M);

        r27M.setExit("north", r26M);
        r27M.setExit("south", r29M);
        r27M.setExit("west", r39M);

        r28M.setExit("west", r18C);
        r28M.setExit("south", r34M);

        r29M.setExit("north", r27M);
        r29M.setExit("east", r30C);

        r30C.setExit("west", r29M);
        r30C.setExit("south", r31M);
        r30C.setExit("east", r33M);

        r31M.setExit("north", r30C);

        r32M.setExit("west", r30C);

        r33M.setExit("north", r21C);
        r33M.setExit("south", r35M);

        r34M.setExit("north", r28M);
        r34M.setExit("south", r26M);

        r35M.setExit("north", r33M);
        r35M.setExit("south", r38M);

        r36M.setExit("north", r34M);

        r37M.setExit("north", r22M);

        r38M.setExit("north", r35M);
        r38M.setExit("south", r39M);

        r39M.setExit("north", r38M);
        r39M.setExit("east", r27M);

        r40C.setExit("west", r12M);
        //rxx.setExit("", null);

        currentRoom = start;
    }

    public void play() {
        printWelcome();

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if (commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        } else if (commandWord == CommandWord.GO) {
            goRoom(command);
        } else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        return wantToQuit;
    }

    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }
}
