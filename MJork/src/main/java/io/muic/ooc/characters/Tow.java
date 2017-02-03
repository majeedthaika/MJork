package io.muic.ooc.characters;

import io.muic.ooc.items.Item;
import io.muic.ooc.items.Calculator;

import java.util.Arrays;

public class Tow extends NPC {
    public Tow() {
        super("tow", 0);
    }

    public Item updateCurrentResponse() {
        Item gift = null;
        switch (getState()) {
            case 0:
                this.currentResponse = Arrays.asList("You can come to room <1409< a.k.a. CS lab and I can save your life.");
                break;
            case 1:
                double respProb = super.RANDOM.nextDouble();
                if (respProb < 0.1) {
                    gift = new Calculator("calc", null);
                    this.currentResponse = Arrays.asList("Here, this calculator will help you not fail!");
                }
                else if (respProb < 0.4) this.currentResponse = Arrays.asList("If you need help, I'll hang out in <1409<.");
                else this.currentResponse = Arrays.asList("You can do ittt!");
                break;
            default:
                this.currentResponse = Arrays.asList("I have nothing to say at this time.");
        }
        return gift;
    }
}
