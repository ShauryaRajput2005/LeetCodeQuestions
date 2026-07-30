class Solution {
    public boolean asteroidsDestroyed(int mass, int[] ast) {
        Arrays.sort(ast);
        long cur=mass;
        for(int i=0;i<ast.length;i++){
            if(cur<ast[i]) return false;
            cur+=ast[i];
        }
        return true;
    }
}