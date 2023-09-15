class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> resultIndices = new ArrayList<>();
        
        if (s == null || s.isEmpty() || words == null || words.length == 0) {
            return resultIndices;
        }
        
        int wordLength = words[0].length();
        int totalWords = words.length;
        int totalLength = wordLength * totalWords;
        
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }
        
        for (int i = 0; i < wordLength; i++) {
            for (int j = i; j <= s.length() - totalLength; j += wordLength) {
                if (isConcatenatedSubstring(s, j, wordLength, totalWords, wordCounts)) {
                    resultIndices.add(j);
                }
            }
        }
        
        return resultIndices;
    }
    
    private boolean isConcatenatedSubstring(String s, int start, int wordLength, int totalWords, Map<String, Integer> wordCounts) {
        Map<String, Integer> seenWords = new HashMap<>();
        
        for (int i = 0; i < totalWords; i++) {
            int wordStart = start + i * wordLength;
            int wordEnd = wordStart + wordLength;
            String word = s.substring(wordStart, wordEnd);
            seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);
        }
        
        return seenWords.equals(wordCounts);
    }
}
