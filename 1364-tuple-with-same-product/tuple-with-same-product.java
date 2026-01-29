class Solution {
    public int tupleSameProduct(int[] nums) {
       Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int prod = nums[i] * nums[j];
                map.put(prod, map.getOrDefault(prod, 0) + 1);
            }
        }
        int result = 0;
        for (int count : map.values()) {
            if (count > 1) {
                result += (count * (count - 1) / 2) * 8;
            }
        }

        return result;
    }
}