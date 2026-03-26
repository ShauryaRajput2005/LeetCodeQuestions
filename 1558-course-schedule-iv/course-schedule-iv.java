class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] pre, int[][] qu) {
        ArrayList<Integer>[] adj=new ArrayList[n];
        int[] indeg=new int[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] p:pre ){
            int u=p[0];
            int v=p[1];
            adj[u].add(v);
            indeg[v]++;
        }

        HashSet<Integer>[] pres=new HashSet[n];
        for(int i=0;i<n;i++){
            pres[i]=new HashSet<>();
        }
        Queue<Integer> q=new LinkedList();
        for(int i=0;i<n;i++){
            if(indeg[i]==0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int u=q.poll();

            for(int v: adj[u]){
                pres[v].add(u);
                pres[v].addAll(pres[u]);
                indeg[v]--;
                if(indeg[v]==0){
                    q.offer(v);
                }
            }
        }

        List<Boolean> ans=new ArrayList<>();
        for(int[] i:qu){
            int u=i[0];
            int v=i[1];
            if(pres[v].contains(u)){
                ans.add(true);
                continue;
            }
            ans.add(false);

        }
        return ans;
    }
}