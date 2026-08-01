class Solution {
    class Idx{
        int val;
        int cnt;
        Idx(int val,int cnt){
            this.val=val;
            this.cnt=cnt;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Idx> pq=new PriorityQueue<>((a,b)->(b.cnt-a.cnt));
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            pq.offer(new Idx(nums[i],map.get(nums[i])));
        }

        int[] ans=new int[k];
        int i=0;
        while(i<k){
            Idx cur=pq.poll();
            if(cur.cnt==map.get(cur.val)){
                ans[i]=cur.val;
                i++;
            }
        }
        return ans;

    
    }
}