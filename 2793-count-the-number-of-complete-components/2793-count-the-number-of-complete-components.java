class Solution {
    static boolean[] vis;
    static List<Integer>[] nbrs;
    public int countCompleteComponents(int n, int[][] edges) {
        vis=new boolean[n];
        nbrs=new ArrayList[n];

        for(int i=0;i<n;i++){
            nbrs[i]=new ArrayList<>();
        }   

        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            nbrs[u].add(v);
            nbrs[v].add(u);
        } 
        int grps=0;
        for(int i=0;i<n;i++){
            if(!vis[i]) {
                int[] k=bfs(i);
                int g=(k[0]*(k[0]-1))/2;
                if(k[1]==g) grps++;
                System.out.print(k[0]+" "+k[1]);
            }
        }
        return grps;
    }

    public static int[] bfs(int node){
        Queue<Integer> q=new ArrayDeque<>();
        int nodes=0;
        int links=0;
        q.offer(node);
        vis[node]=true;
        while(!q.isEmpty()){
            int cur=q.poll();
            nodes++;
            links+=nbrs[cur].size();
            for(int v:nbrs[cur]){
                if(!vis[v]){
                    vis[v]=true; 
                    q.offer(v);
                }
            }
        }
        return new int[]{nodes,links/2};
    }
}