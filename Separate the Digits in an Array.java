class Solution {
    public int[] separateDigits(int[] nums) {
        List <Integer> list = new ArrayList<>();
        int i,a,b,c,n=nums.length;
        for(i=0;i<n;i++) {
            a=nums[i];
            b=0;
            c=0;
            int f=0;
            while(a!=0) {
                if(a%10==0 && f==0)
                    c++;
                else 
                    f=1;
                b=(b*10)+(a%10);
                a/=10;
            }
            while(b!=0) {
                list.add(b%10);
                b/=10;
            }
            while(c!=0) {
                list.add(0);
                c--;
            }
        }
        int m = list.size();
        int[] ans = new int[m];
        for(i=0;i<m;i++) {
            ans[i]=list.get(i);
        }

        return ans;
    }
}