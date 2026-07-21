package Array.problems;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPermutation {
    //Question: Find the next permutation of the array
    //Brute force

    //generate all the permutation of the array
    //do a linear search and return the next permutation
    //generating all permutation is very complex using recursion

    //Optimal
    public static int[] Optimal(int[] nums, int n) {
        //example array:
        /*[2, 1, 3]         all possible permutations: 1 2 3
                                                      1 3 2
                                                      2 1 3
                                                      2 3 1
                                                      3 1 2
                                                      3 2 1     */
        //the number is starting from smallest (non-decreasing order) and ending
        //as the largest. the next permutation of [2 1 3] is [2 3 1] which is the closest biggest number.
        if(n < 2) return nums;
        //we have to find the dip. means while traversing from end - 1 index to left, we would
        //find where the current element got smaller than the previous element & store the index
        //ex array: [2 1 5 4 3 0 0]
        int idx = -1;
        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                idx = i; //[2 1 5 4 3 0 0]
                         //  ___
                break;
            }
        }
        //if there is no idx where it dips then it means it's the last permutation of the numbers
        //so we can go back to the first permutation which is just the sorted order of the numbers
        if(idx == -1) {
            Arrays.sort(nums);
            return nums;
        }
        //now to find the closest next perm we have to make the number larger but the smallest possible.
        for(int i = n - 1; i > idx; i--) {
            if(nums[i] > nums[idx]) { //we need a value which is greater than nums[idx] bt the smallest
                                      //possible. while traversing from end, the first value greater than
                                      //nums[idx] will always be the smallest
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                break;
            }
        }
        //now to keep the number smallest possible, we will keep the rest part from idx + 1 sorted
        int low = idx + 1;
        int high = n - 1;
        while(low < high) {
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 4, 3, 0, 0};
        int[] ans = Optimal(arr, arr.length);
        for (int an : ans) {
            System.out.print(an + " ");
        }
    }
}