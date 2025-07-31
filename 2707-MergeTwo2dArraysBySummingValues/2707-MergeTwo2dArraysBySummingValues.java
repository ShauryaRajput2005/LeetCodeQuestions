// Last updated: 7/31/2025, 10:34:43 PM
class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        ArrayList<int[]> result = new ArrayList<>();
        int n = 0, m = 0;

        while (n < nums1.length && m < nums2.length) {
            if (nums1[n][0] == nums2[m][0]) {
                result.add(new int[]{nums1[n][0], nums1[n][1] + nums2[m][1]});
                n++;
                m++;
            } else if (nums1[n][0] > nums2[m][0]) {
                result.add(new int[]{nums2[m][0], nums2[m][1]});
                m++;
            } else {
                result.add(new int[]{nums1[n][0], nums1[n][1]});
                n++;
            }
        }

    
        while (n < nums1.length) {
            result.add(new int[]{nums1[n][0], nums1[n][1]});
            n++;
        }


        while (m < nums2.length) {
            result.add(new int[]{nums2[m][0], nums2[m][1]});
            m++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
