// Last updated: 8/4/2025, 6:01:43 PM
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Important for skipping duplicates
        boolean[] used = new boolean[nums.length];
        perms(result, nums, new ArrayList<>(), used);
        return result;
    }

    public void perms(List<List<Integer>> result, int[] nums, List<Integer> ans, boolean[] used) {
        if (ans.size() == nums.length) {
            result.add(new ArrayList<>(ans));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip used elements or duplicates
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;

            used[i] = true;
            ans.add(nums[i]);
            perms(result, nums, ans, used);
            ans.remove(ans.size() - 1);
            used[i] = false;
        }
    }
}
