class Solution {
    public int reverse(int x) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        int reversed = 0;

        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            
            if (reversed > max / 10 || (reversed == max / 10 && pop > 7)) {
                return 0;
            }
            if (reversed < min / 10 || (reversed == min / 10 && pop < -8)) {
                return 0;
            }

            reversed = reversed * 10 + pop;
        }

        return reversed;
    }
}
