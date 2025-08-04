// Last updated: 8/4/2025, 6:00:02 PM
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return firstbad(n);
    }
    public int firstbad(int n){
        int lo=1;
        int hi=n;
        int ans=0;
        while(lo<hi){
            int mid=lo+(hi-lo)/2;
            if(isBadVersion(mid)){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        return lo;
    }
}