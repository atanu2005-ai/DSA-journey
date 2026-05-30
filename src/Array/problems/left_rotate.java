package Array.problems;
public class left_rotate{
    //Question : lft rotate array by d positions
    //brute force
    public static void left_rotate(int[] arr, int n, int d){
        d = d % n;
        //take first d positions element into a temp array first
        int[] temp = new int[d];
        for(int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }
        //now shift the elements to the left
        for(int i = d; i < n; i++) {
            arr[i - d] = arr[i];
        }
        //now set the rotated element in their right position
        for(int i = n - d; i < n; i++) {
            arr[i] = temp[i - (n - d)];
        }
    }
    //optimal approach in main method using this reverse method
    public static void reverse(int[] arr, int i, int j) {
        while(i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {28, 25, 37, 5, 13, 32, 55, 78, 9};
        left_rotate(nums1, nums1.length, 3);
        for(int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + ", ");
        }
        System.out.println();

        //We will this qapproach as optiomal approach which doesn't need any temp means
        //no extra space.
        int[] nums2 = {28, 25, 37, 5, 13, 32, 55, 78, 9};
        int d = 3;
        //1. Reverse the first d elements
        reverse(nums2, 0, d - 1);
        //2. Now reverse from d to last elements
        reverse(nums2, d, nums2.length - 1);
        //3. Now reverse the whole array
        reverse(nums2, 0, nums2.length - 1);

        for(int i = 0; i < nums2.length; i++) {
            System.out.print(nums2[i] + ", ");
        }
    }
}