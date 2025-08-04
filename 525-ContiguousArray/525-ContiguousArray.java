// Last updated: 8/4/2025, 5:59:31 PM
class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int prefix=0;
        int len=0;
        for(int i=0;i<nums.length;i++){
            prefix += (nums[i]==0) ? -1:1;
            if(map.containsKey(prefix)){
                len=Math.max(len,i-map.get(prefix));
            }else{
                map.put(prefix,i);
            }
        }
    return len;
    }
}