class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (map.get(num) == 0) continue;

            int complement = k - num;

            if (!map.containsKey(complement) || map.get(complement) == 0) {
                continue;
            }

            if (num == complement) {
                if (map.get(num) >= 2) {
                    map.put(num, map.get(num) - 2);
                    cnt++;
                }
            } else {
                map.put(num, map.get(num) - 1);
                map.put(complement, map.get(complement) - 1);
                cnt++;
            }
        }

        return cnt;
    }
}