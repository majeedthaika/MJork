package io.muic.ooc;

import java.util.List;
import java.util.TreeSet;

public class CommandWords {
    private static TreeSet<String> validCommands;

    public CommandWords(List<String> roomCommands) {
        this.validCommands = new TreeSet<String>(roomCommands);
    }

    public boolean isCommand(String candidate) {
        return validCommands.contains(candidate);
    }

    public void showAll() {
        for (String cmd : validCommands) {
            System.out.println(cmd);
        }
    }
}
