class Solution {
    public String processStr(String s) {
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray()){
            if('a'<=ch && ch<='z'){
                sb.append(ch);
            }else if(ch=='*' && sb.length()>=1){
                sb.deleteCharAt(sb.length()-1);
            }else if(ch=='#'){
                sb.append(sb);
            }else{
                sb=sb.reverse();
            }

        }
        return sb.toString();
    }
}