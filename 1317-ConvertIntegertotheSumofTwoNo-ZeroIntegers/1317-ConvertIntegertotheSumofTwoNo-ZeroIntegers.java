// Last updated: 9/8/2025, 9:34:04 PM
class Solution {
    public int[] getNoZeroIntegers(int n) {
        for(int i=1;i<n;i++){
            if(checkZero(i) && checkZero(n-i)){
                return new int[]{i,n-i};
            }
        }
    return new int[]{-1,-1};
    }
    public static boolean checkZero(int n){
        int temp=n;
        while(temp>0){
            int d=temp%10;
            if(d==0) return false;
            temp/=10;
        }
        return true;
    }
} 