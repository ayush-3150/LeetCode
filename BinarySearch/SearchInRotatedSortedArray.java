package Leetcode.BinarySearch;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int pivot = findPivot(arr);
        if (pivot == -1) {
            System.out.println(binarySearch(arr, target, 0, arr.length - 1));
        } else {
            int firstHalf = binarySearch(arr, target, 0, pivot);
            if (firstHalf != -1) {
                System.out.println(firstHalf);
            } else {
                int secondHalf = binarySearch(arr, target, pivot + 1, arr.length - 1);
                System.out.println(secondHalf);
            }
        }
    }

    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            if (arr[start] >= arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }


        }
        return -1;

    }

    static int binarySearch(int[] arr, int target, int start, int end) {

        // find whether the array is sorted in ascending or descending

        while (start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

        return -1;
    }
}



