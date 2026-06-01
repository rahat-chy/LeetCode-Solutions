class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        Queue<Integer> pq = new LinkedList<>();

        int i=cost.length-1,ans=0;
        while(i>=0) {
            if(pq.size()!=0) {
                int a = pq.peek();
                if(cost[i]<=a) {
                    pq.poll();
                    i--;
                    continue;
                }
            }
            ans+=cost[i];
            if(i!=0) {
                ans+=cost[i-1];
                pq.add(cost[i-1]);
            } 
            i-=2;
        }

        return ans;
    }
}