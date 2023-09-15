class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);

        long quotient = 0;
        while (longDividend >= longDivisor) {
            long tempDivisor = longDivisor;
            long multiple = 1;

            while (longDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            longDividend -= tempDivisor;
            quotient += multiple;
        }

        if (isNegative) {
            quotient = -quotient;
        }

        return (int) quotient;
    }
}
