class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || haystack == null) {
            return -1;
        }
        
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        
        if (needleLength == 0) {
            return 0;
        }
        
        if (haystackLength < needleLength) {
            return -1;
        }
        
        for (int i = 0; i <= haystackLength - needleLength; i++) {
            int j;
            for (j = 0; j < needleLength; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            
            if (j == needleLength) {
                return i;
            }
        }
        
        return -1;
    }
}
