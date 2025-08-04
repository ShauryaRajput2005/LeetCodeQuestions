// Last updated: 8/4/2025, 5:58:34 PM
class Solution {
    public int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        for (char ch : tiles.toCharArray()) count[ch - 'A']++;
        return backtrack(count);
    }

    private static int backtrack(int[] count) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                count[i]--;
                sum += 1 + backtrack(count);
                count[i]++;
            }
        }
        return sum;
    }
}