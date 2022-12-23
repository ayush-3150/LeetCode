package Leetcode.SlidingWindow;

import java.util.ArrayList;
import java.util.LinkedList;

public class MaximumOfAllSubArrayOfKSize {
    public static void main(String[] args) {
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int i = 0, j = 0;
        ArrayList<Integer> al = new ArrayList<>();
        LinkedList<Integer> ll = new LinkedList<>();
        while (j < arr.length) {
            while (ll.size() > 0 && ll.getLast() < arr[j]) {
                ll.removeLast();
            }
            ll.add(arr[j]);
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                al.add(ll.getFirst());
                if (arr[i] == ll.getFirst()) {
                    ll.removeFirst();
                }
                i++;
                j++;
            }
        }

        for (Integer element : al) {
            System.out.print(element + " ");
        }

    }


}
