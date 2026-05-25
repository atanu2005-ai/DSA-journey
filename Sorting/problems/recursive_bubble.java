import java.util.*;
public class recursive_bubble {
    public static void bubble_sort(int[] arr, int i, int end) {
        if(end == 0) return; //to stop when outter loop reaches end

        if(i > end) {
            bubble_sort(arr, 1, end - 1); //when inner loop reaches outer loop limit
            return;
        }
        if(arr[i] < arr[i - 1]) { //sorting adjasent with swaping
            int temp = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = temp;
        }
        bubble_sort(arr, i + 1, end); //calling next inner loop iteration
    }
    public static void main(String[] args) {
        int[] nums = {28, 25, 37, 5, 13, 32, 55, 78, 9};
        bubble_sort(nums, 1, nums.length - 1);
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
    //5 4 3 2 1
    //4 3 2 1 5
    //4 2 1 3 5
}    