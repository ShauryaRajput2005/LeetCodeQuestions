// Last updated: 10/8/2025, 10:00:39 PM
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] pairs=new int[spells.length];
        Arrays.sort(potions);
        for(int i=0;i<spells.length;i++){
            pairs[i]=calc(spells[i],potions,success);
        }
        return pairs;
    }

    public static int calc(int spell, int[] potions, long success){
        int left=0;
        int right=potions.length;
        while(left<right){
            int mid=left+(right-left)/2;
            if((long) spell*potions[mid]>=success){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return potions.length-left;
    }
}