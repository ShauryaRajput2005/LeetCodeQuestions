class Solution {
    public long maxBalancedSubsequenceSum(int[] nums) {
        int n=nums.length;
        TreeMap<Integer,Long> map=new TreeMap<>();
        long result=Long.MIN_VALUE;
        for(int i=0;i<n;i++){
            int key=nums[i]-i;
            
            Map.Entry<Integer,Long> it=map.floorEntry(key);
            long sum=nums[i];
            if(it!=null && it.getValue() > 0){
                sum+=it.getValue();
            }

            map.put(key,Math.max(map.getOrDefault(key,Long.MIN_VALUE),sum));
            it=map.higherEntry(key);
            while(it!=null && it.getValue()<=sum){
                map.remove(it.getKey());
                it=map.higherEntry(key);
            }
            result=Math.max(result,sum);
        }
        return (result < 0) ? Arrays.stream(nums).max().getAsInt() : result;
    }
}