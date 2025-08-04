// Last updated: 8/4/2025, 6:01:45 PM
class Solution {
    public List<List<Integer>> permute(int[] nums) {
	        List<List<Integer>> result = generatePerm(nums);
        return result;
    }
    public static void permutations(int[] nums, List<Integer> current, List<List<Integer>> result) {
	        if (nums.length == 0) {
	            result.add(new ArrayList<>(current));
	            return;
	        }

	        for (int i = 0; i < nums.length; i++) {
	            int cur = nums[i];
	            int[] arr = new int[nums.length - 1];
	            int k = 0;
	            for (int j = 0; j < nums.length; j++) {
	                if (j != i) {
	                    arr[k++] = nums[j];
	                }
	            }
	            current.add(cur);
	            permutations(arr, current, result);
	            current.remove(current.size() - 1);
	        }
	    }

	    public static List<List<Integer>> generatePerm(int[] nums) {
	        List<List<Integer>> result = new ArrayList<>();
	        permutations(nums, new ArrayList<>(), result);
	        return result;
	    }

	}
