// Last updated: 7/31/2025, 10:35:01 PM
class Solution {
    public String removeStars(String s) {
        Stack<Character> stack =new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch=='*'){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
    StringBuilder sb=new StringBuilder();
    while(!stack.isEmpty()){
        sb.append(stack.pop());
    }

    return sb.reverse().toString();
    }
}