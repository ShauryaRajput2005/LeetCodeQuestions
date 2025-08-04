// Last updated: 8/4/2025, 5:58:16 PM
class Solution {
    public int findLucky(int[] arr) {
        Arrays.sort(arr);
        int l=-1;
        int cur=arr[0];
        int freq=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]==cur){
                freq++;
            }else{
                if(freq==cur) {
                    l=Math.max(l,freq);
                }
                freq=1;
                cur=arr[i];
            }
        }
        if(cur==freq) l=Math.max(l,freq);
        return l;
    }
}