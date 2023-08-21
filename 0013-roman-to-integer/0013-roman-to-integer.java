class Solution {
    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentSymbol = s.charAt(i);
            int currentValue;

            switch (currentSymbol) {
                case 'I':
                    if (i + 1 < s.length() && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
                        currentValue = -1;
                    } else {
                        currentValue = 1;
                    }
                    break;
                case 'V':
                    currentValue = 5;
                    break;
                case 'X':
                    if (i + 1 < s.length() && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
                        currentValue = -10;
                    } else {
                        currentValue = 10;
                    }
                    break;
                case 'L':
                    currentValue = 50;
                    break;
                case 'C':
                    if (i + 1 < s.length() && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
                        currentValue = -100;
                    } else {
                        currentValue = 100;
                    }
                    break;
                case 'D':
                    currentValue = 500;
                    break;
                case 'M':
                    currentValue = 1000;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid symbol: " + currentSymbol);
            }

            result += currentValue;
        }
        return result;
    }
}
