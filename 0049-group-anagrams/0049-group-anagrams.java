class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();

        List<List<String>> result = new ArrayList<>();

        List<Pair> pairs = new ArrayList<>();

        for (String word : strs) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);

            boolean found = false;
            for (Pair pair : pairs) {
                if (pair.key.equals(sortedWord)) {
                    pair.group.add(word);
                    found = true;
                    break;
                }
            }

            if (!found) {
                Pair newPair = new Pair(sortedWord);
                newPair.group.add(word);
                pairs.add(newPair);
            }
        }

        for (Pair pair : pairs) {
            result.add(pair.group);
        }

        return result;
    }

    private static class Pair {
        String key;
        List<String> group;

        Pair(String key) {
            this.key = key;
            this.group = new ArrayList<>();
        }
    }
}
