package io.muic.ooc.commands;


import io.muic.ooc.ConsolePrinter;
import io.muic.ooc.NPC;

import java.util.ArrayList;
import java.util.List;

public class HelpCommand {
    private List<String> possibleCommandList;
    private List<String> connectedRooms;
    private List<NPC> characters;

    public void setPossibleOptions(List<String> cmdList, List<String> rooms, List<NPC> characters){
        this.possibleCommandList = cmdList;
        this.connectedRooms = rooms;
        this.characters = characters;
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
        helpMessage.add("Possible characters that you can talk to:");
        for (NPC character : characters) {
            switch (character.getName()) {
                case "mom":
                    helpMessage.add("<mom<: Your hardworking and caring stay-at-home mother.");
                    break;
                case "bossy":
                    helpMessage.add("<bossy<: Your DOTA-addicted, always-sleepy, dessert-making friend.");
                    break;
                default:
                    break;
            }
        }
        helpMessage.add("");
        helpMessage.add("Possible locations that you can visit:");
        for (String room : connectedRooms) {
            switch (room) {
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
