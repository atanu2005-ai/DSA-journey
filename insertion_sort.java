import java.util.*;
public class insertion_sort {
    public static int[] insertion_sort(int[] nums) {
        int n = nums.length;
        //insertion sort :
        //1. it chooses an element and places it to it's correct position.
        //2. it gradually increases the array window and starting from the last
        //index of the window, it swaps it with the left elemenet if it's greater than
        //the left element.
        for(int i = 0; i < n; i++) {
            int j = i;
            while(j > 0 && nums[j] < nums[j - 1]) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
                j--;
            }
        } 
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {1, 4, 5, 2, 10, 20, 2, 30, 5, 10, 20, 30};
        insertion_sort(nums);
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
