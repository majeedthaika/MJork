package io.muic.ooc;

import java.util.*;

public class Parser {
    private CommandWords commands = null;
    private final static int MAX_CMD_LENGTH = 4;
    private Scanner cin;

    public Parser() {
        cin = new Scanner(System.in);
    }

    public void setCommandWords(List<String> roomCommands) {
        this.commands = new CommandWords(roomCommands);
    }

    public Command getNextCommand() {

        System.out.print(">>> ");

        String inputLine = cin.nextLine();
        System.out.println("");

        StringTokenizer tokenizer = new StringTokenizer(inputLine);

        StringBuilder mainWord = new StringBuilder();
        Set<String> otherWords = new HashSet<String>();
        int cmdLength = 0;

        while (tokenizer.hasMoreTokens() && cmdLength < MAX_CMD_LENGTH){
            if (cmdLength == 0) {
                mainWord.append(tokenizer.nextToken());
            } else {
                otherWords.add(tokenizer.nextToken());
            }
            cmdLength += 1;
        }

        return new Command(mainWord.toString(), otherWords);
    }

    public void showValidCommands(){
        commands.showAllCommands();
    }
}