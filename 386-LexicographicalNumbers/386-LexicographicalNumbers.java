// Last updated: 8/4/2025, 5:59:45 PM
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result=new ArrayList<>();
        lexico(n,0,result);
        return result;
    }

    public static void lexico(int n,int cur,List<Integer> result){
        if(cur>n){
            return;
        }
        if (cur != 0) {
            result.add(cur);
        }
        int i=0;
        if(cur==0){
            i=1;
        }
        for(;i<=9;i++){
            if(cur*10+i>n){
                break;
            }
            lexico(n,cur*10+i,result);
        }
    }
}