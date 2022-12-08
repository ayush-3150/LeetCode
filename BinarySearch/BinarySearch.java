package Leetcode.BinarySearch;
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={1,3,5,6};
        System.out.println("index is of target element "+binarySearch(arr,5));

    }

    static int binarySearch(int[] arr,int target){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            //find mid element
            int mid=start+(end-start)/2;

            //if target is greater than mid element than search for right part of the mid element
             if(target>arr[mid]){
                start=mid+1;
            }
             //if target is smaller than mid element than search for left part of the  mid element
            else if(target<arr[mid])
            {
                end=mid-1;
            }
            //if target equals to middle then return mid element
            else{
                    return mid;
            }
        }
        //if target is not present in array return -1;
        return -1;
    }
}
