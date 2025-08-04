// Last updated: 8/4/2025, 6:01:37 PM
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        return spiralPrint(matrix);
    }

    public static List<Integer> spiralPrint(int[][] grid) {
        int minr = 0, minc = 0;
        int maxr = grid.length - 1, maxc = grid[0].length - 1;
        int totalElements = grid.length * grid[0].length;
        List<Integer> result = new ArrayList<>();

        while (result.size() < totalElements) {
            for (int i = minc; i <= maxc && result.size() < totalElements; i++) {
                result.add(grid[minr][i]);
            }
            minr++;

            for (int i = minr; i <= maxr && result.size() < totalElements; i++) {
                result.add(grid[i][maxc]);
            }
            maxc--;

            for (int i = maxc; i >= minc && result.size() < totalElements; i--) {
                result.add(grid[maxr][i]);
            }
            maxr--;

            for (int i = maxr; i >= minr && result.size() < totalElements; i--) {
                result.add(grid[i][minc]);
            }
            minc++;
        }
        return result;
    }
}
