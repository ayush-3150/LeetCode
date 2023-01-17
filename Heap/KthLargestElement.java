package Leetcode.Heap;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int arr[] = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(arr, k));
    }

    public static int findKthLargest(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<Integer> p1 = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            p1.add(arr[i]);
            if (p1.size() > k) {
                p1.remove();

            }
        }
        return p1.peek();
    }
}
