// Last updated: 8/4/2025, 5:58:19 PM
class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum=0;
        int i=0;
        int cnt=0;
        while(i<k){
            sum+=arr[i];
            i++;
        }
        if (sum / k >= threshold) cnt++;
        for(i=k;i<arr.length;i++){
            
            sum-=arr[i-k];
            sum+=arr[i];
            if(sum/k>=threshold) cnt++;
        }
        return cnt;
    }
}