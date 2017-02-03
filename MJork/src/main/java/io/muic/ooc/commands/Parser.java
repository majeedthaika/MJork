package io.muic.ooc.commands;

import io.muic.ooc.GameInstance;
import io.muic.ooc.Player;
import io.muic.ooc.location.Room;

import java.util.*;

public class Parser {
    private GameInstance currentGame;
    private final static int MAX_CMD_LENGTH = 4;
    private Scanner cin;
    private Player caller;

    public Parser(Player caller, GameInstance game) {
        this.currentGame = game;
        this.caller = caller;
        this.cin = new Scanner(System.in);
    }

    public Command getNextCommand() {

        System.out.print(">>> ");

        String inputLine = cin.nextLine();
        System.out.println("");

        StringTokenizer tokenizer = new StringTokenizer(inputLine);

        StringBuilder mainWord = new StringBuilder();
        Set<String> otherWords = new HashSet<>();
        int cmdLength = 0;

        while (tokenizer.hasMoreTokens() && cmdLength < MAX_CMD_LENGTH){
            if (cmdLength == 0) {
                mainWord.append(tokenizer.nextToken());
            } else {
                otherWords.add(tokenizer.nextToken());
            }
            cmdLength += 1;
        }

        Command nextCmd = null;
        Room currentRoom = caller.getCurrentRoom();

        try {
            switch (mainWord.toString()) {
                case "help":
                    nextCmd = new HelpCommand(currentRoom.getPossibleCommandList(),
                                              currentRoom.getConnectedRooms(),
                                              currentRoom.getInRoomCharacters()); break;
                case "look":
                    nextCmd = new LookCommand(currentRoom); break;
                case "talk":
                    nextCmd = new TalkCommand(otherWords, caller, currentRoom); break;
                case "go":
                    nextCmd = new GoCommand(otherWords, caller,
                                            currentRoom.getConnectedRooms(),
                                            currentGame.getAllRooms()); break;
                case "info":
                    nextCmd = new InfoCommand(caller); break;
                case "quit":
                    nextCmd = new QuitCommand(); break;
                default:
                    break;
            }
        } catch (Exception ex) {}

        return nextCmd;
    }
}