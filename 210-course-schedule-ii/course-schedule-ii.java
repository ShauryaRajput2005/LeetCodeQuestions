class Solution {
    public int[] findOrder(int n, int[][] pre) {
        ArrayList<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList();
        }
        for(int i=0;i<pre.length;i++){
            adj[pre[i][1]].add(pre[i][0]);
        }
        int[] deg=new int[n];
        for(int i=0;i<n;i++){
            for(int x:adj[i]){
                deg[x]++;
            }
        }
        Queue<Integer> q=new LinkedList();
        for(int i=0;i<n;i++){
            if(deg[i]==0){
                q.offer(i);
            }
        }
        ArrayList<Integer> res=new ArrayList<>();
        while(!q.isEmpty()){
            int cur=q.poll();
            res.add(cur);
            for(int x:adj[cur]){
                deg[x]--;
                if(deg[x]==0){
                    q.offer(x);
                }
            }
        }
        if(res.size() != n) return new int[0];
       int[] ans=new int[n];
       for(int i=0;i<n;i++){
        ans[i]=res.get(i);
       }
       return ans;
    }
}