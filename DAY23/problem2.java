import java.util.*;

public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();

        if (p.length() > s.length()) {
            return list;
        }

        int[] pFreq = new int[26];
        int[] windowFreq = new int[26];

        // Frequency of pattern
        for (int i = 0; i < p.length(); i++) {
            pFreq[p.charAt(i) - 'a']++;
        }

        int left = 0;

        // Sliding Window
        for (int right = 0; right < s.length(); right++) {
            windowFreq[s.charAt(right) - 'a']++;

            if (right - left + 1 > p.length()) {
                windowFreq[s.charAt(left) - 'a']--;
                left++;
            }

            if (right - left + 1 == p.length()) {
                if (isSame(pFreq, windowFreq)) {
                    list.add(left);
                }
            }
        }

        return list;
    }

    public boolean isSame(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input strings
        System.out.print("Enter string s: ");
        String s = sc.nextLine();

        System.out.print("Enter pattern p: ");
        String p = sc.nextLine();

        Solution obj = new Solution();
        List<Integer> result = obj.findAnagrams(s, p);

        System.out.println("Starting indices of anagrams: " + result);

        sc.close();
    }
}