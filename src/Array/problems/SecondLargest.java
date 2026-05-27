package Array.problems;

public class SecondLargest {
    public static int second(int[] arr, int n) {
        //brute force:
        //1. Sort the array
        //2. set max = arr[n -1]
        //3. Traverse from second last index to first and pick the one less than max

        //optimal approach

        //set largest as arr[0]
        int largest = arr[0];
        //set 2nd largest as -1
        int second_largest = -1;
        for(int i = 0; i < n; i++) {
            //now traverse and WHENEVER element is greater than largest,
            //set second largest as the current largest and set largest as the new greater element
            if(arr[i] > largest) {
                second_largest = largest;
                largest = arr[i];
            }
        }
        return second_largest;
    }
    public static void main(String[] args) {

        int[] nums = {28, 25, 37, 5, 13, 32, 55, 78, 9};
        second(nums, nums.length);
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}