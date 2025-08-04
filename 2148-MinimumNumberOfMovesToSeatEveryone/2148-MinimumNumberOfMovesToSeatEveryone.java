// Last updated: 8/4/2025, 5:57:43 PM
class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int ans=0;
        int n=students.length;
        for(int i=0;i<n;i++){
            ans+=Math.abs(seats[i]-students[i]);
        }
        return ans;
    }
}