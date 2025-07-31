// Last updated: 7/31/2025, 10:34:56 PM
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        for (int i = 0; i < n; i++) {
            int largest = i; // Because you want descending order
            for (int j = i + 1; j < n; j++) {
                if (heights[j] > heights[largest]) {
                    largest = j;
                }
            }
            swap(largest, i, names);
            swap(largest, i, heights);
        }
        return names;
    }

    public static void swap(int i, int j, String[] arr) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}