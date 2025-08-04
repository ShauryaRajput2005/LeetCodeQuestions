// Last updated: 8/4/2025, 6:00:37 PM
class Solution {
    public void rotate(int[] nums, int k) {
        Rotate(nums,k);
		}
	
	public static void Rotate(int[] arr ,int k) {
		int n=arr.length;
		k=k%n;
		
		reverse(arr,0,n-1);
		reverse(arr,0,k-1);
		reverse(arr,k,n-1);
		}
	
	
	public static void reverse(int[] arr,int start,int end) {
		int i=0;
		
		while(start<end) {
			int temp=arr[start];
			arr[start]= arr[end];
			arr[end]=temp;
			start++;
			end--;
		}
	}

}
