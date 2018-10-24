package worldofzuul;

public class Game 
{
    private Parser parser;
    private Room currentRoom;
        

    public Game() 
    {
        createRooms();
        parser = new Parser();
    }


    private void createRooms()
    {
        Room start, r1M, r2C, r3M, r4M, r5C, r6M, r7M, r8C, r9M;
        Room r10C, r11M, r12M, r13M, r14C, r15M, r16M, r17M, r18C, r19M;
        Room r20M, r21C, r22X, r23X, r24X, r25X, r26X, r27X, r28X, r29X;
        Room r30X, r31X, r32X, r33X, r34X, r35X, r36X, r37X, r38X, r39X;
        Room r40X, r41X, r42X, r43X, r44X, r45X, r46X, r47X, r48X, r49X;
        Room r50X, r51X, r52X, r53X, r54X, r55X, r56X, r57X, r58X, r59X;
        
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
        /*
        rXXX = new Room("");
        rXXX = new Room("");
        rXXX = new Room("");
        rXXX = new Room("");
        rXXX = new Room("");
        rXXX = new Room("");
        */
        
        start.setExit("south", r1M);
        
        r1M.setExit("north", start);
        r1M.setExit("south", r3M);
        r1M.setExit("east", r2C);
        
        r2C.setExit("west", r1M);
        r2C.setExit("east", r4M);
        
        r3M.setExit("north", r1M);
        r3M.setExit("down", r5C);
       
        r4M.setExit("west", r2C);
        
        r5C.setExit("", r6M);
        r5C.setExit("", r7M);
        r5C.setExit("", r8C);
        
        r6M.setExit("", r5C);
        
        r7M.setExit("", r5C);
        r7M.setExit("", r11M);
        r7M.setExit("", r19M);
        
        
        
        //rxx.setExit("", null);
        
        currentRoom = start;
    }

    public void play() 
    {            
        printWelcome();

                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        return wantToQuit;
    }

    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;
        }
    }
}
