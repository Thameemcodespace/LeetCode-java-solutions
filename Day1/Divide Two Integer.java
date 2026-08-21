class Solution {
    public int divide(int dividend, int divisor) {

        int count = 0;
        boolean negative = false;

        if (dividend < 0) {
            dividend = -dividend;
            negative = !negative;
        }

        if (divisor < 0) {
            divisor = -divisor;
            negative = !negative;
        }

        while (dividend >= divisor) {
            dividend = dividend - divisor;
            count++;
        }

        if (negative) {
            count = -count;
        }

        return count;
    }
}
