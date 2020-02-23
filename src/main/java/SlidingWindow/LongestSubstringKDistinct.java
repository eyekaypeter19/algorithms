package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        int maxLength = 0; int windowStart = 0;
        if (str == null || str.isEmpty() || str.length() < 1)
            throw new IllegalArgumentException("Invalid String Parameter");
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char character = str.charAt(i);
            charFrequencyMap.put(character, charFrequencyMap.getOrDefault(character, 0) + 1);
            while(charFrequencyMap.size() > k) {
                char leftChar = str.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart +=1;
            }
            maxLength = Math.max(maxLength, i - windowStart + 1);
        }
        return maxLength;
    }


    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }
}
