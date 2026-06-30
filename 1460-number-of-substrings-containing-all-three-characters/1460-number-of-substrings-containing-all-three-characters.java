class Solution {
    public int numberOfSubstrings(String s) {
        int  a=0,b=0,c=0;
        int left=0;
        int cnt=0;

        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='a') a++;
            if(ch=='c') c++;
            if(ch=='b') b++;
            while(a>0 && b>0 && c>0){
                cnt+=(n-i);
                if(s.charAt(left)=='a') a--;
                if(s.charAt(left)=='b') b--;
                if(s.charAt(left)=='c') c--;
                left++;
            }
        }
        return cnt;
    }
}