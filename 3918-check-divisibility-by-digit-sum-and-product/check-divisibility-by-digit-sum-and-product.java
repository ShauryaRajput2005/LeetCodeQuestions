class Solution {
    public boolean checkDivisibility(int n) {
        int temp=n;
        int ds=0;
        int dp=1;
        while(temp>0){
            int d=temp%10;
            ds+=d;
            dp*=d;
            temp/=10;
        }
        return n%(ds+dp)==0;
    }
}