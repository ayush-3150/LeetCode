package Leetcode.Sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {20, 5, 2, 7, 6, 1, 0};
        System.out.print("Sorted Array: ");
        bubbleSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
}
