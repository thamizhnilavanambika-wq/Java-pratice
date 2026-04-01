import java.util.*;

public class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];

            while (sum >= target) {
                minLength = Math.min(minLength, j - i + 1);
                sum -= nums[i];
                i++;
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input target
        System.out.print("Enter target: ");
        int target = sc.nextInt();

        // Input array size
        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Input array elements
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Solution obj = new Solution();
        int result = obj.minSubArrayLen(target, nums);

        System.out.println("Minimum Subarray Length = " + result);

        sc.close();
    }
}