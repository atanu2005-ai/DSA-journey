package Array.problems;

import java.util.*;

public class union {
    //union of two SORTED array
    public static void unionBrute(int[] arr1, int[] arr2) {
        //brute force
        int n1 = arr1.length;
        int n2 = arr2.length;
        //create a hashset
        HashSet<Integer> set = new HashSet<>();
        //traverse the first array first
        for(int num : arr1) {
            set.add(num);
        }
        //now traverse the 2nd array
        for(int num : arr2) {
            set.add(num);
        }

        //print ans
        for (Integer an : set) {
            System.out.print(an + " ");
        }
    }

    public static void unionOptimal(int[] arr1, int[] arr2) {
        //optimal approach
        //We will use two pointer method
        int i = 0; //for first array
        int j = 0; //for 2nd array
        int n1 = arr1.length;
        int n2 = arr2.length;
        ArrayList<Integer> ans = new ArrayList<>(); //ans list
        while(i < n1 && j < n2) { //means loop will stop when limit reached of 1 array
            if(arr1[i] <= arr2[j]) { //to make sure smaller element goes first to maintain sorted order
                if(ans.isEmpty() || ans.get(i - 1) != arr1[i]) { /*ans.isEmpty : for first entry of
                                                                element, the condition is always true*/
                    ans.add(arr1[i]);
                }
                i++;
            }else {
                if(ans.isEmpty() || ans.get(j - 1) != arr2[j]) {
                    ans.add(arr2[j]);
                }
                j++;
            }
        }
        //now for the remaining elements of the longer array
        while(i < n1) {
            if(ans.isEmpty() || ans.get(i - 1) != arr1[i]) {
                ans.add(arr1[i]);
            }
            i++;
        }
        while(j < n2) {
            if(ans.isEmpty() || ans.get(j - 1) != arr2[j]) {
                ans.add(arr2[j]);
            }
            j++;
        }
        //ans print
        for(Integer num : ans) {
            System.out.print(num + " ");
        }
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 3, 3, 4, 5};
        int[] nums2 = {2, 3, 4, 4, 5, 6, 7};
        unionBrute(nums1, nums2);
        System.out.println();
        unionBrute(nums1, nums2);
    }
}