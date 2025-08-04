// Last updated: 8/4/2025, 5:57:58 PM
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int first = -1, last = -1, freq = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                freq++;
                if (freq == 1) {
                    first = i;
                } else if (freq == 2) {
                    last = i;
                } else {
                    return false; // More than two mismatches
                }
            }
        }

        return freq == 0 || (freq == 2 && s1.charAt(first) == s2.charAt(last) && s1.charAt(last) == s2.charAt(first));
    }
}
