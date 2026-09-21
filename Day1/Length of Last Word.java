class Solution {
    public int lengthOfLastWord(String s) {
        s.trim();
        String []c=s.split("\\s+");
        return c[c.length-1].length();
    }
}
