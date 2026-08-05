package Array.problems;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {
    //Question: Find the longest consecutive sequence in an array

    //Brute force:
    //for each element, find if there is any element with +1 value and if yes then +1 to crr length and
    //update the max length.

    //Better:
    public static int better(int[] nums, int n) {
        if(n == 1) return 1;
        // Sort the array
        Arrays.sort(nums); //[1, 1, 1, 2, 2, 2, 3, 3, 4, 100, 100, 101, 101, 102]
        // Now for each fresh start, we see if the current element is +1 than leftSmallest or not
        //if the crr element is equal to smallest we ignore as it doesn't add up to the length
        //if the dif is exact 1 then we update the length
        //if the dif is >1 means this sequence has reached its end, and we start fresh from the next element.
        int leftSmallest = nums[0];
        int maxLength = 1;
        int crrLength = 1;
        for(int i = 1; i < n; i++) {
            if(nums[i] == leftSmallest) continue;

            if(nums[i] - leftSmallest == 1) {
                crrLength++;
                maxLength = Math.max(maxLength, crrLength);
            }else {
                crrLength = 1;
                leftSmallest = nums[i];
            }

        }
        return maxLength;

    }

    //Optimal:
    public static int optimal(int[] nums, int n) {
        if(n == 1) return 1;
        //First we store the elements in a set
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        //Now instead of checking if there is an +1 value for each element we only move in the loop ONLY IF
        //there is no -1 v=element of the crr element. So we end up starting to find +1 value only from the
        //possibly smallest element in the valid sequence.
        int maxLength = 1;
        for(int crr : set) {
            if(!set.contains(crr - 1)) { //only move further IF -1 element doesn't exist
                int crrLength = 1;
                int x = crr; //store the current element is x

                while(set.contains(x + 1)) { //keep searching in the set while we have the valid element
                    x++;
                    crrLength++;
                }
                maxLength = Math.max(maxLength, crrLength); //update the max length
             }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        int[] arr = {100, 102, 101, 100, 101, 4, 3, 2, 3, 2, 1, 1, 1, 2};
        System.out.println("Better: " + better(arr, arr.length));
        System.out.println("Optimal: " + optimal(arr, arr.length));
    }
}
