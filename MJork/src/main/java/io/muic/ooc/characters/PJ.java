package io.muic.ooc.characters;

import io.muic.ooc.items.Item;
import io.muic.ooc.items.Car;

import java.util.Arrays;

public class PJ extends NPC {
    public PJ() {
        super("pj", 0);
    }

    public Item updateCurrentResponse() {
        Item gift = null;
        switch (getState()) {
            case 0:
                currentResponse = Arrays.asList("Shitttt, I started this HW 2 weeks ago and still need to rely on tokens...");
                break;
            case 1:
                double respProb = super.RANDOM.nextDouble();
                if (respProb < 0.1) {
                    currentResponse = Arrays.asList("Hey man, you can #use# my <car< anytime as thanks for all your help.",
                                                         "It will save you #energy# to travel to <muic<.");
                    gift = new Car("car", null);
                } else if (respProb < 0.4) {
                    currentResponse = Arrays.asList("Yo dude, you can usually find me dying in <1408<.");
                } else {
                    currentResponse = Arrays.asList("You know what's weird... Blah blah blah");
                }
                break;
            default:
                currentResponse = Arrays.asList("I have nothing to say at this time.");
        }
        return gift;
    }
}
