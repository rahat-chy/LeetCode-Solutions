class Solution {
    public void rotate(int[][] matrix) {
        int i,j,a,b,c,d,n=matrix.length;

        i=0;
        j=0;
        while(n>1) {
            for(int k=j,x=0;k<n-1;k++,x++) {
                a=matrix[i][k];
                b=matrix[i+x][n-1];
                c=matrix[n-1][n-1-x];
                d=matrix[n-1-x][i];

                matrix[i+x][n-1]=a;
                matrix[n-1][n-1-x]=b;
                matrix[n-1-x][i]=c;
                matrix[i][k]=d;

                //System.out.println(a+" "+b+" "+c+" "+d);

                /*for(int l=0;l<n;l++) {
                    for(int m=0;m<n;m++) {
                        System.out.print(matrix[l][m]);
                    }
                    System.out.println("\n");
                }*/
            }
            i++;
            j++;
            n--;
        }
    }
}