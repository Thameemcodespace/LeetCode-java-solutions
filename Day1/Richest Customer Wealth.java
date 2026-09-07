class Solution {
    public int maximumWealth(int[][] a) {
        int max=0;
        for(int i=0;i<a.length;i++){
            int c = 0;
            for(int j=0;j<a[i].length;j++){
                c+=a[i][j];
            }
            if(c>max){
                max=c;
            }
        }
        return max;
    }
}
