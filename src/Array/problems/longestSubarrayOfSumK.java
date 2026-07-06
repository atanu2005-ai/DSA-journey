package Array.problems;
import java.util.*;
public class longestSubarrayOfSumK {
    //Question: Find the longest subarray with sum k
    //brute force
    //access all subarrays
    //calculate sum of them, if sum == k set max length as crr length

    //better
    //NOTE: This is the most optimal approach for all positive & negative numbers.
    public static int better(int[] nums, int k) {
        //We will be needed a hashmap for prefix sum for each index.
        HashMap<Long, Integer> premap = new HashMap<>();
        long sum = 0;
        int n = nums.length;
        int maxLen = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            if(sum == k) { //if sum till an index is k then we must consider the length from start to that idx
                maxLen = Math.max(maxLen, i + 1);
            }
            long rem = sum - k; //to see if there is any existing prefix sum with sum - k
            if(premap.containsKey(rem)) {
                maxLen = Math.max(maxLen, i - premap.get(rem));
            }
            //NOTE: if there are 0s in the array we must pick the leftmost index for the same sum to get the
            //longest subarray so when sum remains same (for element 0) we will ignore it so that
            //the hashed index for that sum remains the leftmost.
            if(premap.containsKey(sum)) {
                continue;
            }else {
                premap.put(sum, i);
            }

        }

        return maxLen;
    }
    //Optimal
    //NOTE: Only for positive values
    public static int optimal(int[] nums, int k) {
        //We will use dynamic sliding window here
        //we will move right pointer and whenever sum is greater than k we will move left pointer
        int n = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int maxLen = 0;
        while(left <= right && right < n) {
            sum += nums[right];
            if(sum == k) {
                maxLen = Math.max(maxLen, (right - left) + 1);
            }
            while(sum > k && left <= right) { //subtract left value and move left until sum is <= k
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 1, 1, 3, 3};
        int k = 3;
        System.out.println("Better: " + better(arr, k));
        System.out.println("Optimal: " + optimal(arr, k));
    }
}