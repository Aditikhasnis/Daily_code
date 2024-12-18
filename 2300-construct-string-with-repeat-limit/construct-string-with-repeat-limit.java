import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        // Frequency map
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Max-heap to process characters lexicographically largest first
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> Character.compare(b, a));
        maxHeap.addAll(map.keySet());

        StringBuilder res = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            // Get the lexicographically largest character
            char curr = maxHeap.poll();
            int count = map.get(curr);

            // Determine how many times we can use `curr` without breaking the repeatLimit
            int use = Math.min(count, repeatLimit);
            res.append(String.valueOf(curr).repeat(use));

            // Update the remaining count of `curr`
            map.put(curr, count - use);

            // If `curr` has remaining occurrences, push it back into the heap temporarily
            if (count > use) {
                if (maxHeap.isEmpty()) break; // No more characters to alternate with
                char next = maxHeap.poll(); // Next lexicographically largest character

                // Append the next character once
                res.append(next);
                map.put(next, map.get(next) - 1);

                // Re-add `curr` and `next` if they still have remaining counts
                if (map.get(next) > 0) maxHeap.offer(next);
                maxHeap.offer(curr);
            }
        }

        return res.toString();
    }
}