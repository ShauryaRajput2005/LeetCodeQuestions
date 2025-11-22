// Last updated: 11/22/2025, 8:08:22 PM
class Solution {
    public int minimumFlips(int n) {
        String s = Integer.toBinaryString(n);
        int L = s.length();
        int flips = 0;

        for (int i = 0; i < L; i++) {
            if (s.charAt(i) != s.charAt(L - 1 - i)) {
                flips++;
            }
        }

        return flips;
    }
}