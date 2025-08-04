// Last updated: 8/4/2025, 6:00:38 PM
class Solution {
    public int trailingZeroes(int n) {
        return divi(n,0,0);
    }
    public static int divi(int n,int prev,int zeros){
        if(1>n/Math.pow(5,prev+1)){
            return zeros;
        }
        zeros+=Math.abs(n/Math.pow(5,prev+1));
        return divi(n,prev+1,zeros);
    }
}