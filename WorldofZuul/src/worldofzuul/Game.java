package worldofzuul;

import Commands.Parser;
import Commands.CommandWord;
import Commands.Command;
import Bonuses.Item;
import Bonuses.OneTimeUse;
import Bonuses.RightHand;
import Bonuses.LeftHand;
import Bonuses.Headgear;
import Bonuses.Footgear;
import Bonuses.Armor;
import interfaces.IPlayGame;
import java.util.ArrayList;
import java.util.Scanner;

public class Game implements IPlayGame {

    private Parser parser;
    private Room currentRoom;
    private Room previousRoom;
    Character player = new Character();
    Die die = new Die();
    private int maxLevel = 10;
    private int minLevel = 0;
    private boolean finished = false;
    private boolean noDoor = false;
    private boolean battleMode = false;
    
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
        start = new Room("\\pictures\\background\\entrance.png");
        r1M = new Room("\\pictures\\background\\combat_dungeon_1.png");
        r2C = new Room("\\pictures\\background\\combat_backdrop_2.png");
        r4M = new Room("\\pictures\\background\\combat_backdrop_3.png");
        r3M = new Room("\\pictures\\background\\combat_backdrop_4.png");
        r5C = new Room("\\pictures\\background\\combat_backdrop_5.png");
        r6M = new Room("\\pictures\\background\\combat_backdrop_2.png");
        r7M = new Room("\\pictures\\background\\combat_backdrop_3.png");
        r8C = new Room("\\pictures\\background\\combat_backdrop_3.png");
        r9M = new Room("\\pictures\\background\\combat_backdrop_4.png");
        r10C = new Room("\\pictures\\background\\combat_backdrop_5.png");
        r11M = new Room("\\pictures\\background\\combat_backdrop_4.png");
        r12M = new Room("\\pictures\\background\\combat_backdrop_2.png");
        r13M = new Room("\\pictures\\background\\combat_backdrop_5.png");
        r14C = new Room("\\pictures\\background\\combat_backdrop_5.png");
        r15M = new Room("\\pictures\\background\\combat_backdrop_3.png");
        r16M = new Room("\\pictures\\background\\combat_backdrop_2.png");
        r17M = new Room("\\pictures\\background\\combat_backdrop_3.png");
        r18C = new Room("\\pictures\\background\\combat_backdrop_4.png");
        r19M = new Room("\\pictures\\background\\combat_backdrop_5.png");
        r20M = new Room("\\pictures\\background\\combat_backdrop_5.png");
        r21C = new Room("\\pictures\\background\\combat_backdrop_3.png");
        r22M = new Room("\\pictures\\background\\combat_backdrop_2.png");
        r23M = new Room("\\pictures\\background\\combat_backdrop_4.png");
        r24C = new Room("\\pictures\\background\\combat_dungeon_1.png");
        r25C = new Room("\\pictures\\background\\combat_backdrop_5.png");
        r26M = new Room("\\pictures\\background\\combat_backdrop_4.png");
        r27M = new Room("\\pictures\\background\\combat_backdrop_3.png");
        r28M = new Room("\\pictures\\background\\combat_backdrop_2.png");
        r29M = new Room("\\pictures\\background\\combat_backdrop_2.png");
        r30C = new Room("\\pictures\\background\\combat_backdrop_5.png");
        r31M = new Room("\\pictures\\background\\combat_backdrop_3.png");
        r32M = new Room("\\pictures\\background\\combat_backdrop_4.png");
        r33M = new Room("\\pictures\\background\\combat_backdrop_2.png");
        r34M = new Room("\\pictures\\background\\combat_backdrop_3.png");
        r35M = new Room("\\pictures\\background\\combat_backdrop_3.png");
        r36M = new Room("\\pictures\\background\\combat_backdrop_5.png");
        r37M = new Room("\\pictures\\background\\combat_backdrop_3.png");
        r38M = new Room("\\pictures\\background\\combat_backdrop_5.png");
        r39M = new Room("\\pictures\\background\\combat_backdrop_4.png");
        r40C = new Room("\\pictures\\background\\combat_backdrop_4.png");

        //Defining the rooms' layout
        start.setExit("south", r1M);

        r1M.setExit("north", start);
        r1M.setExit("south", r3M);
        r1M.setExit("east", r2C);

        r2C.setExit("west", r1M);
        r2C.setExit("east", r4M);

