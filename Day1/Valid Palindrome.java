class Solution {
    public boolean isPalindrome(String s) {
        String a = s.toLowerCase();
        String b = "";
        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                b = b + ch;
            }
        }
        String c = "";
        for (int i = b.length() - 1; i >= 0; i--) {
            c = c + b.charAt(i);
        }
        return b.equals(c);
    }
}
