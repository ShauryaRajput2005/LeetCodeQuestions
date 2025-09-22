class Solution {
    public int maxFrequencyElements(int[] nums) {
                int maxNum = nums[0];
        for (int num : nums) {
            if (num > maxNum) maxNum = num;
        }

        int[] freq = new int[maxNum + 1];
        for (int num : nums) {
            freq[num]++;
        }

        int maxFreq = 0;
        for (int f : freq) {
            if (f > maxFreq) maxFreq = f;
        }

        int count = 0;
        for (int f : freq) {
            if (f == maxFreq) count += f;
        }

        return count;
    }
}