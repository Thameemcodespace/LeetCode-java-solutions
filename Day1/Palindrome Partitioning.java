class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp =new int[n+1];
        for(int i=n-1;i>=0;i--){
            int min = Integer.MAX_VALUE;
            int cost = 0;
            for(int index=i;index<=n-1;index++){
                if(isPalindrome(s,i,index)){
                    cost = 1+dp[index+1];
                }
                min = Math.min(min,cost);
            }
            dp[i] = min;
        }
        return dp[0]-1;
    }

    public boolean isPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
