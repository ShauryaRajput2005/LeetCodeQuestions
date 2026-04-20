class Solution {
    public boolean canFinish(int nc, int[][] pre) {
        ArrayList<Integer>[] adj = new ArrayList[nc];
        for (int i = 0; i < nc; i++) {
            adj[i] = new ArrayList<>();
        }
        int[] in = new int[nc];
        for (int i = 0; i < pre.length; i++) {
            adj[pre[i][1]].add(pre[i][0]);
            in[pre[i][0]]++;
        }
        Queue<Integer> q = new LinkedList();
        for (int i = 0; i < nc; i++) {
            if (in[i] == 0) {
                q.offer(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            ans.add(cur);
            for (int v : adj[cur]) {
                in[v]--;
                if (in[v] == 0) {
                    q.offer(v);
                }
            }
        }
        System.out.print(ans);
        return ans.size() == nc;
    }
}