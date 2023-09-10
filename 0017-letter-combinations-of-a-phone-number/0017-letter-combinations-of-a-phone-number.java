import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        String[] mapping = {
            "",    // 0
            "",    // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs",// 7
            "tuv", // 8
            "wxyz" // 9
        };
        
        letterCombinationsHelper(digits, 0, "", result, mapping);
        return result;
    }
    
    private void letterCombinationsHelper(String digits, int index, String current, List<String> result, String[] mapping) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }
        
        int digit = Character.getNumericValue(digits.charAt(index));
        String letters = mapping[digit];
        
        for (int i = 0; i < letters.length(); i++) {
            letterCombinationsHelper(digits, index + 1, current + letters.charAt(i), result, mapping);
        }
    }
}