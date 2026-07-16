class Solution {

    public long gcdSum(int[] nums) {
        int n=nums.length;
        long[] pgcd=new long[n];
        pgcd[0]=nums[0];
        int max=nums[0];
        for(int i=1;i<n;i++){
            max=Math.max(max,nums[i]);
            pgcd[i]=gcd(max,nums[i]);
        }
        Arrays.sort(pgcd);
        int left=0,right=n-1;
        int i=0;
        long ans=0;
        while(left<right && i<n/2){
            ans+=gcd(pgcd[left],pgcd[right]);
            left++;
            right--;
            i++;
        }
        return ans;
    }

    public static long gcd(long n,long m){
        if(m<n) return gcd(m,n);
        if(m==0 || n==0){
            return m+n;
        }
        return gcd(n,m%n);

    }
}