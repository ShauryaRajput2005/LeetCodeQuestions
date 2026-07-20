class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(0, new ArrayList<>(), graph);
        return res;
    }

    void dfs(int cur, List<Integer> path, int[][] g) {
        path.add(cur);
        if (cur == g.length - 1) {
            res.add(new ArrayList<>(path));
        } else {
            for (int next : g[cur]) dfs(next, path, g);
        }
        path.remove(path.size() - 1);
    }
}