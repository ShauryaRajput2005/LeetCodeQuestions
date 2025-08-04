// Last updated: 8/4/2025, 6:01:09 PM
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsets(nums, 0, ans, result);
        return result;
    }

    public static void subsets(int[] nums, int idx, List<Integer> ans, List<List<Integer>> result) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(ans));
            return;
        }
        int nextIdx = idx + 1;
        while (nextIdx < nums.length && nums[nextIdx] == nums[idx]) {
            nextIdx++;
        }
        subsets(nums, nextIdx, ans, result);
        ans.add(nums[idx]);
        subsets(nums, idx + 1, ans, result);
        ans.remove(ans.size() - 1);
    }
}
