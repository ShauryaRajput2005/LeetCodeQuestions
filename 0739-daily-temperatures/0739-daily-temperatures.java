class Solution {
    public int[] dailyTemperatures(int[] tem) {
        Stack<Integer> st=new Stack<>();
        int[] res=new int[tem.length];
        int k=0;
        for(int i=0;i<tem.length;i++){
            if(st.isEmpty()){
                st.push(i);
                continue;
            }
            while(!st.isEmpty() && tem[i]>tem[st.peek()]){
                int x=st.pop();
                res[x]=i-x;
            }
            st.push(i);
        }
        return res;
    }
}