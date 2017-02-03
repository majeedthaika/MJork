package io.muic.ooc.commands;

import io.muic.ooc.characters.NPC;

import java.util.List;
import java.util.Set;

public class Command {
    private String mainCommand;
    private Set<String> cmdScenario;

    public Command(String mainWord, Set<String> otherWords){
        try {
            if (!mainWord.isEmpty()) {
                this.mainCommand = mainWord;
                this.cmdScenario = otherWords;
            } else {
                System.out.println("Non-empty command must be given.\n");
            }
        } catch (Exception ex) {}

    }

    public String getMainCommand() {
        return mainCommand;
    }

    public boolean isValid() {
        return null != mainCommand;
    }

    public NPC isNPCInCommand(List<NPC> possibleCharacters) {
        for (NPC nextCand : possibleCharacters) {
            if (cmdScenario.contains(nextCand.toString())) {
                return nextCand;
            }
        }
        return null;
    }

    public String isRoomInCommand(List<String> possibleCharacters) {
        for (String nextCand : possibleCharacters) {
            if (cmdScenario.contains(nextCand.toString())) {
                return nextCand;
            }
        }
        return null;
    }
}
