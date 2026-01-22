class Solution {
    public int minimumPairRemoval(int[] nums) {
        int ops = 0;

        while (!isSorted(nums)) {
            int minSum = Integer.MAX_VALUE;
            int idx = 0;

            // find leftmost minimum sum pair
            for (int i = 0; i < nums.length - 1; i++) {
                int s = nums[i] + nums[i + 1];
                if (s < minSum) {
                    minSum = s;
                    idx = i;
                }
            }

            // merge that pair
            int[] newArr = new int[nums.length - 1];
            int k = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i == idx) {
                    newArr[k++] = minSum;
                    i++; // skip next element
                } else {
                    newArr[k++] = nums[i];
                }
            }

            nums = newArr;
            ops++;
        }

        return ops;
    }

    private boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1])
                return false;
        }
        return true;
    }
}