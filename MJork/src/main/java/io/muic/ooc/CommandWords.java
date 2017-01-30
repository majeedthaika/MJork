package io.muic.ooc;

import java.util.List;
import java.util.TreeSet;

public class CommandWords {
    private static TreeSet<String> validCommands;

    public CommandWords(List<String> words) {
        this.validCommands = new TreeSet<String>(words);
    }

    public boolean isCommand(String candidate) {
        return validCommands.contains(candidate);
    }

    public void addCommand(String newWord) {
        validCommands.add(newWord);
    }

    public void removeCommand(String toRemove) {
        validCommands.remove(toRemove);
    }

    public void showAllCommands() {
        for (String cmd : validCommands) {
            System.out.println(cmd);
        }
    }
}
