class Solution {
    public boolean canFinish(int num, int[][] pre) {
        ArrayList<Integer>[] adj=new ArrayList[num];
        for(int i=0;i<num;i++){
            adj[i]=new ArrayList();
        }
        for(int i=0;i<pre.length;i++){
            adj[pre[i][1]].add(pre[i][0]);
        }

        boolean[] vis=new boolean[num];
        int[] indeg=new int[num];
        for(int i=0;i<num;i++){
            for(int x:adj[i]){
                indeg[x]++;
            }
        }
        Queue<Integer> q=new LinkedList();
        for(int i=0;i<num;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        ArrayList<Integer> res=new ArrayList<>();
        while(!q.isEmpty()){
            int cur=q.poll();
            res.add(cur);
            for(int x:adj[cur]){
                indeg[x]--;
                if(indeg[x]==0){
                    q.offer(x);
                }
            }
        }
        return res.size()==num;
    }
}