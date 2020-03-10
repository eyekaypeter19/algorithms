package FastAndSlowPointers;

public class HappyNumbers {

    private static boolean find(int num) {
        int fast  = num;
        int slow = num;

        do {
            slow = findSquareSum(slow);
            fast = findSquareSum(findSquareSum(fast));
    } while (fast != slow) ;
        return slow == 1;
    }

    private static int findSquareSum(int num) {
        int sum = 0;
         while (num > 0) {
             int remainder = num % 10;
             remainder = remainder * remainder;
             sum += remainder;
             num = num / 10;
         }
         return sum;
    }
    public static void main(String[] args) {
        System.out.println(HappyNumbers.find(23));
        System.out.println(HappyNumbers.find(12));
    }
}
