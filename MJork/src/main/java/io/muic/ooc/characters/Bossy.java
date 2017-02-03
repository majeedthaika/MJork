package io.muic.ooc.characters;

import io.muic.ooc.items.Item;
import io.muic.ooc.items.DotaGameAccount;

import java.util.Arrays;

public class Bossy extends NPC {

    public Bossy() {
        super("bossy", "src/assets/bossy", 0);
    }

    public Item updateCurrentResponse() {
        Item gift = null;
        switch (getState()) {
            case 0:
                currentResponse = Arrays.asList("I understand nothing... Where is Computer Concept's <lecture<???");
                break;
            case 1:
                double respProb = super.RANDOM.nextDouble();
                if (respProb < 0.1) {
                    gift = new DotaGameAccount();
                    currentResponse = Arrays.asList("Hey man, you should come #play# <dota< with me when you're free!");
                } else if (respProb < 0.4) {
                    currentResponse = Arrays.asList("I'm hungry... going to <canteen<");
                } else {
                    currentResponse = Arrays.asList("SCC.");
                }
                break;
            default:
                currentResponse = Arrays.asList("I have nothing to say at this time.");
        }
        return gift;
    }
}
