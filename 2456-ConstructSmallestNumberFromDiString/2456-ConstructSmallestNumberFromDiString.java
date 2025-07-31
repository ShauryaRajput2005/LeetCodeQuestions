// Last updated: 7/31/2025, 10:35:03 PM
import java.util.Stack;

class Solution {
    public String smallestNumber(String pattern) {
        int[] ans = new int[pattern.length() + 1];
        int c = 1;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i <= pattern.length(); i++) { // FIXED: Loop should run one extra time
            if (i == pattern.length() || pattern.charAt(i) == 'I') { // FIXED: Using 'pattern'
                ans[i] = c;
                c++;
                while (!st.isEmpty()) {
                    ans[st.pop()] = c;
                    c++;
                }
            } else {
                st.push(i);
            }
        }

        StringBuilder sb = new StringBuilder(); // FIXED: Use StringBuilder for efficiency
        for (int v : ans) {
            sb.append(v);
        }
        return sb.toString();
    }
}
