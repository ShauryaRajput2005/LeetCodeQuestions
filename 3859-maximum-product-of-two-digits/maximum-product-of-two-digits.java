class Solution {
    public int maxProduct(int n) {
        int prod=0;
        int t1=n;
        int i=0;
        while(t1>0){
            int d=t1%10;
            int t2=n;
            int j=0;
            while(t2>0){
                if(i==j){
                    t2/=10;
                    j++;
                    continue;
                }
                int k=t2%10;
                prod=Math.max(prod,k*d);
                t2=t2/10;
                j++;
            }
            i++;
            t1=t1/10;
        }
        return prod;
    }
}