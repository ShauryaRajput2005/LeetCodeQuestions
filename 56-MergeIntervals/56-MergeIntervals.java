// Last updated: 8/4/2025, 6:01:34 PM
class Solution {
    public int[][] merge(int[][] intervals) {
           Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int n=intervals.length;
        ArrayList<int[]> arr=new ArrayList<>();
        int strt=intervals[0][0];
        int end=intervals[0][1];
    
        for(int i=1;i<n;i++){

            if(end>=intervals[i][0] || strt>intervals[i][0]){
                end=Math.max(end,intervals[i][1]);
                
            }else{
                arr.add(new int[]{strt,end});
                strt=intervals[i][0];
                end=intervals[i][1];
            } 
        }
      arr.add(new int[]{strt, end});
       return arr.toArray(new int[arr.size()][]);
    }
}