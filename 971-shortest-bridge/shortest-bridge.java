class Solution {
    public int shortestBridge(int[][] grid) {
        Queue<int[]> q = new LinkedList();
        int n = grid.length;
        boolean flag=false;
        for (int i = 0; i < n && !flag; i++) {
            for (int j = 0; j < n && !flag; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, grid, q);
                    flag=true;
                }
            }
        }

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                for (int[] d : dirs) {
                    int nr = d[0] + cur[0];
                    int nc = d[1] + cur[1];
                    if (nr < 0 || nc < 0 || nr >= n || nc >= n || grid[nr][nc] == 2)
                        continue;
                    if (grid[nr][nc] == 1)
                        return steps;
                    grid[nr][nc]=2;
                    q.offer(new int[] { nr, nc });
                }
            }
            steps++;
        }
        return steps;
    }

    public static void dfs(int r, int c, int[][] grid, Queue<int[]> q) {
        int n = grid.length;
        if (r < 0 || c < 0 || r >= n || c >= n || grid[r][c] != 1)
            return;
        grid[r][c] = 2;
        q.offer(new int[] { r, c });
        dfs(r + 1, c, grid, q);
        dfs(r - 1, c, grid, q);
        dfs(r, c + 1, grid, q);
        dfs(r, c - 1, grid, q);
    }
}