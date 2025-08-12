package ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeStrings {

    /*
    Design an algorithm to encode a list of strings to a single string.
    The encoded string is then decoded back to the original list of strings.

    Input: ["neet","code","love","you"]
    Output:["neet","code","love","you"]

    Input: ["we","say",":","yes"]
    Output: ["we","say",":","yes"]
    */

    public static String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for (String word: strs) {
            result.append(word).append("\n");
        }

        return result.toString();
    }

    public static List<String> decode(String str) {
        StringBuilder element = new StringBuilder();
        List<String> result = new ArrayList<>();
        for (Character ch: str.toCharArray()) {
            if (ch == '\n') {
                result.add(element.toString());
                element = new StringBuilder();
                continue;
            }
            element.append(ch);
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("neet", "code", "loves", "you");
        String encoding = encode(list);
        System.out.println(encoding);
        System.out.println("Decoded list is: " + decode(encoding));
    }

}
