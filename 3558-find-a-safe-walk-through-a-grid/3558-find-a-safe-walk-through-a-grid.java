class Solution {

    class State {
        int r, c, health;

        State(int r, int c, int health) {
            this.r = r;
            this.c = c;
            this.health = health;
        }
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int n = grid.size();
        int m = grid.get(0).size();

        health -= grid.get(0).get(0);

        if (health <= 0)
            return false;

        int[][] best = new int[n][m];
        for (int[] row : best)
            Arrays.fill(row, -1);

        Queue<State> q = new ArrayDeque<>();
        q.offer(new State(0, 0, health));
        best[0][0] = health;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!q.isEmpty()) {

            State cur = q.poll();

            if (cur.r == n - 1 && cur.c == m - 1)
                return true;

            for (int k = 0; k < 4; k++) {

                int nr = cur.r + dr[k];
                int nc = cur.c + dc[k];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m)
                    continue;

                int nh = cur.health - grid.get(nr).get(nc);

                if (nh <= 0)
                    continue;

                if (best[nr][nc] >= nh)
                    continue;

                best[nr][nc] = nh;
                q.offer(new State(nr, nc, nh));
            }
        }

        return false;
    }
}