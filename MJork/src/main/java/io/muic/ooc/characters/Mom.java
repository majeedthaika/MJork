package io.muic.ooc.characters;

import io.muic.ooc.items.Item;
import io.muic.ooc.items.Chappati;

import java.util.Arrays;

public class Mom extends NPC {
    public Mom() {
        super("mom", 0);
    }

    public Item updateCurrentResponse() {
        Item gift = null;
        switch (getState()) {
            case 0:
                currentResponse = Arrays.asList("PJ's Mom: Get ready quick and #go# to <muic<, otherwise you'll be late to your first day of college!");
                break;
            case 1:
                double respProb = super.RANDOM.nextDouble();
                if (respProb < 0.1) {
                    gift = new Chappati("chappati", null);
                    currentResponse = Arrays.asList("Beta, #take# this <chappati< and eat it when you're hungry!");
                } else if (respProb < 0.4) {
                    currentResponse = Arrays.asList("Sigh... it get lonely being at <home< all the time...");
                } else {
                    currentResponse = Arrays.asList("Study hard if you want a good job!");
                }
                break;
            default:
                currentResponse = Arrays.asList("I have nothing to say at this time.");
        }
        return gift;
    }
}
