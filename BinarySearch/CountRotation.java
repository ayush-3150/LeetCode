package Leetcode.BinarySearch;

public class CountRotation {
    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(countOfRotation(arr));
    }

    static int countOfRotation(int[] arr) {
        int pivot = findPivot(arr);
        int ans = pivot == -1 ? 0 : (pivot + 1) % arr.length;
        return arr[ans];
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
}
