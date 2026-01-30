class Solution {
    public long perfectPairs(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Math.abs(nums[i]);
        }

        Arrays.sort(arr);

        long count = 0;
        int j = 0;

        for (int i = 0; i < n; i++) {
            if (j < i + 1) j = i + 1;

            while (j < n && arr[j] <= 2L * arr[i]) {
                j++;
            }

            count += (j - i - 1);
        }

        return count;
    }
}
