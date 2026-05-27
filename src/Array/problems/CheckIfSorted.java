package Array.problems;
public class CheckIfSorted {
    public static boolean sorted(int[] arr, int n) {
        //Question : check if the array is sorted or not
        //starting from 2nd element, if current element is less than previous element
        //it is not sorted, simple as that
        boolean flag = true;
        for(int i = 1; i < n; i++) {
            if(arr[i] < arr[i - 1]) {
                flag = false;
                break;
            }
        }
        return flag;
    }
    public static void main(String[] args) {
        int[] nums = {28, 25, 37, 5, 13, 32, 55, 78, 9};
        if(sorted(nums, nums.length)) {
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }
}