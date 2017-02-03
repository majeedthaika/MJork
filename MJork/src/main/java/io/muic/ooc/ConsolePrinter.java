package io.muic.ooc;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ConsolePrinter {
    public static void printStartMessage() {
        ColoredPrinter cp = new ColoredPrinter.Builder(1,false).build();
        cp.println("\033\143");
        cp.println("Welcome to MUIC 568 CS Game!!!", Attribute.BOLD, FColor.RED, BColor.WHITE);
        cp.clear();
        cp.println("");
        cp.print("You have woken up from deep sleep...", Attribute.BOLD, FColor.WHITE, BColor.RED);
        cp.clear();
        cp.println("\n");
    }
    public static void printWithColor(List<String> sentences){
        for (String sentence : sentences) {
            Pattern actionRegex = Pattern.compile("#\\w+#");
            Matcher actionMatcher = actionRegex.matcher(sentence);
            boolean action = actionMatcher.find();

            Pattern nounRegex = Pattern.compile("<\\w+<");
            Matcher nounMatcher = nounRegex.matcher(sentence);
            boolean noun = nounMatcher.find();

            ColoredPrinter cp = new ColoredPrinter.Builder(1,false).build();
            if (action && noun) {
                if (actionMatcher.start()<nounMatcher.start()){
                    cp.print(sentence.substring(0,actionMatcher.start()));
                    cp.print(actionMatcher.group(0).replaceAll("#",""), Attribute.CLEAR, FColor.YELLOW, BColor.BLACK);
                    cp.clear();
                    cp.print(sentence.substring(actionMatcher.end(),nounMatcher.start()));
                    cp.print(nounMatcher.group(0).replaceAll("<",""), Attribute.CLEAR, FColor.CYAN, BColor.BLACK);
                    cp.clear();
                    cp.println(sentence.substring(nounMatcher.end()));
                } else {
                    cp.print(sentence.substring(0,nounMatcher.start()));
                    cp.print(nounMatcher.group(0).replaceAll("<",""), Attribute.CLEAR, FColor.CYAN, BColor.BLACK);
                    cp.clear();
                    cp.print(sentence.substring(nounMatcher.end(),actionMatcher.start()));
                    cp.print(actionMatcher.group(0).replaceAll("#",""), Attribute.CLEAR, FColor.YELLOW, BColor.BLACK);
                    cp.clear();
                    cp.println(sentence.substring(actionMatcher.end()));
                }
            } else if (action) {
                cp.print(sentence.substring(0,actionMatcher.start()));
                cp.print(actionMatcher.group(0).replaceAll("#",""), Attribute.CLEAR, FColor.YELLOW, BColor.BLACK);
                cp.clear();
                cp.println(sentence.substring(actionMatcher.end()));
            } else if (noun) {
                cp.print(sentence.substring(0,nounMatcher.start()));
                cp.print(nounMatcher.group(0).replaceAll("<",""), Attribute.CLEAR, FColor.CYAN, BColor.BLACK);
                cp.clear();
                cp.println(sentence.substring(nounMatcher.end()));
            } else {
                cp.println(sentence);
            }
        }
    }
}
