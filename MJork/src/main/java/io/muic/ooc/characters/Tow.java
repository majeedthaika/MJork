package io.muic.ooc.characters;

import io.muic.ooc.items.Item;
import io.muic.ooc.items.Calculator;

import java.util.Arrays;

public class Tow extends NPC {
    public Tow() {
        super("tow", "src/assets/tow", 0);
    }

    public Item updateCurrentResponse() {
        Item gift = null;
        switch (getState()) {
            case 0:
                this.currentResponse = Arrays.asList("You can come to <room 1409< a.k.a. CS lab and I can save your life.");
                break;
            case 1:
                double respProb = super.RANDOM.nextDouble();
                if (respProb < 0.1) {
                    gift = new Calculator();
                    this.currentResponse = Arrays.asList("Hey man, you can #use# my <car< anytime as thanks for all your help.",
                            "It will save you #energy# to travel to <muic<.");
                }
                else if (respProb < 0.4) this.currentResponse = Arrays.asList("Yo dude, you can usually find me dying in <1409<.");
                else this.currentResponse = Arrays.asList("You know what's weird... Blah blah blah");
                break;
            default:
                this.currentResponse = Arrays.asList("I have nothing to say at this time.");
        }
        return gift;
    }
}
