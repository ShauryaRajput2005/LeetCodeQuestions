// Last updated: 8/4/2025, 6:00:04 PM
class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int left=0;
        int right=citations.length-1;
        if(citations.length==1 && citations[0]<1){
            return 0;
        }
       
        while(left<=right){
            int mid=left+(right-left)/2;
            if(citations[mid]>=n-mid){
       
                right=mid-1;
                
            }else{
               left=mid+1; 
            }
        }
    return n-left;
    }

}