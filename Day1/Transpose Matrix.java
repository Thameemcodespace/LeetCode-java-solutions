class Solution {
    public int[][] transpose(int[][] a) {
        int b[][]=new int [a[0].length][a.length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                b[j][i]=a[i][j];
            }
        }
        return b;
    }
}
