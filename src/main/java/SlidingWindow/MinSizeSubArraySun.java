package SlidingWindow;

import javax.swing.text.html.MinimalHTMLWriter;

public class MinSizeSubArraySun {
    public static int findMinimumSubArray(int k , int[] array) {
        int windowStart = 0;
        int minLength = Integer.MAX_VALUE;
        int windowSum = 0;
        for (int i = 0; i < array.length; i++) {
            windowSum += array[i];
            while(windowSum >= k) {
                minLength = Math.min(minLength, i - windowStart + 1);
                windowSum -= array[windowStart];
                windowStart ++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int result = MinSizeSubArraySun.findMinimumSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySun.findMinimumSubArray(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySun.findMinimumSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
    }
}
