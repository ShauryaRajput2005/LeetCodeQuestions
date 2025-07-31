// Last updated: 7/31/2025, 10:34:58 PM
class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int match=0;
        int i=0,j=0;
        while(i<players.length && j<trainers.length){
            if(players[i]<=trainers[j]){
                match++;
                i++;
            }
            
            j++;
        }
        return match;
    }
}