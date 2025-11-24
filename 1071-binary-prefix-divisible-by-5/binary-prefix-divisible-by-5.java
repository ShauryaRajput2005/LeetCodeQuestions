class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        int value = 0;   

        for (int bit : nums) {
            value = ((value << 1) + bit) % 5;  
            ans.add(value == 0);
        }

        return ans;
    }
}
