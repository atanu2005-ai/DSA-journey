package Array.problems;
public class BuyAndSellStock1 {
    //Question: Best time to buy and sell stock I: find the most profit we can get

    //We will use DP here
    //1. for each selling day, we will find which buying day provides best profit
    //2. means we will store the minumum in the left of current selling day and that's the best profit
    //we can get for selling at the current day.
    public static int bss(int[] nums, int n) {
        if(n == 1) return 0; //as we can get 0 profit for buying and selling at the same day
        int min = nums[0]; //setting min as 1st day price initially
        int profit = 0; //we need to maximize this

        for(int i = 1; i < n; i++) { //starting from 2nd index
            int cost = nums[i] - min; //calculating the best profit for the CURRENT selling day i
            profit = Math.max(profit, cost); //we are maximizing this profit
            min = Math.min(min, nums[i]); //updating min with the current day price so that it will be
                                          //valid for the next day cause it will be at the left of the next day
        }
        return profit;
    }
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println("Max profit: " + bss(arr, arr.length));

    }
}