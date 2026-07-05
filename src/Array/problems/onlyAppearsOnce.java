package Array.problems;

import java.util.HashMap;

public class onlyAppearsOnce {
    //Every number appears twice only one number appears once, find that number

    //brute force
    //for each nums[i] do linear search and count how many times it appeared.
    //after the search if count = 1 return nums[i]

    //better
    public static int better(int[] nums) {
        //we and going to simply map the elements
        //after mapping the key with value of 1 is the answer
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (map.get(num) == 1) return num;
        }
        return -1;
    }

    //optimal
    public static int optimal(int[] nums) {
        //easiest shit ever with XOR
        //just xor all elements and remaining element is the ans lol
        int n = nums.length;
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 4, 4,};
        System.out.println("Better: " + better(arr));
        System.out.println("Optimal: " + optimal(arr));
    }
}