class Solution {
    static List<Integer>[] g;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        g=new ArrayList[n];
        int[] d=new int[n];
        for(int i=0;i<n;i++){
            g[i]=new ArrayList<>();
        }
        for(int i=0;i<n-1;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            g[u].add(v);
            g[v].add(u);
        }    
        return Math.max(0, dfs(0, -1, hasApple));
    }

    public static int dfs(int u,int p,List<Boolean> a){
        int time=0;
        for(int v:g[u]){
            if(v==p) continue;
            int t=dfs(v,u,a);
            if (t > 0 || a.get(v)) time += t + 2;
        }
        return time;
    }
}