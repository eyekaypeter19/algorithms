package SlidingWindow;

import java.util.*;

class NoRepeatSubstring {
    public static int findLength(String str) {
        int windowStart = 0; int maxLength = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        for(int i =0; i < str.length(); i++){
            Character ch = str.charAt(i);
            if (charIndexMap.containsKey(ch)){
                windowStart = Math.max(windowStart, charIndexMap.get(ch) + 1);
            }
            charIndexMap.put(ch, i);
            maxLength = Math.max(maxLength, i - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
    }
}