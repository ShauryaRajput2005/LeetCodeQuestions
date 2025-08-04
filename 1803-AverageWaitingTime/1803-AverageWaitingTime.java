// Last updated: 8/4/2025, 5:58:07 PM
class Solution {
    public double averageWaitingTime(int[][] customers) {
        long cur=0;
        long wtime=0;
        for(int i=0;i<customers.length;i++){
            int ar=customers[i][0];
            int pr=customers[i][1];
            
            if(cur<ar){
                cur=ar;
            }
            cur+=pr;
            wtime+=(cur-ar);
        }
        
    return (double) wtime/customers.length;
    }
}