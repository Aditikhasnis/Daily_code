import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public long distinctNames(String[] ideas) {
        List<String> words = Arrays.asList(ideas);

        // Map: first letter -> set of suffixes
        Map<Character, Set<String>> letters = new HashMap<>();
        for (String word : words) {
            char first = word.charAt(0);
            String suffix = word.substring(1);
            letters.putIfAbsent(first, new HashSet<>());
            letters.get(first).add(suffix);
        }

        long result = 0;

        // Compare every pair of first letters
        List<Character> keys = new ArrayList<>(letters.keySet());
        for (int i = 0; i < keys.size(); i++) {
            for (int j = i + 1; j < keys.size(); j++) {
                char c1 = keys.get(i);
                char c2 = keys.get(j);

                Set<String> set1 = letters.get(c1);
                Set<String> set2 = letters.get(c2);

                // Count common suffixes
                long common = 0;
                for (String suf : set1) {
                    if (set2.contains(suf)) common++;
                }

                // Unique suffixes in each set
                long unique1 = set1.size() - common;
                long unique2 = set2.size() - common;

                // Total valid combinations
                result += unique1 * unique2 * 2; // multiply by 2 for both swap directions
            }
        }

        return result;
    }
}
