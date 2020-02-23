package SlidingWindow;

import java.util.*;

class MaxFruitCountOf2Types {
    public static int findLength(char[] arr) {
        int windowStart = 0;
        int maxLength = 0;
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            var leftChar = arr[i];
            frequencyMap.put(leftChar, frequencyMap.getOrDefault(leftChar, 0) + 1);
            while (frequencyMap.size() > 2) {
                var character = arr[windowStart];
                frequencyMap.put(character, frequencyMap.get(character) -1);
                if(frequencyMap.get(character) == 0)
                    frequencyMap.remove(character);
                windowStart +=1;
            }
            maxLength = Math.max(maxLength, i-windowStart+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
    }
}