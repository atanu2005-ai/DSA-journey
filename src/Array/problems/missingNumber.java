package Array.problems;

public class missingNumber {

    //brute force
    //for each i check it exist in the array: if i doesn't exist in arr return i

    public static int better(int[] nums) {
        //we shall use an extra array to flag numbers from 1 to n as 0 or 1.
        int n = nums.length;
        int[] hash = new int[n + 1]; //n spaces for existing numbers of the range and one extra
                                     //space for the missing one. Ex: for n=4, if 2 is missing
                                     //4 spaces for exising numbers and one extra for that 2
        for(int i = 0; i < n - 1; i++) {
            hash[nums[i]] = 1; //set nums[i] with flag 1 means the in range number exists in the array
        }

        for(int i = 1; i <= n; i++) { //now check if any in range number has flag 0 means doesn't exists in the array
            if(hash[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static int optimal(int[] nums) {
        //we will utilize XOR operator here.
        //we know: same num ^ same num = 0 & 0 ^ num = num. Now lets explain how we can get
        //only missing number with this:
        /*
            XOR1 = 1 ^ 2 ^ 3 ^ 4 ^ 5 [XOR of all numbers within the range]
            XOR2 = 1 ^ 2 ^ _ ^ 4 ^ 5[existing numbers in the array]
            now if we XOR both XOR1 and XOR2 we get :
            1 ^ 1 = 0
            2 ^ 2 = 0
            3 is alone so 3 remains same
            4 ^ 4 = 0
            5 ^ 5 = 0;
            now we have only 0 and 3 so 3 ^ 0 = 3, this is the answer
         */
        int n = nums.length;
        int xor1 = 0; //for all the range numbers
        int xor2 = 0; //for the existing numbers in nums
        for(int i = 0; i < n; i++) {
            xor1 = xor1 ^ (i + 1);
            xor2 = xor2 ^ nums[i];
        }
        xor1 = xor1 ^ (n + 1); //previously it was 1 ^ 2 ^ 3 ^ 4. We added 5 to make sure all the existing
                                //array elements are in xor1 and including the missing one.
        return xor1 ^ xor2;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};
        System.out.println("Better: " + better(arr));
        System.out.println("Optimal: " + optimal(arr));
    }
}