        r3M.setExit("north", r1M);
        r3M.setExit("south", r5C);

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
        r2C.setCurse(new Curse("BAM WAM SLAM!", "You get hit and you do not know by what.", "You now have a cursed armor.", "\\pictures\\monster\\bam wam slam! copy.png"));
        r5C.setCurse(new Curse("Curse!", "Immortality removed. You are now on your own!... MUHAHAHA!", "You are trapped in the dungeon, the only way out is reaching level 10. Good Luck.\n You now have a cursed armor.", ""));
        r8C.setCurse(new Curse("Fancy hat with feathers.", "The hat i fancy, because it got feathers!", "You now have a cursed headgear.", ""));
        r10C.setCurse(new Curse("E-tivity.", "A very difficult online activity, you rip your hair out of your head!", "You now have a cursed headgear.", ""));
        r14C.setCurse(new Curse("Harsh Language!", "A rat says something very unpleasant about your mother.", "You now have a cursed haedgear.", ""));
        r18C.setCurse(new Curse("Shitter Twitter Trump!?", "He hacks your Twitter account and posts shit.", "You now have a cursed weapon.", ""));
        r21C.setCurse(new Curse("Tiny Hands!", "Tiny hands comes flying toward you, they taking your weapon!", "You now have a cursed weapon.", ""));
        r24C.setCurse(new Curse("Rolling Stone!", "A huge round stone rolls towards you, INDIANA JONES STYLE!", "You now have a cursed weapon.", ""));
        r25C.setCurse(new Curse("Duck of Doom!", "A menacing presence makes you shiver.", "You now have a cursed armor.", ""));
        r30C.setCurse(new Curse("Josef F. Ritzl?!", "He invites you in to his cellar and locks you up.", "You now have a cursed weapon.", ""));
        r40C.setCurse(new Curse("Tar room.", "You jump into the room, only to find your feet getting stuck in the tar.", "You now have a cursed footgear.", ""));

