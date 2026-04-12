import java.util.*;

class Solution {
    public int minimumEffortPath(int[][] h) {
        int n = h.length, m = h[0].length;
        int[][] dist = new int[n][m];
        for (int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,0,0});
        dist[0][0] = 0;

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0], r = cur[1], c = cur[2];

            if (r == n-1 && c == m-1) return d;

            for (int[] di : dir) {
                int nr = r + di[0], nc = c + di[1];
                if (nr>=0 && nc>=0 && nr<n && nc<m) {
                    int nd = Math.max(d, Math.abs(h[r][c] - h[nr][nc]));
                    if (nd < dist[nr][nc]) {
                        dist[nr][nc] = nd;
                        pq.offer(new int[]{nd,nr,nc});
                    }
                }
            }
        }
        return 0;
    }
}