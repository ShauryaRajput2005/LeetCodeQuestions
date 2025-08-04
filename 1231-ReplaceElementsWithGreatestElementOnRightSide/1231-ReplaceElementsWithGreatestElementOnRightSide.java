// Last updated: 8/4/2025, 5:58:28 PM
class Solution {
    public int[] replaceElements(int[] arr) {
        
        int n=arr.length;
        int gre=-1;
        for(int i=n-1;i>=0;i--){
            int t=arr[i];
            arr[i]=gre;
            if(t>gre) gre=t;
        }

    return arr;
    }
}