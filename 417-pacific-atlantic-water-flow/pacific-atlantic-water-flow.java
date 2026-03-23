class Solution {
    static int m;
    static int n;
    static int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n=heights.length;
        m=heights[0].length;
        boolean[][] p=new boolean[n][m];
        boolean[][] a=new boolean[n][m];

        for(int i=0;i<n;i++){
            dfs(i,0,p,heights);
            dfs(i,m-1,a,heights);
        }
        for(int i=0;i<m;i++){
            dfs(0,i,p,heights);
            dfs(n-1,i,a,heights);
        }

        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(p[i][j] && a[i][j]){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;

    }

    public static void dfs(int r,int c,boolean[][] oc,int[][] h){
        oc[r][c]=true;

        for(int[] d: dir){
            int nr=r+d[0];
            int nc=c+d[1];
            if(nr>=0 && nc>=0 && nr<n && nc<m){
                if(!oc[nr][nc]){
                    if(h[nr][nc]>=h[r][c]) dfs(nr,nc,oc,h);
                }
            }
        }
    }
}