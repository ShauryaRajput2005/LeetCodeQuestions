class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {

                    q.add(new int[] { i, j });
                }
            }
        }
        int[][] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        if (q.size() == n * n || q.size() == 0)
            return -1;
        int dist = -1;
        while (!q.isEmpty()) {
            int k = q.size();
            dist++;
            while (k-- > 0) {
                int[] cur = q.poll();
                for (int[] d : dir) {
                    int r = d[0] + cur[0];
                    int c = d[1] + cur[1];
                    if (r >= 0 && c >= 0 && c < n && r < n && grid[r][c] == 0) {
                        grid[r][c] = 1;
                        q.offer(new int[] { r, c });
                    }
                }
            }
        }
        return dist;
    }
}