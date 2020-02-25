package TwoPointers;

class ShortestWindowSort {

    public static int sort(int[] arr) {
        int low =0; int high = arr.length - 1;
        while (low < arr.length -1 && arr[low] <= arr[low+1])
            low ++;
        //if we have reached the end of the array
        if(low == high)
            return 0;
        //find the first number out of sorting order from the hgih end
        while(high > 0 && arr[high] >= arr[high - 1]) {
            high --;
        }

        //find minimum and maximum of subarray
        int subArrayMax = Integer.MIN_VALUE;
        int subArrayMin = Integer.MAX_VALUE;
        for(int k = low; k <= high; k++) {
            subArrayMax = Math.max(subArrayMax, arr[k]);
            subArrayMin = Math.min(subArrayMin, arr[k]);
        }

        while(low > 0 && arr[low-1] > subArrayMin) {
            low--;
        }
        while(high < arr.length-1 && arr[high + 1] < subArrayMax) {
            high ++;
        }
        return high - low + 1;
    }

    public static void main(String[] args) {
        System.out.println(ShortestWindowSort.sort(new int[] { 1, 2, 5, 3, 7, 10, 9, 12 }));
        System.out.println(ShortestWindowSort.sort(new int[] { 1, 3, 2, 0, -1, 7, 10 }));
        System.out.println(ShortestWindowSort.sort(new int[] { 1, 2, 3 }));
        System.out.println(ShortestWindowSort.sort(new int[] { 3, 2, 1 }));
    }
}