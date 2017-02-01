package io.muic.ooc.commands;


import io.muic.ooc.ConsolePrinter;

import java.util.ArrayList;
import java.util.List;

public class HelpCommand {
    private List<String> possibleCommandList;
    private List<String> connectedRooms;

    public void setPossibleOptions(List<String> cmdList, List<String> rooms){
        this.possibleCommandList = cmdList;
        this.connectedRooms = rooms;
    }

    public void printHelpMessage(){
        List<String> helpMessage = new ArrayList<String>();
        helpMessage.add("Possible moves in your current situation are the following:");
        for (String word : possibleCommandList) {
            switch (word) {
                case "help":
                    helpMessage.add("#help#: Display details of current valid commands and visitable locations.");
                    break;
                case "quit":
                    helpMessage.add("#quit#: Exit from current game (back to original console).");
                    break;
                case "info":
                    helpMessage.add("#info#: Detailed information about player status and backpack items.");
                    break;
                case "go":
                    helpMessage.add("#go# to <location<: Travel to given <location>.");
                    break;
                case "look":
                    helpMessage.add("#look#: Information about your current location.");
                    break;
                case "talk":
                    helpMessage.add("#talk# with <person<: Interact with <person>.");
                    break;
                default:
                    break;
            }
        }
        helpMessage.add("");
        helpMessage.add("Possible locations that you can visit:");
        for (String room : connectedRooms) {
            switch (room.replace("0123456789", "")) {
                case "home":
                    helpMessage.add("<home<: Your nice, comfy home.");
                    break;
                case "muic":
                    helpMessage.add("<muic<: Your college for the next 4 (or more) years.");
                    break;
                default:
                    break;
            }
        }
        ConsolePrinter.printWithColor(helpMessage);
    }
}
