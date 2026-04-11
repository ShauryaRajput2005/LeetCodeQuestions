import java.util.*;

class Solution {
    static class Pair {
        int node;
        int w;

        Pair(int node, int w) {
            this.node = node;
            this.w = w;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<Pair>[] g = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int wt = times[i][2];
            g[u].add(new Pair(v, wt));
        }

        int[] dist = new int[n + 1];
        boolean[] vis = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.w - b.w));
        pq.add(new Pair(k, 0));
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int node = cur.node;
            int wt = cur.w;
            if (vis[node])
                continue;
            if (!vis[node]) {
                vis[node] = true;
                for (Pair v : g[node]) {
                    if (dist[v.node] > dist[node] + v.w) {
                        dist[v.node] = dist[node] + v.w;
                        pq.add(new Pair(v.node, dist[v.node]));
                    }
                }
            }
        }
        for(int i=1;i<=n;i++){
            if(!vis[i]) return -1;
        }

        int max=0;

        for(int i=1;i<=n;i++){
            max=Math.max(max,dist[i]);
        }

        return max;
    }
}

