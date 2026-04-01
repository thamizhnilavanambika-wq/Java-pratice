import java.util.*;

public class Solution {

    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if (n2 < n1)
            return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // Frequency count for s1 and first window of s2
        for (int i = 0; i < n1; i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        // Check first window
        if (Arrays.equals(count1, count2))
            return true;

        // Sliding window
        for (int i = n1; i < n2; i++) {
            count2[s2.charAt(i) - 'a']++;          // Add new character
            count2[s2.charAt(i - n1) - 'a']--;     // Remove old character

            if (Arrays.equals(count1, count2))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input strings
        System.out.print("Enter s1: ");
        String s1 = sc.nextLine();

        System.out.print("Enter s2: ");
        String s2 = sc.nextLine();

        Solution obj = new Solution();
        boolean result = obj.checkInclusion(s1, s2);

        System.out.println("Output: " + result);

        sc.close();
    }
}