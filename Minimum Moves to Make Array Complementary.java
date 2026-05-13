class Solution {
    public int minMoves(int[] nums, int limit) {
        int i,a,b,ans=Integer.MAX_VALUE,n=nums.length;
        int[] arr = new int[(2*limit)+2];

        for(i=0;i<n/2;i++) {
            a = Math.min(nums[i], nums[n - 1 - i]);
            b = Math.max(nums[i], nums[n - 1 - i]);

            arr[2] += 2;
            arr[a + 1] -= 1;
            arr[a + b] -= 1;
            arr[a + b + 1] += 1;
            arr[b + limit + 1] += 1;
        }
        
        a=0;
        for(i=2;i<=2*limit;i++) {
            a+=arr[i];
            ans = Math.min(ans,a);
        }

        return ans;
    }
}