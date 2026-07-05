package Array.problems;
public class maxConsecutiveOnes {
    //only optimal solution
    public static int optimal(int[] nums) {
        //count 1s and store max, whenever 0 appears, set count as 0
        int n = nums.length;
        int count = 0;
        int max = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] == 1) {
                count++;
                max = Math.max(max, count);
            }else {
                count = 0;
            }
        }
        return max;

    }
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1};
        System.out.println(optimal(arr));
    }
}