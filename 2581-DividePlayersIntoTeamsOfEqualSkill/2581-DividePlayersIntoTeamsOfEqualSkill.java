// Last updated: 7/31/2025, 10:34:53 PM
class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n=skill.length;
        int tar=skill[0]+skill[n-1];
        long chm=0;
        for(int i=0;i<n/2;i++){
            if(skill[i]+skill[n-i-1]!=tar){
                return -1;
            }
            chm+=(long) skill[i]*skill[n-i-1];
        }
        return chm;
    }
}