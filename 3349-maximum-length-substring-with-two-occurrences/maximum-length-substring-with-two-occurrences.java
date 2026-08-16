class Solution {
    public int maximumLengthSubstring(String s) {
        int len=0;
        HashMap<Character,Integer> map=new HashMap<>();
        int left=0;
        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);
            map.put(c,map.getOrDefault(c,0)+1);
            while(left<right && map.get(c)>2){
                char k=s.charAt(left);
                map.put(k,map.get(k)-1);
                if(map.get(k)==0) map.remove(k);
                left++;
            }
            len=Math.max(right-left+1,len);
        }
        return len;
    }
}