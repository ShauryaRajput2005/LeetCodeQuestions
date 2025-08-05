class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Long, Integer> map=new HashMap<>();
        for(List<Integer> rows : wall){
            long sum=0;
            for(int i=0;i<rows.size()-1;i++){
                sum+=rows.get(i);
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        int maxEdges = 0;
        for (int count : map.values()) {
            maxEdges = Math.max(maxEdges, count);
        }

        return wall.size() - maxEdges;

    }
}