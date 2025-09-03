// Last updated: 9/3/2025, 11:19:32 AM
class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int[] A = points[i];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int[] B = points[j];

                // A must be on the upper-left side of B
                if (A[0] <= B[0] && A[1] >= B[1]) {
                    if (isValid(points, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean isValid(int[][] points, int i, int j) {
        int[] A = points[i], B = points[j];
        int minX = Math.min(A[0], B[0]);
        int maxX = Math.max(A[0], B[0]);
        int minY = Math.min(A[1], B[1]);
        int maxY = Math.max(A[1], B[1]);

        for (int k = 0; k < points.length; k++) {
            if (k == i || k == j) continue;
            int[] C = points[k];
            if (C[0] >= minX && C[0] <= maxX &&
                C[1] >= minY && C[1] <= maxY) {
                return false;
            }
        }
        return true;
    }
}
