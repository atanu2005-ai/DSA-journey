package Array.problems;
public class sortArrayOf0s1s2s {
    //Question: Sort an array of only 0s, 1s and 2s without using any in built method and with O(n)
    //complexity.

    //Brute force
    //We know brute force sorting, let's not talk about it.

    //Better
    //track a counter of 0s, 1s and 2s in the array
    //Iterate 3 loops:
    //one for 0s from 0 to 0_count
    //then for 1s from (0_count + 1) to 1_count
    //last one for 2s from (1_count + 1) to end.

    //Optimal
    public static void dnf(int[] nums, int n) {
        //we will use Dutch National Flag algorithm here. It is a 3 pointer technique.
        //consider visiting stiver's video again if forgot.
        //we assume hypothetically:
        // anything behind low is all 0s
        //from low to mid - 1, all are 1s
        //from mid to high, this is the part which we are wanting to sort
        //high + 1 to n - 1 are all 2s
        //Trying to visualize:
        /*
            0  0  0  0  0      1   1   1   1    0  0  2  1  0  1  2  2  0      2   2   2   2   2
            0------(low - 1)  low----(mid - 1)  mid-------------------high    (high + 1)--(n - 1)
        * */
        //if(nums[mid] == 0): we swap it with nums[low] because thus it will remain in sorted order and now
        //we can shrink the range of mid to high with mid++ and also low++ cause that low idx is now sorted

        //if(nums[mid] == 2): we swap it with nums[high], mid++ and high--. We don't move mid here cause
        //we need to sort this idx again if it's 0.

        //Our main goal is to SHRINK the unsorted range of (mid --> high) until mid == high.

        int low = 0;
        int mid = 0;
        int high = n - 1;
        while(mid <= high) {
            if(nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }else if(nums[mid] == 2) {
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }else {
                mid++;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0, 2, 1, 0, 1, 2, 2, 0};
        dnf(arr, arr.length);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}