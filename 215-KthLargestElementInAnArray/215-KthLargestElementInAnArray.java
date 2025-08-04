// Last updated: 8/4/2025, 6:00:21 PM
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return QuickSelect(nums,nums.length-k);
		
	}
	
    public static int QuickSelect(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int pivotIndex = Array_partition(arr, left, right);

            if (pivotIndex == k) {
                return arr[k];
            } else if (pivotIndex < k) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
        return -1; // This line should never be reached if input is valid
    }

    public static int Array_partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
