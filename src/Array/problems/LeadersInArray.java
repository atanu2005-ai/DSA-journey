package Array.problems;

import java.util.ArrayList;

public class LeadersInArray {
    //Question: Leaders in array: return an list of elements in arr which has smaller values in the right of arr.

    //Brute force:
    //1. traverse the array and for each element do linear search for greater element from i + 1 to n - 1.
    //if that element doesn't have any greater element in the right add it to ans list.

    //Optimal:
    public static void optimal(int[] nums, int n) {
        //while traversing from right to left, for each element we compare if the largest element in it's right is greater
        //than it or not. If not then we can add it to ans and update max otherwise we will just update the max value.
        if(n == 1) {
            System.out.println(nums[0]);
            return;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int i = n - 1; i >= 0; i--) {
            if(nums[i] > max) {
                ans.add(nums[i]);
            }
            max = Math.max(max, nums[i]);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int[] arr = {10, 22, 12, 3, 0, 6};
        optimal(arr, arr.length);
    }
}