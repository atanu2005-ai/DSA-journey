package Array.problems;
public class DeleteDuplicate {
    //Question : if there are k unique elements in an array return the array
    //where first k elements represents those all unique elements
    public static int remove_duplicate(int[] arr,  int n) {
        //brute force
        //1. add all unique elements in a set
        //2. swap array elements with set elements

        //optimal approach
        //we will take 2 pointers here
        int i = 0;
        for(int j = 1; j < n; j++) {
            if(arr[j] != arr[i]) {
                arr[i + 1] = arr[j];
                i++;
            }
        }
        return i + 1;
    }
    public static void main(String[] args) {

        int[] nums = {30, 25, 25, 25, 16, 16, 30};
        System.out.println(remove_duplicate(nums, nums.length));
    }
}