// Last updated: 7/31/2025, 10:35:07 PM
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] result = new int[spells.length];
        int n = potions.length;

        for (int i = 0; i < spells.length; i++) {
            int left = 0, right = n - 1, index = n;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if ((long) spells[i] * potions[mid] >= success) {
                    index = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            result[i] = n - index;
        }

        return result;
    }
}
