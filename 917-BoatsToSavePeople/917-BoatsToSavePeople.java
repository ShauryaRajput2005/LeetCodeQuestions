// Last updated: 8/4/2025, 5:58:54 PM
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left=0;
        int right=people.length-1;
        int boats=0;
        while(left<=right){
            if (people[left]+people[right]<=limit){
                left++;
            }
            boats++;
            right--;
            

        }
        return boats;
    }
}