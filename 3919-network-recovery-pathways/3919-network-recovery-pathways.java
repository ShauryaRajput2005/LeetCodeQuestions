import java.util.*;

class Solution {

    static class Edge {
        int to, cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    List<Edge>[] graph;
    int[] topo;

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        int n = online.length;

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        int[] indegree = new int[n];

        int maxCost = 0;

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int c = e[2];

            graph[u].add(new Edge(v, c));
            indegree[v]++;
            maxCost = Math.max(maxCost, c);
        }

        // Topological Sort
        topo = new int[n];
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++)
            if (indegree[i] == 0)
                q.offer(i);

        int idx = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            topo[idx++] = u;

            for (Edge e : graph[u]) {
                if (--indegree[e.to] == 0)
                    q.offer(e.to);
            }
        }

        int ans = -1;

        int lo = 0;
        int hi = maxCost;

        while (lo <= hi) {

            int mid = lo + (hi - lo) / 2;

            if (check(mid, online, k, n)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(int minEdge, boolean[] online, long k, int n) {

        long INF = Long.MAX_VALUE / 4;

        long[] dp = new long[n];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int u : topo) {

            if (dp[u] == INF)
                continue;

            if (u != 0 && u != n - 1 && !online[u])
                continue;

            for (Edge e : graph[u]) {

                if (e.cost < minEdge)
                    continue;

                int v = e.to;

                if (v != n - 1 && !online[v])
                    continue;

                dp[v] = Math.min(dp[v], dp[u] + e.cost);
            }
        }

        return dp[n - 1] <= k;
    }
}