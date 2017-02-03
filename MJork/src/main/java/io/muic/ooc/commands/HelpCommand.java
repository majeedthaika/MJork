package io.muic.ooc.commands;


import io.muic.ooc.ConsolePrinter;
import io.muic.ooc.characters.NPC;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HelpCommand extends Command{
    private List<String> possibleCommandList;
    private List<String> connectedRooms;
    private List<NPC> characters;

    public HelpCommand(List<String> possibleCommandList, List<String> connectedRooms, List<NPC> characters) {
        super("help", null);
        this.possibleCommandList = possibleCommandList;
        this.connectedRooms = connectedRooms;
        this.characters = characters;
    }

    @Override
    public void run(){
        List<String> helpMessage = new ArrayList<String>();
        helpMessage.add("Possible moves in your current situation are the following:");
        for (String word : possibleCommandList) {
            switch (word) {
                case "help": helpMessage.add("#help#: Display details of current valid commands and visitable locations."); break;
                case "quit": helpMessage.add("#quit#: Exit from current game (back to original console)."); break;
                case "info": helpMessage.add("#info#: Detailed information about player status and backpack items."); break;
                case "go": helpMessage.add("#go# to <location<: Travel to given <location>."); break;
                case "look": helpMessage.add("#look#: Information about your current location."); break;
                case "talk": helpMessage.add("#talk# with <person<: Interact with <person>."); break;
                default: break;
            }
        }
        helpMessage.add("");
        helpMessage.add("Possible characters that you can talk to:");
        for (NPC character : characters) {
            switch (character.getName()) {
                case "mom": helpMessage.add("<mom<: Your hardworking and caring stay-at-home mother."); break;
                case "bossy": helpMessage.add("<bossy<: Your DOTA-addicted, always-sleepy, dessert-making friend."); break;
                case "tow": helpMessage.add("<tow<: The always-reliable and helpful p'Tow."); break;
                case "pj": helpMessage.add("<pj<: Your high, 'special' friend."); break;
                default: break;
            }
        }
        helpMessage.add("");
        helpMessage.add("Possible locations that you can visit:");
        for (String room : connectedRooms) {
            switch (room) {
                case "home": helpMessage.add("<home<: Your nice, comfy home."); break;
                case "muic": helpMessage.add("<muic<: Your college for the next 4 (or more) years."); break;
                case "1408": helpMessage.add("<1408<: Your 'work' home."); break;
                case "1409": helpMessage.add("<1409<: Your other 'work' home."); break;
                case "canteen": helpMessage.add("<canteen<: Your snacking paradise."); break;
                case "lecture": helpMessage.add("<lecture<: Learn here, isn't that what you're in college for???"); break;
                default: break;
            }
        }
        ConsolePrinter.printWithColor(helpMessage);
    }
}
