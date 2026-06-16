
class Solution {

    static class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa != pb) {
                parent[pa] = pb;
            }
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        DSU dsu = new DSU(n);

        for (int[] e : edges) {
            dsu.union(e[0], e[1]);
        }

        return dsu.find(source) == dsu.find(destination);
    }
}
