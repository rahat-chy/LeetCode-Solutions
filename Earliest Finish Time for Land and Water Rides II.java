class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int i,landmin=Integer.MAX_VALUE,ans1=Integer.MAX_VALUE;

        for(i=0;i<landStartTime.length;i++) {
            landmin = Math.min(landmin, landStartTime[i]+landDuration[i]);
        }
        for(i=0;i<waterStartTime.length;i++) {
            ans1 = Math.min(ans1, Math.max(landmin,waterStartTime[i])+waterDuration[i]);
        }
        
        int watermin=Integer.MAX_VALUE,ans2=Integer.MAX_VALUE;

        for(i=0;i<waterStartTime.length;i++) {
            watermin = Math.min(watermin, waterStartTime[i]+waterDuration[i]);
        }
        for(i=0;i<landStartTime.length;i++) {
            ans2 = Math.min(ans2, Math.max(watermin,landStartTime[i])+landDuration[i]);
        }

        return Math.min(ans1,ans2);
    }
}