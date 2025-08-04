// Last updated: 8/4/2025, 5:58:04 PM
class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x > y) {
            return removeSubstrings(s, "ab", x, y);
        } else {
            return removeSubstrings(s, "ba", y, x);
        }
    }

    private int removeSubstrings(String s, String first, int firstVal, int secondVal) {
        Stack<Character> stack = new Stack<>();
        int score = 0;

        // First pass: remove the more valuable substring (first)
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == first.charAt(0) && ch == first.charAt(1)) {
                stack.pop();
                score += firstVal;
            } else {
                stack.push(ch);
            }
        }

        // Build the remaining string
        StringBuilder remaining = new StringBuilder();
        for (char ch : stack) {
            remaining.append(ch);
        }

        // Second pass: remove the less valuable substring
        stack.clear();
        for (char ch : remaining.toString().toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == first.charAt(1) && ch == first.charAt(0)) {
                stack.pop();
                score += secondVal;
            } else {
                stack.push(ch);
            }
        }

        return score;
    }
}
