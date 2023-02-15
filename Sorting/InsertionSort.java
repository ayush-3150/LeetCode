package Leetcode.Sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {20, 5, 2, 7, 6, 1, 0};

        insertionSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    //insertion sort
    //used if array elements are partially sorted
    // time complexity best-o(n) and worst case-o(n2)
    private static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
