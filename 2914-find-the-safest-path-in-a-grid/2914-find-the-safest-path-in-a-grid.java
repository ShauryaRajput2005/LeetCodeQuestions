class Solution {
    class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.offer(new Pair(i, j));
                }
            }
        }

        // Multi-source BFS
        int[][] mg = new int[n][n];
        for (int[] row : mg)
            Arrays.fill(row, Integer.MAX_VALUE);

        for (Pair p : q)
            mg[p.x][p.y] = 0;

        int max = 0;

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for (int i = 0; i < 4; i++) {

                int nr = cur.x + dr[i];
                int nc = cur.y + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n)
                    continue;

                if (mg[nr][nc] != Integer.MAX_VALUE)
                    continue;

                mg[nr][nc] = mg[cur.x][cur.y] + 1;
                max = Math.max(max, mg[nr][nc]);
                q.offer(new Pair(nr, nc));
            }
        }

        // Binary Search
        int left = 0;
        int right = max;
        int ans = 0;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (isPath(mid, mg)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    public boolean isPath(int mid, int[][] mg) {

        int n = mg.length;

        // Start cell itself is unsafe
        if (mg[0][0] < mid)
            return false;

        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];

        q.offer(new Pair(0, 0));
        vis[0][0] = true;

        while (!q.isEmpty()) {

            Pair cur = q.poll();

            if (cur.x == n - 1 && cur.y == n - 1)
                return true;

            for (int i = 0; i < 4; i++) {

                int nr = cur.x + dr[i];
                int nc = cur.y + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n)
                    continue;

                if (vis[nr][nc])
                    continue;

                // We can only step on cells whose safeness is at least mid
                if (mg[nr][nc] < mid)
                    continue;

                vis[nr][nc] = true;
                q.offer(new Pair(nr, nc));
            }
        }

        return false;
    }
}