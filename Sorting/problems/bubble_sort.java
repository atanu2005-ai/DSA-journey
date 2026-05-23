import java.util.*;

public class bubble_sort {
    public static int[] bubble_sort(int[] nums) {
        int n = nums.length;
        //bubble sort :
        //1. bubble sort is a process between a pair of elements,
        //it compares two adjasent elements ans swaps them IF fight elements is smaller
        //2. After iterating through the array and doing the operation inceasing i by 1
        //and repeat the process
        for(int i = 1; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {1, 4, 5, 2, 10, 20, 2, 30, 5, 10, 20, 30};
        bubble_sort(nums);
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
