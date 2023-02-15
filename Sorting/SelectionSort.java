package Leetcode.Sorting;


public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {20, 5, 2, 7, 6, 1, 0};

        selectionSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    //selection sort
    // time complexity - worst and best case == o(n2)
    public static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - i - 1;
            int maxIndex = getMaxIndex(arr, 0, last);
            swap(arr, maxIndex, last);
        }
    }

    //swap maximum element with last indexed element
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    //Gets index of maximum element
    private static int getMaxIndex(int[] arr, int start, int last) {
        int max = start;
        for (int i = start; i <= last; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }
}
