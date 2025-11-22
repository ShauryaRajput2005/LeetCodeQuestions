// Last updated: 11/22/2025, 8:14:03 PM
class Solution {
    public int totalWaviness(int num1, int num2) {
          int total = 0;
        for (int x = num1; x <= num2; x++) {
            total += waviness(x);
        }
        return total;
    }

    private int waviness(int n) {
        String s = String.valueOf(n);
        int L = s.length();

        if (L < 3) return 0;  

        int count = 0;

        for (int i = 1; i < L - 1; i++) {
            int left = s.charAt(i - 1) - '0';
            int mid  = s.charAt(i) - '0';
            int right = s.charAt(i + 1) - '0';


            if (mid > left && mid > right) count++;

    
            else if (mid < left && mid < right) count++;
        }

        return count;
    }
}