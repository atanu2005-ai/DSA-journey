package Array.problems;
public class majorityElement1 {
    //Question: Majority element-> find the element who appears MORE than (n/2) times

    //Brute force
    /*
    1. Initialize count with 0
    2. count occurrence of nums[i] in the array
    3. if count is > n / 2, return nums[i]*/

    //Better
    /*
    1. Use hashmap to count occurrence of each unique element
    2. Iterate through the array and return the key which has more value than n/2.*/

    //Optimal
    public static int Optimal(int[] nums, int n) {
        /*
        We will use moore's voting algorithm here
        1. We take a variable elm and count = 0
        2. If the count == 0 we set elm = crr element. As initially the count == 0, we set elm = nums[0] initially
        3. At each iteration, if nums[i] != elm we do count-- & if nums[i] == elm, we do count++.
        4. In this process when count becomes 0, we set the next element as elm and continue the same process
        5. Thus, we can get an element at the end of the iteration which has dominated from an idx to end of the array

        Trying to visualize:
                0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15
                7  7  5  7  5  1  5  7  5  5  7  7  5  5  5  5
                |                 |     |           |
                elm--------------elm---elm---------elm          <- final elm = 5
        count = 1->2->1->2->1->0->1->0->1->2->1->0->1->2->3->4

        6. We can see 5 dominated from index 12 to 15
        7. Now there can be only one element which can dominate the whole array because others were already canceled out
        8. Now we iterate through the array count occrruence of elm, if it's > (n/2) return it otherwise -1.
        */
        int elm = nums[0];
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(count == 0) { //updating the elm because previous elm got canceled out
                elm = nums[i];
                count = 1;
            }else if(nums[i] == elm) {
                count++;
            }else {
                count--;
            }
        }
        //now we have the elm which has dominated from an index to n - 1 or say end.
        //now we count the total occurrence of the elm
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] == elm) {
                ans++;
            }
        }
        if(ans > (n / 2)) { //checking if elm has appeared more than n/2 times
            return elm;
        }else { //if not returning -1
            return -1;
        }
    }
    public static void main(String[] args) {
        int[] arr = {7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 5, 5, 5, 5};
        System.out.println("Optimal: " + Optimal(arr, arr.length));
    }
}