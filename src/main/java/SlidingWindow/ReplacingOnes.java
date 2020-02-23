package SlidingWindow;

class ReplacingOnes {
    public static int findLength(int[] arr, int k) {
        int windowStart = 0; int maxOnesCount = 0; int maxLength = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 1)
                maxOnesCount ++;
            if (i - windowStart + 1 - maxOnesCount > k){
                if(arr[windowStart] == 1){
                    maxOnesCount--;
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, i - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
        System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
    }
}
