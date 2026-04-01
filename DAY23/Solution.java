import java.util.*;

public class Solution {

    public String minWindow(String s, String t) {

        if (s == null || t == null || s.length() == 0 || t.length() == 0
                || s.length() < t.length()) {
            return "";
        }

        int[] map = new int[128];
        int count = t.length();
        int start = 0, end = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        // Store frequency of characters in t
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        char[] chS = s.toCharArray();

        // Sliding Window
        while (end < chS.length) {

            if (map[chS[end++]]-- > 0) {
                count--;
            }

            while (count == 0) {

                if (end - start < minLen) {
                    minLen = end - start;
                    startIndex = start;
                }

                if (map[chS[start++]]++ == 0) {
                    count++;
                }
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return new String(chS, startIndex, minLen);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string s: ");
        String s = sc.nextLine();

        System.out.print("Enter string t: ");
        String t = sc.nextLine();

        Solution obj = new Solution();

        String result = obj.minWindow(s, t);

        System.out.println("Minimum Window Substring: " + result);

        sc.close();
    }
}