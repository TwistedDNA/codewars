package active.learning.arrays;

public class MaximumSubArraySum {
    public static int sequence(int[] arr) {
        int maxSum = 0;
        int sum = 0;
        for (int e : arr) {
            sum += e;
            if (sum > maxSum) {
                maxSum = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}
