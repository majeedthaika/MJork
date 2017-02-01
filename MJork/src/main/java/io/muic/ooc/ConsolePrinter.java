package io.muic.ooc;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ConsolePrinter {
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
                    cp.print(actionMatcher.group(0).replaceAll("#",""), Ansi.Attribute.CLEAR, Ansi.FColor.YELLOW, Ansi.BColor.BLACK);
                    cp.clear();
                    cp.print(sentence.substring(actionMatcher.end(),nounMatcher.start()));
                    cp.print(nounMatcher.group(0).replaceAll("<",""), Ansi.Attribute.CLEAR, Ansi.FColor.CYAN, Ansi.BColor.BLACK);
                    cp.clear();
                    cp.println(sentence.substring(nounMatcher.end()));
                } else {
                    cp.print(sentence.substring(0,nounMatcher.start()));
                    cp.print(nounMatcher.group(0).replaceAll("<",""), Ansi.Attribute.CLEAR, Ansi.FColor.CYAN, Ansi.BColor.BLACK);
                    cp.clear();
                    cp.print(sentence.substring(nounMatcher.end(),actionMatcher.start()));
                    cp.print(actionMatcher.group(0).replaceAll("#",""), Ansi.Attribute.CLEAR, Ansi.FColor.YELLOW, Ansi.BColor.BLACK);
                    cp.clear();
                    cp.println(sentence.substring(actionMatcher.end()));
                }
            } else if (action) {
                cp.print(sentence.substring(0,actionMatcher.start()));
                cp.print(actionMatcher.group(0).replaceAll("#",""), Ansi.Attribute.CLEAR, Ansi.FColor.YELLOW, Ansi.BColor.BLACK);
                cp.clear();
                cp.println(sentence.substring(actionMatcher.end()));
            } else if (noun) {
                cp.print(sentence.substring(0,nounMatcher.start()));
                cp.print(nounMatcher.group(0).replaceAll("<",""), Ansi.Attribute.CLEAR, Ansi.FColor.CYAN, Ansi.BColor.BLACK);
                cp.clear();
                cp.println(sentence.substring(nounMatcher.end()));
            } else {
                cp.println(sentence);
            }
        }
    }
}
