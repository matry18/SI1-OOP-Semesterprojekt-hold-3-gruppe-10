package Commands;

import java.util.Scanner;

public class Parser {

    private CommandWords commands;
    private String GUICommand;

    public Parser() {
        commands = new CommandWords();
    }

    public Command getCommand() {
        String inputLine;
        String word1 = null;
        String word2 = null;

        Scanner tokenizer = new Scanner(GUICommand);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next();
            if (tokenizer.hasNext()) {
                word2 = tokenizer.next();
            }
        }

        return new Command(commands.getCommandWord(word1), word2);
    }

    public void showCommands() {
        commands.showAll();
    }

    public void setGUICommand(String goDirection) {
        this.GUICommand = goDirection;
    }
}
