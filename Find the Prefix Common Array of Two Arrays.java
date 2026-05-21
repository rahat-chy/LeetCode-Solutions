class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int i, n=A.length,c=0;
        Map<Integer, Integer> mp = new HashMap<>();
        int[] ans = new int[n];

        for(i=0;i<n;i++) {
            if(A[i]==B[i]) {
                c++;
            } else {
                if(mp.getOrDefault(A[i], 0)==1)
                    c++;
                if(mp.getOrDefault(B[i], 0)==1)
                    c++;
            }
            mp.put(A[i],mp.getOrDefault(A[i], 0)+1);
            mp.put(B[i],mp.getOrDefault(B[i], 0)+1);
            ans[i]=c;
        }

        return ans;
    }
}