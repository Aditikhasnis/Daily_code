class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int maxNum = Arrays.stream(nums).max().getAsInt();
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        long res = 0;

        for (int end = 0; end < n; end++) {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);

            // ✅ Count as soon as we get at least k max elements
            if (nums[end] == maxNum && map.get(maxNum) >= k) {
                res += (n - end);
            }

            // ✅ Then shrink the window from the left as long as condition holds
            while (map.getOrDefault(maxNum, 0) >= k) {
                map.put(nums[start], map.get(nums[start]) - 1);

                // If even after shrinking we still have >=k max, count again
                if (map.get(maxNum) >= k) {
                    res += (n - end);
                }
                start++;
            }
        }
        return res;
    }
}
