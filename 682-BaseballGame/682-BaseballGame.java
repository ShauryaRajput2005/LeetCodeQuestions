// Last updated: 8/4/2025, 5:59:08 PM
class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack=new Stack<>();
        for(String score:operations){
            if(score.equals("C")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(score.equals("D")){
                stack.push(stack.peek()*2);
            }else if(score.equals("+")){
                int k=stack.pop();
                int sum=k+stack.peek();
                stack.push(k);
                stack.push(sum);
            }else{
                stack.push(Integer.parseInt(score));
            }
        }
        int sum=0;
        while(!stack.isEmpty()){
            sum+=stack.pop();
        }
        return sum;
    }
}