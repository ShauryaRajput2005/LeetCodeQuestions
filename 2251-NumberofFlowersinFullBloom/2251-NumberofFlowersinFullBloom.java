// Last updated: 10/13/2025, 8:02:15 PM
import java.util.*;

class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int[] res = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            int up = upper(start, people[i], n);
            int lo = lower(end, people[i], n);
            res[i] = up - lo;
        }
        return res;
    }

    public static int upper(int[] arr, int tar, int n) {
        int left = 0, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= tar) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public static int lower(int[] arr, int tar, int n) {
        int left = 0, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < tar) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
