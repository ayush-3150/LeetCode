package Leetcode.SlidingWindow;

public class MaximumSumOfSubArrayWithSizeK {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        int k = 3;
        System.out.println("maximum sum of subArray " + k + " is " + maxSum(arr, k));
    }

    public static int maxSum(int arr[], int k) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int len = arr.length;
        if (len == 0) {
            return -1;
        }
        while (j < len) {
            sum = sum + arr[j];
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                max = Math.max(max, sum);
                sum = sum - arr[i];
                i++;
                j++;
            }
        }

        return max;
    }

}

