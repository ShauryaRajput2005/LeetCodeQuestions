// Last updated: 7/31/2025, 10:34:33 PM
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int size = n * n;
        int[] freq = new int[size + 1]; 
        int repeated = -1, missing = -1;

        // Count occurrences of numbers in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                freq[grid[i][j]]++;
            }
        }

        // Find the repeated and missing values
        for (int i = 1; i <= size; i++) {
            if (freq[i] == 2) {
                repeated = i;
            } else if (freq[i] == 0) {
                missing = i;
            }
        }

        return new int[]{repeated, missing};
    }
}
