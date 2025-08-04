// Last updated: 8/4/2025, 6:02:03 PM
class Solution {
    public void nextPermutation(int[] nums) {
        permutation(nums);
        
    }

    public static int[] permutation(int[] arr){
        int n=arr.length;
        int br=-1;

        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                br=i;
                break;
            }
        }

        if(br==-1){
            reverse(arr,0,n-1);
            return arr;
        }
        int br1=-1;
        for(int i=n-1;i>br;i--){
            if(arr[i]>arr[br]){
                br1=i;
                break;
            }
        }
        int temp=arr[br];
        arr[br]=arr[br1];
        arr[br1]=temp;
        return reverse(arr,br+1,n-1);
    }
    public static int[] reverse(int[] nums,int st,int end){
        while(st<end){
            int temp=nums[st];
            nums[st]=nums[end];
            nums[end]=temp;
            st++;
            end--;
        }
        return nums;
    }
}