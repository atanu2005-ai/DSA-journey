package Array.problems;
public class move_zeros_to_end {
    //brute force approach is shit so directly approaching optimal
    public static void move_zeros(int[] arr, int n) {
        int j = - 1;
        for(int i = 0; i < n; i++) {
            if(arr[i] == 0) { //find the first occurrence of 0 and
                j = i;
                break;
            }
        }
        int i = j + 1; //start i from next to j
        while(i < n) {
            if(arr[i] != 0) { //if ith element is not 0 then swap with jth element
                arr[j] = arr[i];
                arr[i] = 0;
                j++;
            }
            i++;
        }
    }
    public static void main(String[] args) {
        int[] nums = {28, 0, 37, 0, 13, 0, 55, 78, 9};
        move_zeros(nums, nums.length);
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
    }
}