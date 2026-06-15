package Array.problems;
import java.util.*;
public class intersection {
    public static void intersectionBrute(int[] a, int[] b) {
        //brute force
        int n1 = a.length;
        int n2 = b.length;
        //make an array remarking 0s for all elements of 2nd array
        int[] mask = new int[n2];
        //ans list
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n1; i++) {
            for(int j = 0; j < n2; j++) {
                if(a[i] == b[j] && mask[j] == 0) {
                    ans.add(a[i]);
                    mask[j] = 1;
                    break;
                }
            }
        }
        //ans print
        for(Integer num : ans) {
            System.out.print(num + " ");
        }
    }

    public static void intersectionOptimal(int[] a, int[] b) {
        //optimal approach
        int n1 = a.length;
        int n2 = b.length;
        //we will use two pointer method here starting from start of both arrays
        int i = 0;
        int j = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while(i < n1 && j < n2) {
            if(a[i] == b[j]) { //add to ans when common element
                ans.add(a[i]);
                i++;
                j++;
            }else if(a[i] < b[j]) { /*move i forward when a[i] is smaller cause there is a
                                    possibility that a[i] can match b[j] cause the array is in increasing order*/
                i++;
            }else {
                j++;
            }
        }
        //ans print
        for(Integer num : ans) {
            System.out.print(num + " ");
        }
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 3, 3, 4, 5};
        int[] nums2 = {2, 3, 4, 4, 5, 6, 7};
        intersectionBrute(nums1, nums2);
        System.out.println();
        intersectionOptimal(nums1, nums2);
    }
}