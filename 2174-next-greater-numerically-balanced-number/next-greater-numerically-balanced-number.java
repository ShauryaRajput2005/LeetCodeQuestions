class Solution {
    public int nextBeautifulNumber(int n) {
        for (int i = n + 1; ; i++) {
            if (isBal(i)) return i;
        }
    }

    public static boolean isBal(int n) {
        int[] freq = new int[10];
        int temp = n;
        while (temp > 0) {
            int d = temp % 10;
            if (d == 0) return false;
            freq[d]++;
            temp /= 10;
        }
        for (int i = 1; i <= 9; i++) {
            if (freq[i] != 0 && freq[i] != i) return false;
        }
        return true;
    }
}

