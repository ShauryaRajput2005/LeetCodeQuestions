// Last updated: 7/31/2025, 10:35:16 PM
class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int left = 0, right = plants.length - 1;
        int a = capacityA, b = capacityB;
        int refills = 0;
        
        while (left <= right) {
            if (left == right) {  // When both pointers meet at the same plant
                if (Math.max(a, b) < plants[left]) refills++;
                break;
            }

            if (plants[left] > a) {
                a = capacityA;
                refills++;
            }
            a -= plants[left];

            if (plants[right] > b) {
                b = capacityB;
                refills++;
            }
            b -= plants[right];

            left++;
            right--;
        }

        return refills;
    }
}
