package io.muic.ooc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Parser {
    private CommandWords commands;
    private final static int MAX_CMD_LENGTH = 4;

    public Parser() {
        commands = new CommandWords(Arrays.asList("test"));
//        commands = new CommandWords();
    }

    public Command getCommand() {

        System.out.print("> ");

        Scanner cin = new Scanner(System.in);
        String inputLine = cin.nextLine();
        StringTokenizer tokenizer = new StringTokenizer(inputLine);

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
        commands.showAll();
    }
}
