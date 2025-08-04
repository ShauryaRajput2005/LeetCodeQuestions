// Last updated: 8/4/2025, 5:59:25 PM
class Solution {
    public int subarraySum(int[] nums, int k) {
        
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int cnt=0;
        int sum=0;
        for(int n:nums){
            sum+=n;

            if(map.containsKey(sum-k)){
                cnt+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
       
        return cnt;
    }
}