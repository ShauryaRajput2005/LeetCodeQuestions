// Last updated: 8/4/2025, 5:58:39 PM
class Solution {
    public int clumsy(int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(n--);
        int idx = 0;
        
        while (n > 0) {
            if (idx % 4 == 0) {
                stack.push(stack.pop() * n);
            } else if (idx % 4 == 1) {
                stack.push(stack.pop() / n);
            } else if (idx % 4 == 2) {
                stack.push(n);
            } else {
                stack.push(-n);
            }
            idx++;
            n--;
        }
        
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        
        return result;
    }
}
