// Last updated: 8/4/2025, 5:59:39 PM
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[1],b[1]));
        int cnt=0;
        int prev=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(prev>intervals[i][0]){
                cnt++;
            }else{
                prev=intervals[i][1];
            }
        }
    return cnt;
    }
}