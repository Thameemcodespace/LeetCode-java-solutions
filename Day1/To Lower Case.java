class Solution {
    public String toLowerCase(String s) {
        char[] ans =s.toCharArray();
        for(int i=0;i<ans.length;i++){
            ans[i]=Character.toLowerCase(ans[i]);
        }
        return new String(ans);
    }
}
