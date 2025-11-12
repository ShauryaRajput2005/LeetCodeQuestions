class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        int o=0;
        for(int i:nums){
            if(i==1){
                o++;
            }
        }
        if(o>0){
            return n-o;
        }
        int minlen=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int g=nums[i];
            for(int j=i+1;j<n;j++){
                g = gcd(g, nums[j]);
                if (g == 1) {
                    minlen = Math.min(minlen, j - i + 1);
                    break;
                }
            }
        }

        if (minlen == Integer.MAX_VALUE) return -1;
        return (minlen - 1) + (n - 1);
    }
        private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}