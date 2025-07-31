// Last updated: 7/31/2025, 10:34:15 PM
class Solution {
    public int maximumLength(int[] nums) {
        int even=0,odd=0,alte=0,alto=0;
        
        for(int num :nums){
            int p=num%2;
            if(p==0){
                even++;
                alte=alto+1;
            }else{
                odd++;
                alto=alte+1;
            }
        }
        return Math.max(even,Math.max(odd,Math.max(alte,alto)));
    }
}