package Array.problems;
public class MaxSubarraySum {
    //Question 1: Find max sum of a subarray.

    //Better
    //Access all subarrays using nested for loop
    //add nums[j] to crrsum and update maxsum sum using it.

    //Optimal
    public static int optimal1(int[] nums, int n) {
        //We will use kadane's algorithm here which is basically resetting the sum to
        //the crr element whenever the sum is getting smaller after the sum
        if(n == 1) return nums[0]; //return the single element for 1 length array
        int crr = nums[0]; //initialize current sum & max sum with starting element
        int max = nums[0];
        for(int i = 1; i < n; i++) { //notice starting from idx 1 as initialized with starting element already
            crr = Math.max(nums[i], crr + nums[i]); //basically we have the max sum already and if the crr
                                                    //element is decreasing the crr sum(means this decreasing sum
                                                    // can not surpass the existing max sum)
                                                    // we better start a new
                                                    //counting from it to see if it surpasses the already existing
                                                    //max sum.
            max = Math.max(max, crr); //update max
        }
        return max;
    }

    //Question 2: Find one of the subarray with the max sum
    public static int[] optimal2(int[] nums, int n) {
        int[] ans = new int[2];
        if(n == 1) return ans;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int start = -1; int end = -1;

        for(int i = 0; i < n; i++) {
            if(sum == 0) {
                start = i;
            }
            sum += nums[i];
            if(sum < 0) {
                sum = 0;
            }
            if(sum > max) {
                max = sum;
                end = i;
            }

        }
        ans[0] = start; ans[1] = end;
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Question 1 optimal: " + optimal1(arr, arr.length));
        int[] ans = optimal2(arr, arr.length);
        System.out.println("Question 2 optimal: " + ans[0] + ", " + ans[1]);
    }
}