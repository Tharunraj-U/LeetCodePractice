package org.example.DailyProblems;

class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] a = new int[s.length() + 1];

        // Apply shifts
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2] == 1 ? 1 : -1;

            a[start] += direction;
            if (end + 1 < a.length) {
                a[end + 1] -= direction;
            }
        }

        // Compute prefix sum
        for (int i = 1; i < a.length; i++) {
            a[i] += a[i - 1];
        }

        // Create the result string
        StringBuilder ans = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            int shift = a[i] % 26; // Ensure shift stays within the range of 0-25
            if (shift < 0) {
                shift += 26; // Handle negative shifts
            }
            char newChar = (char) ((s.charAt(i) - 'a' + shift) % 26 + 'a');
            ans.setCharAt(i, newChar);
        }

        return ans.toString();
    }
}
