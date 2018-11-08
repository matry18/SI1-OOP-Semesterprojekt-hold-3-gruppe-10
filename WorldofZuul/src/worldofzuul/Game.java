package worldofzuul;

public class Game {

    private Parser parser;
    private Room currentRoom;
    private Room previousRoom;
    Character bob = new Character();

    public Game() {
        createRooms();
        parser = new Parser();
    }

    private void createRooms() {
        Room start, r1M, r2C, r3M, r4M, r5C, r6M, r7M, r8C, r9M,
                r10C, r11M, r12M, r13M, r14C, r15M, r16M, r17M, r18C, r19M,
                r20M, r21C, r22M, r23M, r24C, r25C, r26M, r27M, r28M, r29M,
                r30C, r31M, r32M, r33M, r34M, r35M, r36M, r37M, r38M, r39M,
                r40C;

        //Creating the rooms
        start = new Room("standing outside the ugly house");
        r1M = new Room("");
        r2C = new Room("");
        r4M = new Room("");
        r3M = new Room("");
        r5C = new Room("");
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

        //Defining the rooms' layout
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

        //Define the curses in the rooms
        r2C.setCurse(new Curse("BAM WAM SLAM!", "You get hit and you do not know by what.", "Lose your weapon. If you don’t have any nothing happens."));
        r5C.setCurse(new Curse("Curse!", "Immortality removed. You are now on your own!... MUHAHAHA!", "You are trapped in the dungeon, the only way out is reaching level 10. Good Luck."));
        r8C.setCurse(new Curse("Fancy hat with feathers.", "The hat i fancy, because it got feathers!", "The hat removes any other head gear you are wearing and has no bonuses. The hat will stay on until a curse removes the hat."));
        r10C.setCurse(new Curse("E-tivity.", "A very difficult online activity, you rip your hair out of your head!", "Lose any current headgear, otherwise -1 level."));
        r14C.setCurse(new Curse("Harsh Language!", "A rat says something very unpleasant about your mother.", "Your moral is lowered. Attack -3 during next battle."));
        r18C.setCurse(new Curse("Shitter Twitter Trump!?", "He hacks your Twitter account and posts shit.", "You feel your IQ lowering. Lose 1 level."));
        r21C.setCurse(new Curse("Tiny Hands!", "Tiny hands comes flying toward you, they taking your weapon!", "Lose your weapon."));
        r24C.setCurse(new Curse("Rolling Stone!", "A huge round stone rolls towards you, INDIANA JONES STYLE!", "Lose your footgear and escape or be crushed and lose 1 level."));
        r25C.setCurse(new Curse("Duck of Doom!", "A menacing presence makes you shiver.", "Lose 1 level."));
        r30C.setCurse(new Curse("Josef F. Ritzl?!", "He invites you in to his cellar and locks you up.", "Lose 3 items or lose 2 levels."));
        r40C.setCurse(new Curse("Tar room.", "You jump into the room, only to find your feet getting stuck in the tar.", "Lose your footgear."));

        //Define the monsters in the rooms
        r1M.setMonster(new Monster("A Tiny Chicken.", "Still looking for his friend: Chicken Little.", 1, "Calls you a chicken."));
        r3M.setMonster(new Monster("'The Bully'", "He bullys you into submission(you notice a trap door behind him).", 4, "Lose your weapon."));
        r4M.setMonster(new Monster("Gobo the Goblin.", "Iiiiit’s Gobo everbody!", 1, "-1 next time you try to flee."));
        r6M.setMonster(new Monster("The Karate Squid.", "Makes sushi out of you. He will chop you up in small pieces!", 8, "His arm attacks you from behind. Lose 2 levels."));
        r7M.setMonster(new Monster("Larry the Cable Guy.", "+3 against Swagger Dagger.", 5, "You trip on his cable and get done. Lose 1 level."));
        r9M.setMonster(new Monster("Harry the Hairy Wizard.", "He whacks you with his wand.", 6, "He enchants you, making you grow hair all over your feet! Lose your footgear."));
        r11M.setMonster(new Monster("The Stoned Golem.", "He’s sooo stooned broo.", 7, "He falls over and lands on you left foot. Lose 1 level."));
        r12M.setMonster(new Monster("A group of 8378493.5 High Scool Students on Internship.", "They ask you questions with no relevance and you do not care about answering.", 10, "They talk to you, even during your lunch break, until you lay flat on the ground. Lose 1 level."));
        r13M.setMonster(new Monster("An Angry Gnome.", "He HATES!!! Christmas and he hates everybody who mentions Christmas… And he hates YOU!", 13, "He will suffocate you with rice porridge. Lose 2 levels."));
        r15M.setMonster(new Monster("A Dragon with Halitosis.", "It has periodontitis and it smells really bad.", 8, "The smell from his mouth alone kills you (figuratively). Lose 1 level."));
        r16M.setMonster(new Monster("Pelvin the Elf and his slightly less known brother Melvin.", "Pelvin and Melvin will continue each others sentences which irritates you a lot! You can not flee from this monster, you have to fight them.", 7, "They will include you in their debate club. Lose 2 levels."));
        r17M.setMonster(new Monster("Satan Claws.", "Due to a typo and dyslexia it is Satan Claws who has been summoned instead of Santa Claus", 10, "He will gore you with his horns. Lose 2 levels."));
        r19M.setMonster(new Monster("A Stubborn Crying Child.", "He’s had to much stewed apples and he’s not happy about it.", 4, "The baby throws its dirty diaper at you. Lose your armour."));
        r20M.setMonster(new Monster("Frodo the Fag.", "He will diss your choice of fashion.", 11, "He will see your attire as a fashion crime and take your armour as a punishment."));
        r22M.setMonster(new Monster("Curling Merlin.", "He will hit you with his curling rocks and they hurt like hell!", 12, "Lose your footwear and 1 level."));
        r23M.setMonster(new Monster("A Killer Rabbit.", "It has already slain a whole bunch of knights.", 15, "It kills you (figuratively). Lose 2 levels."));
        r26M.setMonster(new Monster("Trubadourix", "He will sing you a song... which sounds awful!", 14, "Your eardrums inflate so much that your headgear cease to be able to fit your head! Lose your headgear."));
        r27M.setMonster(new Monster("Katty Purry", "Great singer but gets distracted easily (typical cat stuff). -5 If you have the Vest of Rabbit Fur.", 18, "She deafens you with her cat wailing! Lose 2 levels."));
        r28M.setMonster(new Monster("Daft Vader", "He flails his arms around while wielding his red lightsaber, trying to intimidate you, while mumbling mumbo jumbo about some ‘force’.", 6, "He uses the force to choke your hand. Lose your weapon."));
        r29M.setMonster(new Monster("A Shrieking Geek from RobTech.", "He is a geek and it is infectious.", 19, "-1 to run away."));
        r31M.setMonster(new Monster("LEEEEEROYY JENKINSSSS.", "He rushes out of the room, yelling about whelplings. He leaves something behind.", 17, "Nothing, he is already gone."));
        r32M.setMonster(new Monster("Dorky Dragon of Doom.", "He tells stupid jokes, which are not funny at all. He bores you to death (figuratively).", 16, "Lose 2 levels."));
        r33M.setMonster(new Monster("The Doom Donuts.", "They have an affinity for everything with a 0 in it.", 7, "Lose 0 levels."));
        r34M.setMonster(new Monster("Topless Dancer.", "+2 if you have a weapon equipped.", 9, "She takes your headgear, not that she needs it."));
        r35M.setMonster(new Monster("The Great Cornholio!", "Hehehehh… Heheheheh.", 8, "You lose a level… or something."));
        r36M.setMonster(new Monster("Flying Surströmming.", "The smell is EVERYWHERE.", 12, "You throw up from the smell alone. Lose 3 levels."));
        r37M.setMonster(new Monster("G’huunies.", "They seem cute at first, but they just keep coming.", 11, "INFESTED -5 to next fight."));
        r38M.setMonster(new Monster("Moon Maidens.", "You must chastise them empty-handed. Use no weapon in this fight.", 9, "You lose your pants."));
        r39M.setMonster(new Monster("Brick Bat.", "+4 against anyone with headgear.", 9, "Lose your headgear and a level… or 2 levels if you have no headgear."));

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
        } else if (commandWord == CommandWord.GO && currentRoom.isContainsMonster() == false) {
            goRoom(command);
        } else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        } else if (commandWord == CommandWord.FIGHT) {
            fight(command);
        } else if (commandWord == CommandWord.FLEE) {
            flee(command);
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
            previousRoom = currentRoom;
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
            if (currentRoom.isContainsMonster() == true) {
                System.out.println("Battle mode activated: Fight or flee! ");
            }
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

    private boolean fight(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Don't be silly now");
            return false;
        } else if (bob.totalAttackValue() <= currentRoom.getMonster().getLevel()) {
            System.out.println("You are not strong enough");
            return false;
        } else if (bob.totalAttackValue() > currentRoom.getMonster().getLevel()) {
            currentRoom.setContainsMonster(false);
            bob.addLevel();
            System.out.println(currentRoom.getMonster().getName() + " has been defeated");
            return true;
        } else {
            return false;
        }
    }
    
    private boolean flee(Command command) {
        if (command.hasSecondWord()){
            System.out.println("Flee what?");
            return false;
        } else {
        currentRoom = previousRoom;
        System.out.println(currentRoom.getLongDescription());
        }
        return true;
    }
}
