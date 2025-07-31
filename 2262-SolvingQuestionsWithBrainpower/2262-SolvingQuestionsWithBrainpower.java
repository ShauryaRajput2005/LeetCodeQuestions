// Last updated: 7/31/2025, 10:35:11 PM
class Solution {
    public long mostPoints(int[][] questions) {
    Map<Integer, Long> memo = new HashMap<>();
    return solve(0,memo,questions);
    }

    public static long solve(int i, Map<Integer, Long> memo ,int[][] questions){
        if(i>=questions.length) return 0;

        if(memo.containsKey(i)) return  memo.get(i);

        // solve current question
         int nxt = i + questions[i][1] + 1;
        long pnts=questions[i][0]+solve(nxt,memo,questions);

        // skip 
        long skp=solve(i+1,memo,questions);

        // store 
        long result = Math.max(pnts, skp);
        memo.put(i, result);
        return result;

    }

}