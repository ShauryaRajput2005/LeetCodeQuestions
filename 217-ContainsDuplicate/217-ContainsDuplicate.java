// Last updated: 8/4/2025, 6:00:18 PM
import java.util.Arrays;
class Solution {
    public boolean containsDuplicate(int[] arr) {
        Arrays.sort(arr);
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]==arr[i+1]) {
				return true;
			}
		}
		return false;
	}
}
