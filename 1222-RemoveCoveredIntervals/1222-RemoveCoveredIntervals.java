// Last updated: 8/4/2025, 5:58:31 PM
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]); 
        });

        int cnt = 0;
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= start && intervals[i][1] <= end) {
                cnt++;
            } else {
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        return intervals.length - cnt;
    }
}