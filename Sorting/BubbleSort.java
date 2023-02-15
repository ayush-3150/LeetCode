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

    //Time complexity: best case-o(n) worst case o(n2)
    //space complexity:o(1)
    public static void bubbleSort(int arr[]) {
        int n = arr.length;
        boolean swapped;


        for (int i = 0; i < n; i++) {
            swapped = false;

            //check if j-1 element is greater than j if yes then swap both number
            //every pass largest element of particular slot of an array will be at the end
            for (int j = 1; j < n - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}
