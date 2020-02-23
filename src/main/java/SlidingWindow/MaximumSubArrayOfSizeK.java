package SlidingWindow;

public class MaximumSubArrayOfSizeK {
    public static int findMaxSubArrayOfSizeK(int k, int[] array) {
        int windowStart = 0;
        int windowSum = 0;
        int maxSum = 0;
        for(int i = 0; i < array.length; i++) {
            windowSum += array[i];
            if (i > k-1) {
                windowSum -= array[windowStart];
                windowStart += 1;
                maxSum = Math.max(windowSum, maxSum);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + MaximumSubArrayOfSizeK.findMaxSubArrayOfSizeK(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray of size K: "
                + MaximumSubArrayOfSizeK.findMaxSubArrayOfSizeK(2, new int[] { 2, 3, 4, 1, 5 }));
    }
}
