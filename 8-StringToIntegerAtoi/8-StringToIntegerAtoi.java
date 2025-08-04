// Last updated: 8/4/2025, 6:02:27 PM
class Solution {
    public int myAtoi(String s) {
        boolean neg = false;
        int num = 0;
        boolean start = false;

        for (char ch : s.toCharArray()) {
            if (ch == ' ' && !start) {
                continue;
            } else if ((ch == '-' || ch == '+') && !start) {
                neg = (ch == '-');
                start = true;
            } else if (Character.isDigit(ch)) {
                start = true;
                int digit = ch - '0';

                // Check for overflow
                if (num > (Integer.MAX_VALUE - digit) / 10) {
                    return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }

                num = num * 10 + digit;
            } else {
                break;
            }
        }

        return neg ? -num : num;
    }
}