        //Define the monsters in the rooms
        r1M.setMonster(new Monster("A Tiny Chicken", "Still looking for his friend: Chicken Little.", 0, "Calls you a chicken but nothing else happens.", 0, "\\pictures\\monster\\atinyechicken.png"));
        r3M.setMonster(new Monster("The Bully", "He bullys you into submission(you notice a trap door behind him).", 4, "Lose 1 level.", -1, "\\pictures\\monster\\.png"));
        r4M.setMonster(new Monster("Gobo the Goblin", "Iiiiit's Gobo everbody!", 1, "Nothing bad happens.", 0, "\\pictures\\monster\\.png"));
        r6M.setMonster(new Monster("The Karate Squid", "Makes sushi out of you. He will chop you up in small pieces!", 8, "His arm attacks you from behind. Lose 2 levels.", -2, "\\pictures\\monster\\.png"));
        r7M.setMonster(new Monster("Larry the Cable Guy", "+3 against Swagger Dagger.", 4, "You trip on his cable and get done. Lose 1 level.", -1, "\\pictures\\monster\\.png"));
        r9M.setMonster(new Monster("Harry the Hairy Wizard", "He whacks you with his wand.", 6, "He enchants you, making you grow hair all over your feet! Lose 1 level.", -1, "\\pictures\\monster\\.png"));
        r11M.setMonster(new Monster("The Stoned Golem", "He's sooo stooned broo.", 7, "He falls over and lands on you left foot. Lose 1 level.", -1, "\\pictures\\monster\\.png"));
        r12M.setMonster(new Monster("A group of 8378493.5 High Scool Students on Internship", "They ask you questions with no relevance and you do not care about answering.", 10, "They talk to you, even during your lunch break, until you lay flat on the ground. Lose 1 level.", -1, "\\pictures\\monster\\.png"));
        r13M.setMonster(new Monster("An Angry Gnome", "He HATES!!! Christmas and he hates everybody who mentions Christmas… And he hates YOU!", 13, "He will suffocate you with rice porridge. Lose 2 levels.", -2, "\\pictures\\monster\\.png"));
        r15M.setMonster(new Monster("A Dragon with Halitosis", "It has periodontitis and it smells really bad.", 8, "The smell from his mouth alone kills you (figuratively). Lose 1 level.", -1, "\\pictures\\monster\\.png"));
        r16M.setMonster(new Monster("Pelvin the Elf and his slightly less known brother Melvin", "Pelvin and Melvin will continue each others sentences which irritates you a lot! You can not flee from this monster, you have to fight them.", 7, "They will include you in their debate club. Lose 2 levels.", -2, "\\pictures\\monster\\.png"));
        r17M.setMonster(new Monster("Satan Claws", "Due to a typo and dyslexia it is Satan Claws who has been summoned instead of Santa Claus", 10, "He will gore you with his horns. Lose 2 levels.", -2, "\\pictures\\monster\\.png"));
        r19M.setMonster(new Monster("A Stubborn Crying Child", "He's had to much stewed apples and he's not happy about it.", 4, "The baby throws its dirty diaper at you. Lose 2 levels.", -2, "\\pictures\\monster\\.png"));
        r20M.setMonster(new Monster("Frodo the Fag", "He will diss your choice of fashion.", 11, "He will see your attire as a fashion crime and make you lose 1 level.", -1, "\\pictures\\monster\\.png"));
        r22M.setMonster(new Monster("Curling Merlin", "He will hit you with his curling rocks and they hurt like hell!", 12, "Lose 2 levels.",-2, "\\pictures\\monster\\.png"));
        r23M.setMonster(new Monster("A Killer Rabbit", "It has already slain a whole bunch of knights.", 15, "It kills you (figuratively). Lose 2 levels.", -2, "\\pictures\\monster\\.png"));
        r26M.setMonster(new Monster("Trubadourix", "He will sing you a song... which sounds awful!", 14, "Your eardrums inflate so much that your headgear cease to be able to fit your head! Lose 3 levels.", -3, "\\pictures\\monster\\.png"));
        r27M.setMonster(new Monster("Katty Purry", "Great singer but gets distracted easily (typical cat stuff). -5 If you have the Vest of Rabbit Fur.", 18, "She deafens you with her cat wailing! Lose 2 levels.", -2, "\\pictures\\monster\\.png"));
        r28M.setMonster(new Monster("Daft Vader", "He flails his arms around while wielding his red lightsaber, trying to intimidate you, while mumbling mumbo jumbo about some 'force'.", 6, "He uses the force to choke you. Lose 2 levels.", -2, "\\pictures\\monster\\.png"));
//        r29M.setMonster(new Monster("A Shrieking Geek from RobTech", "He is a geek and it is infectious.", 19, "Lose 3 levels.", -3, "\\pictures\\monster\\.png"));
//        r31M.setMonster(new Monster("LEEEEEROYY JENKINSSSS", "He rushes out of the room, yelling about whelplings. He leaves something behind.", 17, "Nothing, he is already gone.", 0));
//        r32M.setMonster(new Monster("Dorky Dragon of Doom", "He tells stupid jokes, which are not funny at all. He bores you to death (figuratively).", 16, "Lose 2 levels.", -2));
//        r33M.setMonster(new Monster("The Doom Donuts", "They have an affinity for everything with a 0 in it.", 7, "Lose 0 levels.", 0));
//        r34M.setMonster(new Monster("Topless Dancer", "He/she shakes em'.", 9, "Lose 2 levels.", -2));
//        r35M.setMonster(new Monster("The Great Cornholio", "Hehehehh… Heheheheh.", 8, "You lose a level… or something.", -1));
//        r36M.setMonster(new Monster("Flying Surströmming", "The smell is EVERYWHERE.", 12, "You throw up from the smell alone. Lose 3 levels.", -3));
//        r37M.setMonster(new Monster("G'huunies", "They seem cute at first, but they just keep coming.", 11, "Lose 5 levels.", -5));
//        r38M.setMonster(new Monster("Moon Maidens", "They moon you.", 9, "Lose 5 levels.", -5));
//        r39M.setMonster(new Monster("Brick Bad", "He sells you really good meth shaped as bricks.", 9, "Lose 4 levels.", -4));

