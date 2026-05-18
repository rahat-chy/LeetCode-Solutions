class P {
    int index;
    int cost;

    P(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }
}

class Solution {

    public int minJumps(int[] arr) {
        int n = arr.length;
        int[] vis = new int[n];
        Arrays.fill(vis,0);

         Map<Integer, List<Integer>> mp = new HashMap<>();
         for (int i = 0; i < n; i++) {
            mp.computeIfAbsent(arr[i], v -> new LinkedList<>()).add(i);
        }

        Queue<P> q = new LinkedList<>();
        q.add(new P(0,0));
        vis[0]=1;
        while(q.size()!=0) {
            P temp = q.poll();
            vis[temp.index]=1;
            if(temp.index==n-1) {
                return temp.cost;
            }

            if(vis[temp.index+1]==0) {
                q.add(new P(temp.index+1,temp.cost+1));
            }
            
            if(temp.index!=0 && vis[temp.index-1]==0) {
                q.add(new P(temp.index-1,temp.cost+1));
            }

            for (int item : mp.get(arr[temp.index])) {
                if (vis[item]==0) {
                    q.add(new P(item,temp.cost+1));
                }
            }
            mp.get(arr[temp.index]).clear();
        }

        return n-1;
    }
}