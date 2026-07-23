class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] d1 = dist(node1, edges);
        int[] d2 = dist(node2, edges);

        int ans = -1, best = Integer.MAX_VALUE;

        for (int i = 0; i < edges.length; i++) {
            if (d1[i] != -1 && d2[i] != -1) {
                int mx = Math.max(d1[i], d2[i]);
                if (mx < best) {
                    best = mx;
                    ans = i;
                }
            }
        }
        return ans;
    }

    private int[] dist(int start, int[] edges) {
        int n = edges.length;
        int[] d = new int[n];
        Arrays.fill(d, -1);

        int cur = start, step = 0;
        while (cur != -1 && d[cur] == -1) {
            d[cur] = step++;
            cur = edges[cur];
        }
        return d;
    }
}