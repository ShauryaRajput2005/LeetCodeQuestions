// Last updated: 8/4/2025, 5:58:50 PM
class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer>  map = new HashMap<>();
        int start = 0;
        int maxFruits=-1;

        for(int end=0;end<fruits.length;end++ ){
            map.put(fruits[end],map.getOrDefault(fruits[end],0)+1);


            while(start<fruits.length && map.size()>2){
                map.put(fruits[start],map.get(fruits[start])-1);
                
                if(map.get(fruits[start])==0){
                    map.remove(fruits[start]);
                }
                start++;
            }
        maxFruits=Math.max(end-start+1,maxFruits);
        }
    return maxFruits;
    }
}