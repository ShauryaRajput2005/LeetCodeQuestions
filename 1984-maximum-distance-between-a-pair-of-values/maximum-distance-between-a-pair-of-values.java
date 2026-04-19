class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int max=0;
        for(int i=0;i<nums1.length;i++){
            int idx=binarySearch(nums2,nums1[i]);
            max=Math.max(idx-i,max);
        }
        return max;
    }

    public static int binarySearch(int[] arr,int a){
        int n=arr.length;
        int left=0;
        int right=n-1;
        int ans=-1;
        while(left<=right){
            int mid=(left+(right-left)/2);
            if(arr[mid]>=a){
                ans=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return ans;

    }
}