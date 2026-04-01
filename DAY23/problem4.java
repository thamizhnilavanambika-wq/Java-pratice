import java.util.*;

public class Solution {

    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;

        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);

            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input string
        System.out.print("Enter the string (uppercase letters only): ");
        String s = sc.nextLine();

        // Input k
        System.out.print("Enter k: ");
        int k = sc.nextInt();

        Solution obj = new Solution();
        int result = obj.characterReplacement(s, k);

        System.out.println("Longest Length = " + result);

        sc.close();
    }
}