class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int i,j,n=boxGrid.length,m=boxGrid[0].length,k;
        char[][] ans = new char[m][n];
        for(i=0;i<n;i++) {
            k=m;
            for(j=m-1;j>=0;j--) {
                if(boxGrid[i][j]=='*') {
                    k=j;
                } else if(boxGrid[i][j]=='#') {
                    boxGrid[i][j]='.';
                    boxGrid[i][k-1]='#';
                    k--;
                }
            }

            for(j=0;j<m;j++) {
                ans[j][n-1-i] = boxGrid[i][j];
            }
        }
        return ans;
    }
}