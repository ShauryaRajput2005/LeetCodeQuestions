// Last updated: 8/4/2025, 5:59:36 PM
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cont=0;
        int j=0;
        for(int i=0;i<s.length;i++){
            if(j<g.length && s[i]>=g[j]){
                j++;
                cont++;
            }
        }
        return cont;
        
    }
}