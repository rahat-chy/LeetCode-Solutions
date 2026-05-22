class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l=0,h=n-1,m;
        while(l<=h) {
            m = (h-l)/2;
            m+=l;

            if(nums[m]==target) {
                return m;
            }

            if(nums[m]<nums[n-1]) {
                if(target>=nums[m] && target<=nums[n-1]) {
                    l = m+1;
                } else {
                    h=m-1;
                }
            } else {
                if(target>=nums[0] && target<=nums[m]) {
                   h = m-1;
                } else {
                    l=m+1;
                }
            }
        }

        return -1;
    }
}