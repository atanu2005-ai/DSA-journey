package Array.problems;
public class right_rotate {
    //brute force
    public static void right_rotate(int[] arr, int n,int d) {
        d = d % n;
        int[] temp = new int[d];
        int j = 0;
        for(int i = n - d; i < n; i++) {
            temp[j] = arr[i];
            j++;
        }

        //shifting
        for(int i = n - d - 1; i >= 0; i--) { //must traverse in reverse to prevent overlapping
            arr[i + d] = arr[i];
        }

        //temp placing
        for(int i = 0; i < d; i++) {
            arr[i] = temp[i];
        }
    }

    public static void reverse(int[] arr, int i, int j) {
        while(i <= j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        int[] nums1 = {28, 25, 37, 5, 13, 32, 55, 78, 9};
        right_rotate(nums1, nums1.length, 3);
        for(int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + ", ");
        }
        System.out.println();

        //optimal approach
        int d = 3;
        int[] nums2 = {28, 25, 37, 5, 13, 32, 55, 78, 9};
        int n = nums2.length;
        reverse(nums2, 0, n - d - 1);
        reverse(nums2, n - d, n - 1);
        reverse(nums2, 0, n - 1);
        for(int i = 0; i < nums1.length; i++) {
            System.out.print(nums2[i] + ", ");
        }
    }
}