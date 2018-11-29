package Commands;

public enum CommandWord {
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), FIGHT("fight"), FLEE("flee"), LOOT("loot"), CHARACTER("character");

    private String commandString;

    CommandWord(String commandString) {
        this.commandString = commandString;
    }

    public String toString() {
        return commandString;
    }
}
