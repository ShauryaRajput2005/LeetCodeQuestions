// Last updated: 8/4/2025, 6:02:11 PM
class Solution {
    public boolean isValid(String s) {
    Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
           if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            }else{
                if(st.isEmpty()) return false;

                char top=st.pop();
                if(ch==')' && top!='(') return false;
                if(ch=='}' && top!='{') return false;
                if(ch==']' && top!='[') return false;
                
            }
        }    
    
    return st.isEmpty();
    }

}
