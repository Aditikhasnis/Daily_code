class Solution {
  PriorityQueue<int[]> minQ = new PriorityQueue<>((a,b)-> a[0] - b[0]); // min by value
    PriorityQueue<int[]> maxQ = new PriorityQueue<>((a,b)-> b[0] - a[0]); // max by value

    public int longestSubarray(int[] nums, int limit) {
        int i = 0, result = 0;

        for (int j = 0; j < nums.length; j++) {
            minQ.offer(new int[]{nums[j], j});
            maxQ.offer(new int[]{nums[j], j});

            // shrink window until valid
            while (!minQ.isEmpty() && !maxQ.isEmpty() &&
                   maxQ.peek()[0] - minQ.peek()[0] > limit) {
                i++;

                // lazy delete: remove elements outside window
                while (!minQ.isEmpty() && minQ.peek()[1] < i) minQ.poll();
                while (!maxQ.isEmpty() && maxQ.peek()[1] < i) maxQ.poll();
            }

            result = Math.max(result, j - i + 1);
        }

        return result;
    }
}