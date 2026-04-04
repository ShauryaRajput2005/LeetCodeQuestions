class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp=new int[days.length];
        return solve(0,days,costs,dp);
    }

    static int solve(int i,int[] days,int[] costs,int[] dp){
        if(i>=days.length) return 0;
        if(dp[i]!=0) return dp[i];

        int j=i;
        while(j<days.length && days[j]<days[i]+1) j++;
        int one=costs[0]+solve(j,days,costs,dp);

        j=i;
        while(j<days.length && days[j]<days[i]+7) j++;
        int sev=costs[1]+solve(j,days,costs,dp);
        
        j=i;
        while(j<days.length && days[j]<days[i]+30) j++;
        int th=costs[2]+solve(j,days,costs,dp);

        return dp[i]=Math.min(one,Math.min(sev,th));
    
    }
}