import java.util.*;
public class count_frequency {
    //To count and frequency of elements of array
    public static void hasing(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // takes elements as key and counts it's frequency and stores it as the value of the key
        for(int i = 0; i < nums.length; i++) { 
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        //map.keySet() returns the key set in the hashmap
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        
        //print frequency in this format : key --> value
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " --> " + map.get(i));
        }
    }
    public static void main(String[] arg) {
           int[] nums = {1, 4, 5, 2, 10, 20, 2, 30, 5, 10, 20, 30};
          hasing(nums);

           
    }
}
