class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int i,n=nums.length,a=0,b=0;

        for(i=0;i<n;i++) {
            if(nums[i]<pivot) {
                a++;
            } else if(nums[i]==pivot) {
                b++;
            }
        }

        b+=a;
        int c=0;
        int[] ans = new int[n];

        for(i=0;i<n;i++) {
            if(nums[i]<pivot) {
                ans[c] = nums[i];
                c++;
            } else if(nums[i]==pivot) {
                ans[a] = nums[i];
                a++;
            } else {
                ans[b] = nums[i];
                b++;
            }
        }

        return ans;
    }
}