// Last updated: 7/31/2025, 10:34:18 PM
class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {

      int n=colors.length;
      if(k>n) return 0;

      int[] alt=new int[n];
      for(int i=0;i<n;i++){
        int nxt=(i+1)%n;
       alt[i] = (colors[i] != colors[nxt]) ? 1 : 0;
      }   

      int winsum=0;
      for(int i=0;i<k-1;i++){
        winsum+=alt[i];
      }
      int cnt=0;
      for(int i=0;i<n;i++){
        if(winsum==k-1) cnt++;
        winsum-=alt[i];
        winsum+=alt[(i+k-1)%n];     
      }
      return cnt;

    }
}