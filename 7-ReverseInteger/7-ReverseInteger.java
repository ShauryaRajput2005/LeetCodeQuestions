// Last updated: 8/4/2025, 6:02:28 PM
class Solution {
    public int reverse(int x) {
        int sum=0,r;
        while(x!=0)
        {
            r=x%10;
        if (sum > Integer.MAX_VALUE/10|| sum< Integer.MIN_VALUE/10)
        return 0;
            
            sum=sum*10+r;
            x=x/10;
            }
        return sum;
}
}