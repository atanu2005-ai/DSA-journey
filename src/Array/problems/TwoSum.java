package Array.problems;

import javax.naming.ldap.StartTlsRequest;
import java.util.*;

public class TwoSum {
    //Question 1: Find if there are 2 elements in the array which sum to target
    //Brute force
    //check each pair with nested loop that's it

    //better
    public static String better(int[] nums, int target) {
        //We will use hashSet to see if there exist any element which
        //equals to (target - crr element)
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int num : nums) {
            if(set.contains(target - num)) {
                return "Yes";
            }else {
                set.add(num);
            }
        }
        return "No";
    }
    //optimal
    //same complexity (O(nlogn)) but without using hashmap
    public static String optimal(int[] nums, int target) {
        //at first, we will sort the array in non-decreasing order
        //we will use two pointer to the start and to the end
        //if sum of nums[start] and nums[end] is less than target, we simply
        //more the start pointer to get a greater sum cause if we move end pointer
        //the sum will get smaller as the array is in ascending order.
        //vise versa for sum > target
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        Arrays.sort(nums);
        while(start < end) {
            int sum = nums[start] + nums[end];

            if(sum < target) {
                start++;
            }else if(sum > target) {
                end--;
            }else {
                return "Yes";
            }
        }
        return "No";
    }
    //Question 2: Find the two indexes where nums[i] + nums[j] = target. (it's granted that these two indices exist)
    //hashmap is the most optimal solution (for non-sorted array)
    public static void optimal2(int[] nums, int target) {
        int[] ans = new int[2];
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(map.containsKey(target - nums[i])) {
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                break;
            }else {
                map.put(nums[i], i);
            }
        }
        System.out.print("Optimal for Q2: " + ans[0] + ",");
        System.out.println(ans[1]);
    }
    public static void main(String[] args) {
        int[] arr = {2, 6, 5, 8, 11};
        int target = 17;
        System.out.println("Better for Q1: " + better(arr, target));
        System.out.println("Optimal for Q1: " + optimal(arr, target));
        optimal2(arr, target);

    }
}