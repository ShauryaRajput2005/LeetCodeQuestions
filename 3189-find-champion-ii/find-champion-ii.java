class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] in=new int[n];
        for(int i=0;i<edges.length;i++){
            in[edges[i][1]]++;
        }
        boolean cnt=false;
        int max=0;
        for(int i=0;i<n;i++){
            if(in[i]==0 && !cnt){
                cnt=true;
                max=i;
            }else if(in[i]==0 && cnt){
                return -1;
            }
        }
        return max;
    }
}