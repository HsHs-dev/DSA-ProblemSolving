package ArraysAndHashing;

import java.util.*;

public class GroupAnagrams {

    /*
    Given an array of strings strs, group all anagrams together into sublists.
    You may return the output in any order.

    An anagram is a string that contains
    the exact same characters as another string,
    but the order of the characters can be different.

    Input: strs = ["act","pots","tops","cat","stop","hat"]
    Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]

    Input: strs = ["x"]
    Output: [["x"]]

    Input: strs = [""]
    Output: [[""]]
    */

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<Integer, List<String>> anagrams = new HashMap<>();
        for (String word: strs) {
            int hashVal = getHashVal(word);
            if (!anagrams.containsKey(hashVal)) {
                anagrams.put(hashVal, new ArrayList<>());
            }
            anagrams.get(hashVal).add(word);
        }

        return new ArrayList<>(anagrams.values());
    }

    private static int getHashVal(String word) {

        int[] freqs = new int[26];

        for (char c: word.toCharArray()) {
            freqs[c - 'a']++;
        }

        return Arrays.hashCode(freqs);
    }

    public static void main(String[] args) {
        String[] input = {"act","pots","tops","cat","stop","hat"};

        System.out.println(groupAnagrams(input));
        // output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
    }

}
