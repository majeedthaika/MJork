package io.muic.ooc;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Command {
    private String mainCommand;
    private ArrayList<String> cmdScenario;
    private int cmdLength;

    public Command(String mainWord, ArrayList<String> otherWords, int length){
        if (length > 0) {
            this.mainCommand = mainWord;
            this.cmdScenario = otherWords;
            this.cmdLength = length;
        } else {
            System.out.println("Nonempty command must be given.");
        }
    }

    public String getMainCommand() {
        return mainCommand;
    }

    public int getCmdLength() {
        return cmdLength;
    }

    public String getCmdScenario(int index) {
        if (index < cmdLength) return cmdScenario.get(index);
        else return "";
    }
}
