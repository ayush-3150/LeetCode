package Leetcode.BinarySearch;

import java.util.Arrays;

public class SearchIn2DMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[] index = searchInMatrix(arr, 4);
        System.out.println("Index of searched element " + Arrays.toString(index));
    }

    static int[] searchInMatrix(int[][] arr, int target) {
        int row = 0;
        int column = arr.length - 1;
        while (row < arr.length - 1 && column >= 0) {
            if (target == arr[row][column]) {
                return new int[]{row, column};
            }
            if (target > arr[row][column]) {
                row++;
            } else {
                column--;
            }
        }
        return new int[]{-1, -1};
    }
}
