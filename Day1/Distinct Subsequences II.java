class Solution {
    public int distinctSubseqII(String s) {
        int mod = 1000000007;
        int[] last = new int[26];
        int dp = 1;
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            int newDp = (2 * dp - last[index] + mod) % mod;
            last[index] = dp;
            dp = newDp;
        }
        return dp - 1;
    }
}
