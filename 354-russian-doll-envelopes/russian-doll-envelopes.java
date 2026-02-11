class Solution {
    public int maxEnvelopes(int[][] env) {
        int n=env.length;
        int[] dp=new int[n];
        Arrays.sort(env,(a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }
            return b[1]-a[1];
        });
        int len=0;
        Arrays.fill(dp,1);
        for(int[] e:env){
            int height = e[1];

            int idx = Arrays.binarySearch(dp, 0, len, height);
            if (idx < 0) idx = -(idx + 1);

            dp[idx] = height;

            if (idx == len) len++;
        }

        return len;
    }
}