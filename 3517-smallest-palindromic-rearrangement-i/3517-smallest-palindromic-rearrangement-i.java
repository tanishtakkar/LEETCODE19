class Solution {
    public String smallestPalindrome(String s) {

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        char[] ans = new char[s.length()];

        int left = 0;
        int right = s.length() - 1;

        for (int i = 0; i < 26; i++) {

            while (freq[i] > 1) {
                ans[left++] = (char) ('a' + i);
                ans[right--] = (char) ('a' + i);
                freq[i] -= 2;
            }

            if (freq[i] == 1) {
                ans[s.length() / 2] = (char) ('a' + i);
            }
        }

        return new String(ans);
    }
}