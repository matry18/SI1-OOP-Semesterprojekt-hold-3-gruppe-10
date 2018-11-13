package worldofzuul;

public enum CommandWord {
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), FIGHT("fight"), FLEE("flee"), LOOT("loot"), /*ROLL("roll"),*/ CHARACTER("character");

    private String commandString;

    CommandWord(String commandString) {
        this.commandString = commandString;
    }

    public String toString() {
        return commandString;
    }
}
