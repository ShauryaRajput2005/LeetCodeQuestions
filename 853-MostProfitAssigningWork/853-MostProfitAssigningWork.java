// Last updated: 8/4/2025, 5:58:58 PM
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {


       List<int[]> job = new ArrayList<>();
        for (int i = 0; i < difficulty.length; i++) {
            job.add(new int[]{difficulty[i], profit[i]});
        }
        job.sort( (a, b) -> Integer.compare(a[0], b[0])); 
        Arrays.sort(worker);

        int curprof=0;
        int total=0;
        int num=0;

        for(int ab:worker){
            while(num<difficulty.length && job.get(num)[0]<=ab ){
                curprof=Math.max(curprof, job.get(num)[1]);
                num++;
            }
            total+=curprof;

        }
       return total; 
    }
}