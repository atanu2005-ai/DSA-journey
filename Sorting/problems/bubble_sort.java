import java.util.*;

public class bubble_sort {
    public static int[] bubble_sort(int[] nums) {
        int n = nums.length;
        //bubble sort :
        //1. bubble sort is a process between a pair of elements,
        //it compares two adjasent elements ans swaps them IF fight elements is smaller
        //2. After iterating through the array and doing the operation decrease i by i cause
        // the greatest value gets placed at ith position after every passing
        for(int i = n - 1; i > 0; i--) {
            for(int j = 1; j <= i; j++) {
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
        int[] nums = {28, 25, 37, 5, 13, 32, 55, 78, 9};
        bubble_sort(nums);
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
