class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int n = maze.length;
        int m = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { entrance[0], entrance[1], 0 });
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            maze[entrance[0]][entrance[1]] = '+';
            for (int[] d : dir) {
                int r = d[0] + cur[0];
                int c = d[1] + cur[1];

                if (r >= 0 && c >= 0 && r < n && c < m && maze[r][c] == '.') {
                    if (r == 0 || c == 0 || r == n - 1 || c == m - 1) {
                        return cur[2] + 1;
                    }
                    maze[r][c] = '+';
                    q.offer(new int[] { r, c, cur[2] + 1 });
                }
            }
        }
        return -1;
    }
}