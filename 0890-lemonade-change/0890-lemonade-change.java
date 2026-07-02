class Solution {
    public boolean lemonadeChange(int[] bills) {
        int f=0;
        int t=0;
        int w=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                f++;
            }else if(bills[i]==10){
                t++;
                f--;
                if(f<0) return false;
            }else{
                if(t>0){
                    t--;
                    f--;
                }else{
                    f-=3;
                }
                w++;
                if(f<0 || t<0) return false;
            }
        }
        return true;
    }
}