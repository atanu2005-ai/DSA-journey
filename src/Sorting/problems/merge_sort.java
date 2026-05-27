package Sorting.problems;

import java.util.*;
public class merge_sort {
    public static void merge(int[] arr, int low, int mid, int high) {
        //main motive is to start two pointer
        //--> one from start point of the left array which travels till the mid
        //[low....mid]
        //--> one from mid + 1 which travels till the end of the array
        //[mid + 1....high]

        int left = low;
        int right = mid + 1;
        ArrayList<Integer> tmp = new ArrayList<>();
        while(left <= mid && right <= high) { //notice, one part will stay incomlete after
                                              //all iteration, will shall take care about it later
            if(arr[left] <= arr[right]) {
                tmp.add(arr[left]);
                left++;
            }else {
                tmp.add(arr[right]);
                right++;
            }
        }

        while(left <= mid) { // now we make sure remaining elements get added
            tmp.add(arr[left]);
            left++;
        }
        while(right <= high) {
            tmp.add(arr[right]);
            right++;
        }

        for(int i = low; i <= high; i++) { //places sorted elememts in right place
            arr[i] = tmp.get(i - low);
        }
    }
    public static void merge_sort(int[] arr, int low, int high) {
        //main target : divide the array untill divided part is 1 element
        if(low == high) return; // thi checks if the devided array becoame 1 element or not
        int mid = (low + high) / 2; 
        merge_sort(arr, low, mid); // to devide left part of the array recursively
        merge_sort(arr, mid + 1, high); // to devide right part of the array recursively
        merge(arr, low, mid, high); //to be called after division for merging
                                    //function written above

    }
    public static void main(String[] args) {
        int[] nums = {28, 25, 37, 5, 13, 32, 55, 78, 9};
        merge_sort(nums, 0, nums.length - 1);
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
