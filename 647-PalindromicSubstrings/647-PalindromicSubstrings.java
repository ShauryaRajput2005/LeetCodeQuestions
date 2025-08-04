// Last updated: 8/4/2025, 5:59:13 PM
class Solution {

    int count =0;
    public int countSubstrings(String s) {
       
       setPalindromes(s.toCharArray(), 0);
       return count+s.length();
    }


    public void setPalindromes(char[] arr, int index)
    {
        if(index==arr.length)
        {
            return;
        }
        int left = index;
        int right = index;

        while(right<arr.length-1 && arr[right]== arr[right+1])
        {
            right++;
            
        }
        int diff = right-left;

        if(diff>0)
        {
            count += ((diff)*(diff+1))/2;
        }

        index = right;

        while(left>0 && right<arr.length-1 && arr[left-1]== arr[right+1])
        {
            left--;
            right++;
            count++;
        }
        setPalindromes(arr, index+1);
    }

    
}