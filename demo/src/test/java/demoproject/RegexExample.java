package demoproject;
import java.util.regex.*;

public class RegexExample {
    public static void main(String[] args) {
        // Example 1: Matching a pattern
        String regex = "\\d+"; // Matches one or more digits
        String input = "123abc456";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        
        System.out.println("Matches: " + matcher.matches()); // false
        
        // Example 2: Finding occurrences
        while (matcher.find()) {
            System.out.println("Found: " + matcher.group());
        }

        // Example 3: Replace
        String replaced = matcher.replaceAll("#");
        System.out.println("Replaced String: " + replaced); // abc#
    }
}

