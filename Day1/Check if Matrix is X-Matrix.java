class Solution {
    public boolean checkXMatrix(int[][] a) {
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                if(i==j||i+j==a.length-1){
                    if(a[i][j]==0){
                        return false;
                    }
                }
                else {
                        if(a[i][j]!=0)
                        {
                            return false;
                        }
                }
            }
        }
        return true;
    }
}
