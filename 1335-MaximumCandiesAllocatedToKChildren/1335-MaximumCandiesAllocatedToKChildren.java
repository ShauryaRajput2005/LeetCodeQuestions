// Last updated: 8/4/2025, 5:58:25 PM
class Solution {
    public int maximumCandies(int[] candies, long k) {
        Arrays.sort(candies);
        int left=1;
        int right=candies[candies.length-1];
        while(left<=right){
            int mid=left+(right-left)/2;
            if(ispossible(mid,candies,k)){
                left=mid+1;

            }else{
                right=mid-1;
            }
        }
    return right > 0 ? right : 0; 
    }

    public static boolean ispossible(int lim,int[] candies, long k){
        long cnt=0;
        for(int i=0;i<candies.length;i++){
            int x=candies[i];
            cnt+=x/lim;
        }
        if(k<=cnt){
            return true;
        }

        return false;
    }
}