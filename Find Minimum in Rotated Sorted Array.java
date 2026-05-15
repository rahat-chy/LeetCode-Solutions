class Solution {
    public int findMin(int[] nums) {
        int i,ans=nums[0],n=nums.length;

        for(i=1;i<n;i++) {
            ans = Math.min(ans,nums[i]);
        }

        return ans;
    }
}