        //Items connected to the rooms
        r1M.setItem(new LeftHand("Cheese grater of peace", 1, "\\pictures\\items\\cheese_grater_of_peace.png"));
        r2C.setItem(new Armor("Cursed pants... REALLY pretty cursed pants! They look fancy but gives no bonuses", 0, "\\pictures\\items\\cursed_pants.png"));
        r3M.setItem(new Headgear("Helm of courage", 1, "\\pictures\\items\\.png"));
        r4M.setItem(new Armor("Goblin shitty shirt", 3, "\\pictures\\items\\.png"));
        r5C.setItem(new Armor("Cursed armor of idiotic bravery", 0, "\\pictures\\items\\.png"));
        r6M.setItem(new LeftHand("Tentacle", 2, "\\pictures\\items\\.png"));
        r7M.setItem(new LeftHand("Wire cutter", 2, "\\pictures\\items\\.png"));
        r8C.setItem(new Headgear("Cursed hat with feathers", -1, "\\pictures\\items\\.png"));
        r9M.setItem(new Armor("Furry tail", 2, "\\pictures\\items\\.png"));
        r10C.setItem(new Headgear("Cursed head do to E-tivity", -3, "\\pictures\\items\\.png"));
        r11M.setItem(new OneTimeUse("A lot of small rocks", 2, "\\pictures\\items\\.png"));
        r12M.setItem(new Armor("School bag full of pencils and paper", 2, "\\pictures\\items\\.png"));
        r13M.setItem(new LeftHand("Bad ass spoon of wood", 3, "\\pictures\\items\\.png"));
        r14C.setItem(new Headgear("Cursed rat whiskers", -3, "\\pictures\\items\\.png"));
        r15M.setItem(new RightHand("Really big toothpick", 3, "\\pictures\\items\\.png"));
        r16M.setItem(new LeftHand("A speaking sword who speaks really well", 3, "\\pictures\\items\\.png"));
        r17M.setItem(new RightHand("A spear with a red point", 3, "\\pictures\\items\\.png"));
        r18C.setItem(new LeftHand("Cursed cell phone with low signal", -3, "\\pictures\\items\\.png"));
        r19M.setItem(new LeftHand("Orange rattle", 1, "\\pictures\\items\\.png"));
        r20M.setItem(new Armor("Fancy looking cloak", 3, "\\pictures\\items\\.png"));
        r21C.setItem(new LeftHand("A cursed tiny fork", -4, "\\pictures\\items\\.png"));
        r22M.setItem(new OneTimeUse("Curling rock", 3, "\\pictures\\items\\.png"));
        r23M.setItem(new Armor("Armour vest of rabbit fur", 3, "\\pictures\\items\\.png"));
        r24C.setItem(new RightHand("Cursed chainsaw of bloody dismemberment", -3, "\\pictures\\items\\.png")); 
        r25C.setItem(new Armor("Cursed spiky knees", -3, "\\pictures\\items\\.png"));
        r26M.setItem(new RightHand("Harp O' Molly", 2, "\\pictures\\items\\.png"));
        r27M.setItem(new LeftHand("Microphone", 1, "\\pictures\\items\\.png"));//+5 if used with cellphone
        r28M.setItem(new LeftHand("A Plastic Light Saber Toy", 1, "\\pictures\\items\\.png"));
        r29M.setItem(new Armor("Shirt with check pattern", 3, "\\pictures\\items\\.png"));
        r30C.setItem(new LeftHand("Cursed old used teddy bear", -3, "\\pictures\\items\\.png"));
        r31M.setItem(new OneTimeUse("CHICKEN!!!", 6, "\\pictures\\items\\.png"));
        r32M.setItem(new OneTimeUse("A dad joke book", 3, "\\pictures\\items\\.png"));
        r33M.setItem(new Footgear("Your feet are dragon",4, "\\pictures\\items\\.png"));
        r34M.setItem(new RightHand("Mannequin head, you can bash your opponents with", 2, "\\pictures\\items\\.png"));
        r35M.setItem(new OneTimeUse("You scored with a hot chick", 1, "\\pictures\\items\\.png"));
        r36M.setItem(new OneTimeUse("You kept some of the remaining fish, to startle your next opponent", 6, "\\pictures\\items\\.png"));
        r37M.setItem(new OneTimeUse("Infestation", 5, "\\pictures\\items\\.png"));
        r38M.setItem(new Armor("B.A.A.W.W.", 4, "\\pictures\\items\\.png"));
        r39M.setItem(new Footgear("Boots of butt-kicking", 2, "\\pictures\\items\\.png"));
        r40C.setItem(new Footgear("Cursed feet with blisters", -3, "\\pictures\\items\\.png"));
        currentRoom = start;
    }

        public boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

         if (commandWord == CommandWord.GO && currentRoom.isContainsMonster() == false) {
            goRoom(command);
        } else if (commandWord == CommandWord.FIGHT && currentRoom.isContainsMonster()) {
            fight(command);
        } else if (commandWord == CommandWord.FLEE && currentRoom.isContainsMonster()) {
            flee(command);
        } else if(commandWord == CommandWord.LOOT && currentRoom.isContainsMonster() == false){
            loot(command);
        } else if(commandWord == CommandWord.CHARACTER) {
            character(command);
        }
        return wantToQuit;
    }

    public boolean isNoDoor() {
        return noDoor;
    }

   
    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }
        noDoor = false;
        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            noDoor = true;
        } else {
            previousRoom = currentRoom;
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
            if (currentRoom.isContainsMonster()) {
                System.out.println("Battle mode activated. You have an attack value of: "+ player.totalAttackValue()+". You can only fight or flee!");
                battleMode = true;
            } else if (currentRoom.isContainsCurse()) {
                currentRoom.setHadCurse(true);
                currentRoom.setContainsItem(true);
                lootRoom();
                currentRoom.setContainsItem(false);
            }
        }
    }
    private boolean fight(Command command) { //When the player wants to fight the monster.
        battleMode = false;
        if (command.hasSecondWord()) {
            System.out.println("Don't be silly now");
            return false;
        } else if (player.totalAttackValue() <= currentRoom.getMonster().getLevel()) {
            System.out.println("You are not strong enough");
            return false;
        } else if (player.totalAttackValue() > currentRoom.getMonster().getLevel()) { //If the player has a larger comebined attack value than the monster, it will be defeated and "removed" from the room.
            currentRoom.setContainsMonster(false);
            currentRoom.setHadMonster(true);
            currentRoom.setContainsItem(true);
            player.addLevel();
            System.out.println("The monster '"+currentRoom.getMonster().getName() + "' has been defeated and you go up a level. You are now level: "+player.getLevel());
            System.out.println("In the room you find a '"+currentRoom.getItem().getName()+"' with an attack bonus of "+currentRoom.getItem().getBonus()+"."); //Skal måske rykkes til lootRoom()
            System.out.println("To loot the room type 'loot' or else leave the room."+"\n"+currentRoom.getExitString());
            return true;
        } else {
            return false;
        }
    }
          
    private boolean flee(Command command) { //Used for when the player does not want to fight the monster and has to roll a die to flee.
        battleMode = false;
        if (command.hasSecondWord()){
            System.out.println("Flee what?");
            return false;
        }  else {
            this.roll(command);       
        }
        return true;
    }


    private boolean loot(Command command){ //Calls lootRoom() and removes the item from the room.
        if(command.hasSecondWord()){
            System.out.println("What?");
            return false;
        } else if(currentRoom.isContainsMonster()){
            System.out.println("You should probably worry about monster first.");
            return false;
        } else if(!currentRoom.isContainsMonster() && currentRoom.isContainsItem()){
            lootRoom();
            currentRoom.setContainsItem(false);
            return true;
        } else{
            System.out.println("There is nothing to loot.");
            return false;
        }
    }
    
    private boolean character(Command command) { //Prints out the level, combined attack and inventory of the player.
        if(command.hasSecondWord()) {
            System.out.println("Not true statement");
            return false;
        }
        else {
            System.out.println("Here is your character sheet:\nLevel: "+player.getLevel()+"\nTotal attack value: "+player.totalAttackValue()+"\n"+player.stringInventory()); 
            return true;
    }
    }
    
    private void roll(Command command){ //Rolls a die and activates bad stuff if the roll is under 5.
        Die die = new Die();
        if (command.getCommandWord()==CommandWord.FLEE){
            System.out.println("Roll the die to flee. You escape on a 5 or more.");
            int dieResult=die.roll();
            System.out.println("You have rolled: " + dieResult);
            if (dieResult <5) {
                System.out.println(currentRoom.getMonster().getBadStuff());
                player.removeLevel(currentRoom.getMonster().getBadStuffEffect());
                System.out.println("You are now level: "+player.getLevel());
                currentRoom = previousRoom;
        System.out.println(currentRoom.getLongDescription());
            }
            else {
                currentRoom = previousRoom;
        System.out.println(currentRoom.getLongDescription());
            }       
    }
    }
    private void lootRoom(){ //When the player wants to pick up an item from the room. Method call in loot().
        ArrayList<Item> equippedItems = new ArrayList<>();
        for(Item item : player.inventory){
            if(currentRoom.getItem().getClass().equals(item.getClass())){
                equippedItems.add(item);
            }
        }
        if(equippedItems.size() > 0){
              player.inventory.remove(equippedItems.get(0));
              player.addItem(currentRoom.getItem());
              System.out.println(player.stringInventory()+currentRoom.getExitString());
            }
            else {
                player.addItem(currentRoom.getItem());
                System.out.println(player.stringInventory()+currentRoom.getExitString());
            }
        }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public boolean isBattleMode() {
        return battleMode;
    }

    public Character getPlayer() {
        return player;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public int getMinLevel() {
        return minLevel;
    }

    @Override
    public Room getCurrentRoom() {
        return currentRoom;
    }
    
    
}
