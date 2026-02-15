class Solution {
    public int longestStrChain(String[] words) {
        int pre=-1;
        int n=words.length;
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int[] dp=new int[n];
        Arrays.fill (dp,1);
        int max=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(check(words[j],words[i])){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
    public static boolean check(String a,String b){
       
        if (b.length() != a.length() + 1)
            return false;

        int i = 0, j = 0;
        int skipped = 0;

        while (i < a.length() && j < b.length()) {

            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                skipped++;
                j++;

                if (skipped > 1)
                    return false;
            }
        }

        return true;
    }
}