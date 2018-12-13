package worldofmunchkin;

import Commands.Parser;
import Commands.CommandWord;
import Commands.Command;
import Bonuses.*;
import java.util.ArrayList;

public class Game {

    private Parser parser;
    private Room currentRoom;
    private Room previousRoom;
    private Room fleeRoom;
    private final int maxLevel = 10;
    private final int minLevel = 0;
    private boolean noDoor = false;
    private boolean battleMode = false;
    private final boolean isMultiplayer;
    private boolean changePlayer = false;
    private int moves = 3;
    private String outputDesc;
    Character player = new Character();
    Die die = new Die();

    public Game(boolean isMultiplayer) {
        createRooms();
        parser = new Parser();
        this.isMultiplayer = isMultiplayer;
        //Debugging metode
        //unWinAble();
    }

    private void createRooms() {
        Room start, r1M, r2C, r3M, r4M, r5C, r6M, r7M, r8C, r9M,
                r10C, r11M, r12M, r13M, r14C, r15M, r16M, r17M, r18C, r19M,
                r20M, r21C, r22M, r23M, r24C, r25C, r26M, r27M, r28M, r29M,
                r30C, r31M, r32M, r33M, r34M, r35M, r36M, r37M, r38M, r39M,
                r40C;

        //Creating the rooms
        start = new Room("/Pictures/BackGround/Entrance.png");
        r1M = new Room("/Pictures/BackGround/combat_dungeon_1.png");
        r2C = new Room("/Pictures/BackGround/combat_backdrop_2.png");
        r4M = new Room("/Pictures/BackGround/combat_backdrop_3.png");
        r3M = new Room("/Pictures/BackGround/combat_backdrop_4.png");
        r5C = new Room("/Pictures/BackGround/combat_backdrop_5.png");
        r6M = new Room("/Pictures/BackGround/combat_backdrop_2.png");
        r7M = new Room("/Pictures/BackGround/combat_backdrop_3.png");
        r8C = new Room("/Pictures/BackGround/combat_backdrop_3.png");
        r9M = new Room("/Pictures/BackGround/combat_backdrop_4.png");
        r10C = new Room("/Pictures/BackGround/combat_backdrop_5.png");
        r11M = new Room("/Pictures/BackGround/combat_backdrop_4.png");
        r12M = new Room("/Pictures/BackGround/combat_backdrop_2.png");
        r13M = new Room("/Pictures/BackGround/combat_backdrop_5.png");
        r14C = new Room("/Pictures/BackGround/combat_backdrop_5.png");
        r15M = new Room("/Pictures/BackGround/combat_backdrop_3.png");
        r16M = new Room("/Pictures/BackGround/combat_backdrop_2.png");
        r17M = new Room("/Pictures/BackGround/combat_backdrop_3.png");
        r18C = new Room("/Pictures/BackGround/combat_backdrop_4.png");
        r19M = new Room("/Pictures/BackGround/combat_backdrop_5.png");
        r20M = new Room("/Pictures/BackGround/combat_backdrop_5.png");
        r21C = new Room("/Pictures/BackGround/combat_backdrop_3.png");
        r22M = new Room("/Pictures/BackGround/combat_backdrop_2.png");
        r23M = new Room("/Pictures/BackGround/combat_backdrop_4.png");
        r24C = new Room("/Pictures/BackGround/combat_dungeon_1.png");
        r25C = new Room("/Pictures/BackGround/combat_backdrop_5.png");
        r26M = new Room("/Pictures/BackGround/combat_backdrop_4.png");
        r27M = new Room("/Pictures/BackGround/combat_backdrop_3.png");
        r28M = new Room("/Pictures/BackGround/combat_backdrop_2.png");
        r29M = new Room("/Pictures/BackGround/combat_backdrop_2.png");
        r30C = new Room("/Pictures/BackGround/combat_backdrop_5.png");
        r31M = new Room("/Pictures/BackGround/combat_backdrop_3.png");
        r32M = new Room("/Pictures/BackGround/combat_backdrop_4.png");
        r33M = new Room("/Pictures/BackGround/combat_backdrop_2.png");
        r34M = new Room("/Pictures/BackGround/combat_backdrop_3.png");
        r35M = new Room("/Pictures/BackGround/combat_backdrop_3.png");
        r36M = new Room("/Pictures/BackGround/combat_backdrop_5.png");
        r37M = new Room("/Pictures/BackGround/combat_backdrop_3.png");
        r38M = new Room("/Pictures/BackGround/combat_backdrop_5.png");
        r39M = new Room("/Pictures/BackGround/combat_backdrop_4.png");
        r40C = new Room("/Pictures/BackGround/combat_backdrop_4.png");

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
        r24C.setExit("south", r26M);

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
        r30C.setExit("east", r32M);

        r31M.setExit("north", r30C);

        r32M.setExit("west", r30C);

        r33M.setExit("north", r21C);
        r33M.setExit("south", r35M);

        r34M.setExit("north", r28M);
        r34M.setExit("south", r36M);

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
        r2C.setCurse(new Curse("BAM WAM SLAM!", "/Pictures/Curses/BAMWAMSLAM!.png"));
        r5C.setCurse(new Curse("Curse!", "/Pictures/Curses/Curse!.png"));
        r8C.setCurse(new Curse("Fancy hat with feathers.", "/Pictures/Curses/Fancyhatwithfeathers.png"));
        r10C.setCurse(new Curse("E-tivity.", "/Pictures/Curses/E-tivity.png"));
        r14C.setCurse(new Curse("Harsh Language!", "/Pictures/Curses/HarshLanguage!.png"));
        r18C.setCurse(new Curse("Shitter Twitter Trump!?", "/Pictures/Curses/ShitterTwitterTrump!.png"));
        r21C.setCurse(new Curse("Tiny Hands!", "/Pictures/Curses/TinyHands!.png"));
        r24C.setCurse(new Curse("Rolling Stone!", "/Pictures/Curses/RollingStone!.png"));
        r25C.setCurse(new Curse("Duck of Doom!", "/Pictures/Curses/DuckofDoom!.png"));
        r30C.setCurse(new Curse("Josef F. Ritzl?!", "/Pictures/Curses/JosefFRitzl.png"));
        r40C.setCurse(new Curse("Tar room.", "/Pictures/Curses/Tarroom.png"));

        //Define the monsters in the rooms
        r1M.setMonster(new Monster("A Tiny Chicken", 0, 0, "/Pictures/Monster/ATinyeChicken.png"));
        r3M.setMonster(new Monster("The Bully", 4, -1, "/Pictures/Monster/TheBully.png"));
        r4M.setMonster(new Monster("Gobo the Goblin", 1, 0, "/Pictures/Monster/GoboTheGoblin.png"));
        r6M.setMonster(new Monster("The Karate Squid", 8, -2, "/Pictures/Monster/TheKarateSquid.png"));
        r7M.setMonster(new Monster("Larry the Cable Guy", 4, -1, "/Pictures/Monster/LarryTheCableGuy.png"));
        r9M.setMonster(new Monster("Harry the Hairy Wizard", 6, -1, "/Pictures/Monster/HarryTheHairyWizard.png"));
        r11M.setMonster(new Monster("The Stoned Golem", 7, -1, "/Pictures/Monster/TheStonedGolem.png"));
        r12M.setMonster(new Monster("A group of 8378493.5 High Scool Students on Internship", 10, -1, "/Pictures/Monster/AGroupOf8378493.5HighScoolStudentsNnInternship.png"));
        r13M.setMonster(new Monster("An Angry Gnome", 13, -2, "/Pictures/Monster/AnAngryGnome.png"));
        r15M.setMonster(new Monster("A Dragon with Halitosis", 8, -1, "/Pictures/Monster/ADragonWithHalitosis.png"));
        r16M.setMonster(new Monster("Pelvin the Elf and his slightly less known brother Melvin", 7, -2, "/Pictures/Monster/pelvin_and_melvin.png"));
        r17M.setMonster(new Monster("Satan Claws", 10, -2, "/Pictures/Monster/satan_claws.png"));
        r19M.setMonster(new Monster("A Stubborn Crying Child", 4, -2, "/Pictures/Monster/a_stubborn_crying_child.png"));
        r20M.setMonster(new Monster("Frodo the Fag", 11, -1, "/Pictures/Monster/frodo_the_fag.png"));
        r22M.setMonster(new Monster("Curling Merlin", 12, -2, "/Pictures/Monster/curling_merlin.png"));
        r23M.setMonster(new Monster("A Killer Rabbit", 15, -2, "/Pictures/Monster/killer_rabbit.png"));
        r26M.setMonster(new Monster("Trubadourix", 14, -3, "/Pictures/Monster/trubadourix.png"));
        r27M.setMonster(new Monster("Katty Purry", 18, -2, "/Pictures/Monster/katty_perry.png"));
        r28M.setMonster(new Monster("Daft Vader", 6, -2, "/Pictures/Monster/daft_vader.png"));
        r29M.setMonster(new Monster("A Shrieking Geek from RobTech", 19, -3, "/Pictures/Monster/AShriekingGeekFromRobTech.png"));
        r31M.setMonster(new Monster("LEEEEEROYY JENKINSSSS", 17, 0, "/Pictures/Monster/LeeroyJenkins.png"));
        r32M.setMonster(new Monster("Dorky Dragon of Doom", 16, -2, "/Pictures/Monster/DorkyDragonOfDoom.png"));
        r33M.setMonster(new Monster("The Doom Donuts", 7, 0, "/Pictures/Monster/TheDoomDonuts.png"));
        r34M.setMonster(new Monster("Topless Dancer", 9, -2, "/Pictures/Monster/Topless_Dancer.png"));
        r35M.setMonster(new Monster("The Great Cornholio", 8, -1, "/Pictures/Monster/the_great_cornholio.png"));
        r36M.setMonster(new Monster("Flying Surströmming", 12, -3, "/Pictures/Monster/FlyingSurstromming.png"));
        r37M.setMonster(new Monster("G'huunies", 11, -5, "/Pictures/Monster/ghuunies.png"));
        r38M.setMonster(new Monster("Moon Maidens", 9, -5, "/Pictures/Monster/MoonMaidens.png"));
        r39M.setMonster(new Monster("Brick Bad", 9, -4, "/Pictures/Monster/BrickBad.png"));

        //Items connected to the rooms
        r1M.setItem(new LeftHand("Cheese grater of peace", 1, "/Pictures/Items/Cheese_Grater_of_Peace.png"));
        r2C.setItem(new Armor("Cursed pants... REALLY pretty cursed pants! They look fancy but gives no bonuses", 0, "/Pictures/Items/cursed_pants.png"));
        r3M.setItem(new Headgear("Helm of courage", 1, "/Pictures/Items/helm_of_courage.png"));
        r4M.setItem(new Armor("Goblin shitty shirt", 3, "/Pictures/Items/goblin_shitty_shirt.png"));
        r5C.setItem(new Armor("Cursed armor of idiotic bravery", 0, "/Pictures/Items/cursed_armor_of_idiotic_bravery.png"));
        r6M.setItem(new LeftHand("Tentacle", 2, "/Pictures/Items/tentacle.png"));
        r7M.setItem(new LeftHand("Wire cutter", 2, "/Pictures/Items/wire_cutter.png"));
        r8C.setItem(new Headgear("Cursed hat with feathers", -1, "/Pictures/Items/cursed_hat_with_feathers.png"));
        r9M.setItem(new Armor("Furry tail", 2, "/Pictures/Items/furry_tail.png"));
        r10C.setItem(new Headgear("Cursed head do to E-tivity", -3, "/Pictures/Items/incredible_headache.png"));
        r11M.setItem(new OneTimeUse("A lot of small rocks", 2, "/Pictures/Items/a_lot_of_small_rocks.png"));
        r12M.setItem(new Armor("School bag full of pencils and paper", 2, "/Pictures/Items/school_bag_full_of_pencils_and_papers.png"));
        r13M.setItem(new LeftHand("Bad ass spoon of wood", 3, "/Pictures/Items/bad_ass_spoon_of_wood.png"));
        r14C.setItem(new Headgear("Cursed rat whiskers", -3, "/Pictures/Items/cursed_rat_whiskers.png"));
        r15M.setItem(new RightHand("Really big toothpick", 3, "/Pictures/Items/really_big_toothpick.png"));
        r16M.setItem(new LeftHand("A speaking sword who speaks really well", 3, "/Pictures/Items/a_speaking_sword_which_speaks_really_well.png"));
        r17M.setItem(new RightHand("A spear with a red point", 3, "/Pictures/Items/a_spear_with_red_point.png"));
        r18C.setItem(new LeftHand("Cursed cell phone with low signal", -3, "/Pictures/Items/cursed_cellphone_with_low_signal.png"));
        r19M.setItem(new LeftHand("Orange rattle", 1, "/Pictures/Items/orange_rattle.png"));
        r20M.setItem(new Armor("Fancy looking cloak", 3, "/Pictures/Items/fancy_looking_cloak.png"));
        r21C.setItem(new LeftHand("A cursed tiny fork", -4, "/Pictures/Items/cursed_tiny_fork.png"));
        r22M.setItem(new OneTimeUse("Curling rock", 3, "/Pictures/Items/curling_rock.png"));
        r23M.setItem(new Armor("Armour vest of rabbit fur", 3, "/Pictures/Items/armor_vest_of_rabbit_fur.png"));
        r24C.setItem(new RightHand("Cursed chainsaw of bloody dismemberment", -3, "/Pictures/Items/cursed_chainsaw_of_bloody_dismemberment.png"));
        r25C.setItem(new Armor("Cursed spiky knees", -3, "/Pictures/Items/cursed_spiky_knees.png"));
        r26M.setItem(new RightHand("Harp O' Molly", 2, "/Pictures/Items/harp_o_molly.png"));
        r27M.setItem(new LeftHand("Microphone", 1, "/Pictures/Items/Micropwn.png"));//+5 if used with cellphone
        r28M.setItem(new LeftHand("A Plastic Light Saber Toy", 1, "/Pictures/Items/plastic_lightsaber_toy.png"));
        r29M.setItem(new Armor("Shirt with check pattern", 3, "/Pictures/Items/shirt_with_check_pattern.png"));
        r30C.setItem(new LeftHand("Cursed old used teddy bear", -3, "/Pictures/Items/cursed_used_teddybear.png"));
        r31M.setItem(new OneTimeUse("CHICKEN!!!", 6, "/Pictures/Items/chicken.png"));
        r32M.setItem(new OneTimeUse("A dad joke book", 3, "/Pictures/Items/a_dad_joke_book.png"));
        r33M.setItem(new Footgear("Your feet are dragon", 4, "/Pictures/Items/your_feet_are_dragon.png")); //Item?
        r34M.setItem(new RightHand("Mannequin head, you can bash your opponents with", 2, "/Pictures/Items/mannequin_head.png"));
        r35M.setItem(new OneTimeUse("You scored with a hot chick", 1, "/Pictures/Items/hot_chick.png"));
        r36M.setItem(new OneTimeUse("You kept some of the remaining fish, to startle your next opponent", 6, "/Pictures/Items/fish_remains.png"));
        r37M.setItem(new OneTimeUse("Infestation", 5, "/Pictures/Items/infestation.png"));
        r38M.setItem(new Armor("B.A.A.W.W.", 4, "/Pictures/Items/baaww.png"));
        r39M.setItem(new Footgear("Boots of butt-kicking", 2, "/Pictures/Items/boots_of_buttkicking.png"));
        r40C.setItem(new Footgear("Cursed feet with blisters", -3, "/Pictures/Items/cursed_feet_with_blisters.png"));
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
        } else if (commandWord == CommandWord.LOOT && currentRoom.isContainsMonster() == false) {
            loot(command);
        } else if (commandWord == CommandWord.ENDTURN) {
            endTurn(command);
        } else if (commandWord == CommandWord.USEITEM) {
            useItem(command);
        }
        return wantToQuit;
    }

    public boolean isNoDoor() {
        return noDoor;
    }

    private void goRoom(Command command) {
        noDoor = false;
        String direction = command.getSecondWord();
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            outputDesc = "There is no door!";
            noDoor = true;
        } else if (moves <= 0 && isMultiplayer) {
            outputDesc = "You cannot move anymore, change player by using the 'end turn' command";
        } else {
            previousRoom = currentRoom;
            currentRoom = nextRoom;
            if (isMultiplayer) {
                moves--;
            }
            outputDesc = currentRoom.getExitString();
            if (currentRoom.isContainsMonster()) {
                outputDesc = "Battle mode activated. You can only fight or flee!";
                battleMode = true;
            } else if (currentRoom.isContainsCurse()) {
                currentRoom.setContainsItem(true);
                lootRoom();
                currentRoom.setContainsItem(false);
            }
        }
    }

    //Code is used to find difference between monsters level and players total attack value and removes monster if player is higher value.
    private boolean fight(Command command) { //When the player wants to fight the monster.
        if (player.totalAttackValue() <= currentRoom.getMonster().getLevel()) {
            outputDesc = "You are not strong enough.";
            return false;
        } else if (player.totalAttackValue() > currentRoom.getMonster().getLevel()) { //If the player has a larger comebined attack value than the monster, it will be defeated and "removed" from the room.
            currentRoom.setContainsMonster(false);
            currentRoom.setContainsItem(true);
            battleMode = false;
            player.addLevel();
            outputDesc = "You defeated the monster! You can either loot the room or leave.\n\n" + currentRoom.getExitString();
            player.resetTemporaryBonus();
            return true;
        } else {
            return false;
        }
    }

    private boolean flee(Command command) { //Used for when the player does not want to fight the monster and has to roll a die to flee.
        battleMode = false;
        if (die.getDieResult() < 5) {
            player.removeLevel(currentRoom.getMonster().getBadStuffEffect());
            fleeRoom = currentRoom;
            currentRoom = previousRoom;
        } else {
            currentRoom = previousRoom;
        }
        return true;
    }

    //Code is used to pickup items set on a room after defeating a monster.
    private boolean loot(Command command) { //Calls lootRoom() and removes the item from the room.
        if (currentRoom.isContainsMonster()) {
            return false;
        } else if (!currentRoom.isContainsMonster() && currentRoom.isContainsItem()) {
            lootRoom();
            currentRoom.setContainsItem(false);
            return true;
        } else {
            outputDesc = "There is nothing to loot.\n\n" + currentRoom.getExitString();
            return false;
        }
    }

    private void lootRoom() { //When the player wants to pick up an item from the room. Method call in loot().
        outputDesc = currentRoom.getExitString();
        ArrayList<Item> equippedItems = new ArrayList<>();
        for (Item item : player.inventory) {
            if (currentRoom.getItem().getClass().equals(item.getClass())) {
                equippedItems.add(item);
            }
        }
        if (equippedItems.size() > 0) {
            player.inventory.remove(equippedItems.get(0));
            player.addItem(currentRoom.getItem());
        } else {
            player.addItem(currentRoom.getItem());
        }
    }

    //Code should make that the current player is ready to change to the next player.
    private boolean endTurn(Command command) { //(Multiplayer Only) When player has 0 moves left this indicates the players wants to change.
        noDoor = false;
        if (isMultiplayer) {
            outputDesc = "Changed Player!";
            moves = 3;
            changePlayer = true;
            return true;
        }
        return false;
    }

    //Code uses OneTimeUse Item equipped and removes it from inventory.
    private boolean useItem(Command command) {
        if (player.getOneTimeUse() == null) {
            return false;
        } else {
            player.addTemporaryBonus(player.getOneTimeUse().getBonus());
            player.inventory.remove(player.getOneTimeUse());
            return true;
        }
    }

    public Parser getParser() {
        return parser;
    }

    public boolean isMultiplayer() {
        return isMultiplayer;
    }

    public boolean getChangePlayer() {
        return changePlayer;
    }

    public void setChangePlayer(boolean changePlayer) {
        this.changePlayer = changePlayer;
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

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Die getDie() {
        return die;
    }

    public String getOutputDesc() {
        return outputDesc;
    }

    public void setOutputDesc(String outputDesc) {
        this.outputDesc = outputDesc;
    }

    //This method makes you character above maxLevel, and makes so you can't win.
    private void unWinAble() {
        player.setLevel(11);
        player.setBonus(9);
    }

    public Room getFleeRoom() {
        return fleeRoom;
    }
}
