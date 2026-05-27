package Sorting.problems;

public class selection_sort {
    public static int[] selection_sort(int[] nums) {
        //Selection sorting : 
        // 1. Selects the smallest element and brings it to the start.
        //2. Mosves the start point one step forward and repeats the process until start
        //point reaches the end.
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                //swap jth element with ith element if its smaller
                if(nums[j] < nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {1, 4, 5, 2, 10, 20, 2, 30, 5, 10, 20, 30};
        selection_sort(nums);
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
