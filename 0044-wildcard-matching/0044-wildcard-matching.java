class Solution {
    public boolean isMatch(String s, String p) {
        int sIndex = 0;  
        int pIndex = 0;  
        int sStarIndex = -1;  
        int pStarIndex = -1;  

        
        while (sIndex < s.length()) {
            if (pIndex < p.length() && (p.charAt(pIndex) == s.charAt(sIndex) || p.charAt(pIndex) == '?')) {
                sIndex++;
                pIndex++;
            } 
            
            else if (pIndex < p.length() && p.charAt(pIndex) == '*') {
                sStarIndex = sIndex;
                pStarIndex = pIndex;
                pIndex++;
            } 
           
            else if (pStarIndex != -1) {
                pIndex = pStarIndex + 1;
                sStarIndex++;
                sIndex = sStarIndex;
            } 
           
            else {
                return false;
            }
        }

    
        while (pIndex < p.length() && p.charAt(pIndex) == '*') {
            pIndex++;
        }
        
        return pIndex == p.length();
    }
}
