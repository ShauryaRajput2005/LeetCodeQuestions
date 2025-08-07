// Last updated: 8/7/2025, 9:14:07 PM
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int presum=0;
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            presum+=nums[i];
            int mod = (presum % k + k) % k; 
            cnt += map.getOrDefault(mod, 0);
            map.put(mod, map.getOrDefault(mod, 0) + 1);

        }
        return cnt;
    }
}