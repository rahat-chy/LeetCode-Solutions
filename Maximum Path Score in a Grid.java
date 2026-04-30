class Solution {

    int solve(int i, int j, int[][] grid, int[][][] dp, int k, int n, int m, int cost) {
        int c = grid[i][j];
        if(grid[i][j]==2)
            c--;
        cost+=c;
        
        if(i==n-1 && j==m-1) {
            if(cost<=k) {
                return grid[i][j];
            }
            return -1;
        }
        if(dp[i][j][cost]!=-2) {
            return dp[i][j][cost];
        }
        if(cost>k) {
            dp[i][j][cost] = -1;
            return dp[i][j][cost];
        }
        int a=-1,b=-1;
        if((i+1)<n) {
            a = solve(i+1,j,grid,dp,k,n,m,cost);
        }
        if((j+1)<m) {
            b = solve(i,j+1,grid,dp,k,n,m,cost);
        }
        
        a = Math.max(a,b);
        if(a!=-1) {
            dp[i][j][cost] = grid[i][j]+a;
        } else {
            dp[i][j][cost] = -1;
        }

        return dp[i][j][cost];
    }

    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int[][][] dp = new int[n][m][1005];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                Arrays.fill(dp[i][j], -2);
            }
        }
        return solve(0,0,grid,dp,k,n,m,0);
    }
}