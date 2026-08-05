class Solution {
    static List<Integer>[] g;
    static boolean[] vis;

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        g = new ArrayList[n];
        vis = new boolean[n];

        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();

        for (int[] e : invocations)
            g[e[0]].add(e[1]);

        vis[k] = true;
        dfs(k);

        // If a non-suspicious method invokes a suspicious one,
        // nothing can be removed.
        for (int[] e : invocations) {
            if (!vis[e[0]] && vis[e[1]]) {
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++) ans.add(i);
                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (!vis[i]) ans.add(i);

        return ans;
    }

    void dfs(int u) {
        for (int v : g[u]) {
            if (!vis[v]) {
                vis[v] = true;
                dfs(v);
            }
        }
    }
}