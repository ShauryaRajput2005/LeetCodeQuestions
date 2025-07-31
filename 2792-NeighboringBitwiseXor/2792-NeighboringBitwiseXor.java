// Last updated: 7/31/2025, 10:34:40 PM
class Solution {
    public boolean doesValidArrayExist(int[] derived) {
                int xor=derived[0];
        for(int i=1;i<derived.length;i++){
            xor^=derived[i];
        }
        if(xor==0){
            return true;
        }
        return false;
    }
}