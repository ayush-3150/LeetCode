package Leetcode.BinarySearch;

public class InfiniteArray {
    public static void main(String[] args) {
        int arr[]={1,2,3,55,62,778,1000};
        System.out.println("index is: "+find(arr,55));
    }

    static int find(int[] arr,int target){
        int start=0;
        int end=1;

        while(target>arr[end]){
            int newStart=end+1;
            end=end+2*((end-start+1));
            start=newStart;
        }
        return  binarySearch(arr,target,start,end);
    }

    static int binarySearch(int[] arr,int target,int start,int end){

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
