class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int maxLength = 0;
        int[] charIndex = new int[128]; // ASCII 
        
        
        Arrays.fill(charIndex, -1);
        
        int start = 0;
        
        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            int charAscii = (int) currentChar;
            
         
            if (charIndex[charAscii] >= start) {
                start = charIndex[charAscii] + 1;
            }
            
            charIndex[charAscii] = end;
            maxLength = Math.max(maxLength, end - start + 1);
        }
        
        return maxLength;
    }
}
