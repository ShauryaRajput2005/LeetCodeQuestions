// Last updated: 7/31/2025, 10:34:25 PM
class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                while (!stack.isEmpty() && !Character.isDigit(stack.peek())) {
                    stack.pop();
                    break;
                }
            } else {
                stack.push(ch);
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }
        
        return result.toString();
    }
}