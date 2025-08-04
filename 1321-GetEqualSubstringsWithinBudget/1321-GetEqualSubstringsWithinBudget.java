// Last updated: 8/4/2025, 5:58:26 PM
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {

        int[] ar=new int[s.length()];
        for(int i=0;i<s.length();i++){
            ar[i]=Math.abs(s.charAt(i)-t.charAt(i));
        }
        int cnt=0;
        int sum=0;
        int l=0;
        for(int i=0;i<ar.length;i++){
            sum+=ar[i];
            while(sum>maxCost){
                sum-=ar[l];
                l++;
            }

            cnt=Math.max(cnt,i-l+1);
        }
        return cnt;
    }
}