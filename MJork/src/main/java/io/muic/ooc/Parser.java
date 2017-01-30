package io.muic.ooc;

import java.util.*;

public class Parser {
    private CommandWords commands = null;
    private final static int MAX_CMD_LENGTH = 4;

    public Parser() {
    }

    public void setCommandWords(List<String> roomCommands) {
        this.commands = new CommandWords(roomCommands);
    }

    public Command getNextCommand() {

        System.out.print("> ");

        Scanner cin = new Scanner(System.in);
        String inputLine = cin.nextLine();
        StringTokenizer tokenizer = new StringTokenizer(inputLine);
        cin.close();

        StringBuilder mainWord = new StringBuilder();
        ArrayList<String> otherWords = new ArrayList<String>();
        int cmdLength = 0;

        while (tokenizer.hasMoreTokens() && cmdLength < MAX_CMD_LENGTH){
            if (cmdLength == 0) {
                mainWord.append(tokenizer.nextToken());
            } else {
                otherWords.add(tokenizer.nextToken());
            }
            cmdLength += 1;
        }

        return new Command(mainWord.toString(), otherWords, cmdLength);
    }

    public void showValidCommands(){
        commands.showAllCommands();
    }
}