public class quick_sort {
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low]; //choses low element as the pivot and does the process
        int i = low;
        int j = high;
        while(i < j) {//runs until they cross each other
            //this while loop find the first value of i(left to right moving) where arr[i] is greater than pivot
            while(i <= high - 1 && arr[i] <= pivot) {
                i++;
            }

            //this loop find the first j(from right to left) where arr[j] > pivot
            while(j >= low + 1 && arr[j] > pivot) {
                j--;
            }

            if(i < j) {//if i and j didn't cross swap the elements
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            //now repeat this process for all i and j untill they cross each other
        }

        //now after all this operation we know the right pos of pivot
        //and that is j so swap the pivot(arr[low]) with arr[j]
        int tmp = arr[low];
        arr[low] = arr[j];
        arr[j] = tmp;
        return j;
    }
    public static void quick(int[] arr, int low, int high) {
        if(low < high) { //stop when low = high means partition has became 1 element
            int pidx = partition(arr, low, high); //returns pivot final position index
            quick(arr, low, pidx - 1);//works from low to pivot index - 1
            quick(arr, pidx + 1, high);//works from pivot index + 1 to high
        }
    }
    public static void main(String[] args) {
        int[] nums = {28, 25, 37, 5, 13, 32, 55, 78, 9};
        quick(nums, 0, nums.length - 1);
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }    
}
