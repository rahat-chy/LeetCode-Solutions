class Solution {

    public int minJumps(int[] nums) {
        int mx=0,i,j,n=nums.length;

        if(n==1)
            return 0;

        for(i=0;i<n;i++) {
            mx=Math.max(mx,nums[i]);
        }

        int[] pf = new int[mx+1];

        for(i=0;i<=mx;i++) {
            pf[i]=i;
        }

        for(i=2;i*i<=mx;i++) {
            if(pf[i]==i) {
                for(j=i*i;j<=mx;j+=i) {
                    if(pf[j]==j) {
                        pf[j]=i;
                    }
                }
            }
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(i=0;i<n;i++) {
            int a = nums[i];

            Set<Integer> st = new HashSet<>(); 

            while(a>1) {
                int b = pf[a];

                if(!st.contains(b)){
                    map.computeIfAbsent(b, k -> new ArrayList<>()).add(i);
                    st.add(b);
                }

                a/=b;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        int[] dist = new int[n];
        Arrays.fill(dist, -1);  
        dist[0] = 0;

        while (!q.isEmpty()) {
            i = q.poll();

            int x = dist[i];

            if (i == n - 1) {
                return x;
            }

            if (i - 1 >= 0 && dist[i - 1] == -1) {
                dist[i - 1] = x + 1;
                q.add(i - 1);
            }

            if (i + 1 < n && dist[i + 1] == -1) {
                dist[i + 1] = x + 1;
                q.add(i + 1);
            }

            int val = nums[i];

            if (val > 1 && pf[val] == val) {

                List<Integer> list = map.getOrDefault(val, new ArrayList<>());

                for (j=0;j<list.size();j++) {
                    if (dist[list.get(j)] == -1) {
                        dist[list.get(j)] = x + 1;
                        q.add(list.get(j));
                    }
                }

                list.clear();
            }
        }

        return -1;
    }
}