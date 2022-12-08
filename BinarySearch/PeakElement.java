package Leetcode.BinarySearch;

public class PeakElement {
    public static void main(String[] args) {
        int[] arr={1,3,5,6,4,2,0};
        System.out.println(findPeakElement(arr));
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
