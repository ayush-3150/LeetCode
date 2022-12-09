package Leetcode.BinarySearch;

public class FindInMountain {
    public static void main(String[] args) {
        int arr[]={0,1,2,4,2,1};
        int target=3;
        int peak=findPeakElement(arr);
        int firstHalf=orderAgnosticBS(arr,target,0,peak);
        if(firstHalf!=-1){
            System.out.println(firstHalf);
        }
        else{
            int secondHalf=orderAgnosticBS(arr,target,peak+1,arr.length-1);
            System.out.println(secondHalf);
        }

    }

    static int orderAgnosticBS(int[] arr, int target,int start,int end) {

        // find whether the array is sorted in ascending or descending
        boolean isAsc = arr[start] < arr[end];

        while(start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    static int findPeakElement(int[] arr){
        int start=0;
        int end=arr.length-1;
        while(start<end){
            /* find mid element */
            int mid=start+(end-start)/2;

            /* decreasing order */
            if(arr[mid]>arr[mid+1]){
                end=mid;
            }
            else
            {
                start=mid+1;
            }

        }
        return start;
    }
}
