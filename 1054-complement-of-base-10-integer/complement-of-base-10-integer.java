class Solution {
    public int bitwiseComplement(int n) {
        StringBuilder sb=new StringBuilder();
        String str=Integer.toBinaryString(n);
        for(int ch:str.toCharArray()){
            if(ch=='1') sb.append('0');
            else sb.append('1');
        }
    return Integer.parseInt(sb.toString(),2);
    }

}