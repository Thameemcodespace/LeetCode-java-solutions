class Solution {
    public int hammingDistance(int x, int y) {
        int dis=0;
        int m=x^y;
        while(m!=0){
            if((m&1)==1)
            dis++;
        m=m>>1;
        }
        return dis;
    }
}
