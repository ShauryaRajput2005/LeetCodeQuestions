// Last updated: 8/28/2025, 9:51:41 PM
class Solution {
    public int[][] sortMatrix(int[][] grid) {
         int n = grid.length;
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        // collect diagonals
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                // bottom-left including main diagonal -> max-heap
                if (i >= j) {
                    map.computeIfAbsent(key, k -> new PriorityQueue<>((a, b) -> b - a));
                } else { // top-right -> min-heap
                    map.computeIfAbsent(key, k -> new PriorityQueue<>());
                }
                map.get(key).offer(grid[i][j]);
            }
        }

        // place back values
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                grid[i][j] = map.get(key).poll();
            }
        }

        return grid;
    }
}