class Solution {

    List<int[]>[] graph;
    boolean[] vis;
    int ans = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int[] r : roads) {
            graph[r[0]].add(new int[]{r[1], r[2]});
            graph[r[1]].add(new int[]{r[0], r[2]});
        }

        vis = new boolean[n + 1];
        dfs(1);

        return ans;
    }

    void dfs(int u) {

        vis[u] = true;

        for (int[] e : graph[u]) {

            ans = Math.min(ans, e[1]);

            if (!vis[e[0]])
                dfs(e[0]);
        }
    }
}