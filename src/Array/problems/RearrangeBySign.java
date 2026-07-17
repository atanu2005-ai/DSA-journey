package Array.problems;
import java.util.*;
public class RearrangeBySign {
    //Question 1: Rearrange array element in alternating order by their signs. (e.g.: 2, -1, 3, -5)
    //there are equal number of positives and negatives and size of the array is always even

    //Brute force
    //Simply store the positives in a different array of size (n/2) and same for negatives
    //Store them in the given array:
    //positives in (i * 2) idx and negetives in (i * 2 + 1) idx.

    //TC: O(2n); SC: O(n)

    //Optimal
    public static int[] optimal1(int[] nums, int n) {
        //One thing which is the most important is we can't do in place sorting so extra space is must
        //this time we will try to get the result is one loop
        if(n < 2) return nums;
        int evenIdx = 0; //initial index for even numbers
        int oddIdx = 1; //initial index for odd numbers
        int[] ans = new int[n]; //this is where we generate the sorted answer

        for(int i = 0; i < n; i++) {
            if(nums[i] > 0) { //for positives
                ans[evenIdx] = nums[i];
                evenIdx += 2; //no risk of out of bound as any value out of bound will never be used
            }else { //for negatives
                ans[oddIdx] = nums[i];
                oddIdx += 2;
            }
        }
        return ans;
        //TC: O(n); SC: O(n)
    }

    //Question 2: Same problem but here positives and negatives can be not equal. Store the extra elements
    // at the end of the ans array

    //Optimal
    public static int[] optimal2(int[] nums, int n) {
        //here we would consider the last brute force approach
        //as the amount of pos and negs is not same we will store them in list
        if(n < 2) return nums;
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for(int num : nums) {
            if(num > 0) {
                pos.add(num);
            }else {
                neg.add(num);
            }
        }
        //now we don't know which list is longer, or they are equal or whatever...
        //let's handle all cases
        if(pos.size() > neg.size()) { //if pos is longer
            //pos is longer means least amount of pos is equal to negs, it can't be lower than the
            //amount of negs
            for(int i = 0; i < neg.size(); i++) {
                nums[i * 2] = pos.get(i);
                nums[i * 2 + 1] = neg.get(i);
            }
            //now let's handle the remaining elements
            //we can see pos elements are potential remaining elements
            int index = neg.size() * 2; //this space is already worked on at nums (full neg list and same length of pos)
            for(int i = neg.size(); i < pos.size(); i++) {
                nums[index] = pos.get(i);
                index++;
            }
        }else { //now when neg is longer OR both are same length
            for(int i = 0; i < pos.size(); i++) {
                nums[i * 2] = pos.get(i);
                nums[i * 2 + 1] = neg.get(i);
            }
            int index = pos.size() * 2;
            for(int i = pos.size(); i < neg.size(); i++) {
                nums[index] = neg.get(i);
                index++;
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] arr1 = {3, 1, -2, -5, 2, -4};
        int[] ans1 = optimal1(arr1, arr1.length);
        for(int i = 0; i < ans1.length; i++) {
            System.out.print(ans1[i] + "  ");
        }
        System.out.println();

        int[] arr2 = {3, 1, -2, -5, 2, -4, -3, -9, 6};
        int[] ans2 = optimal2(arr2, arr2.length);
        for(int i = 0; i < ans2.length; i++) {
            System.out.print(ans2[i] + "  ");
        }
    }
}