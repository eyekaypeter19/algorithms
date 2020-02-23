package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {

    public static int findLength(String str, int k) {
        int windowStart = 0; int maxLength = 0; int maxRepeatingletterCount = 0;
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char rChar = str.charAt(i);
            charFreqMap.put(rChar, charFreqMap.getOrDefault(rChar, 0) + 1);
            maxRepeatingletterCount = Math.max(maxRepeatingletterCount, charFreqMap.get(rChar));
            if(i - windowStart + 1 - maxRepeatingletterCount > k) {
                char lchar = str.charAt(windowStart);
                charFreqMap.put(lchar, charFreqMap.get(lchar) - 1);
                windowStart++;
            }
            maxLength = Math.max(maxLength, i-windowStart+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(CharacterReplacement.findLength("aabccbb", 2));
        System.out.println(CharacterReplacement.findLength("abbcb", 1));
        System.out.println(CharacterReplacement.findLength("abccde", 1));
    }
}
