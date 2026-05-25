public class recursive_insertion {
    public static void insertion(int[] arr, int i, int j, int end) {
        if(i > end) return;//return when outer loop reaches end of array

        if(j > 0 && arr[j] < arr[j - 1]) {//sorting between jth and j - 1th element
            int temp = arr[j];
            arr[j] = arr[j - 1];
            arr[j - 1] = temp;
            insertion(arr, i, j - 1, end); //updating j
        }else {
            insertion(arr, i + 1, i + 1, end); //updating the outer loop and setting i = j
            //note for j to match current i we have to do
            //+1 with old i
        }
    }
    public static void main(String[] args) {
        int[] nums = {28, 25, 37, 5, 13, 32, 55, 78, 9};
        insertion(nums, 1, 1, nums.length - 1);
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
    
}
