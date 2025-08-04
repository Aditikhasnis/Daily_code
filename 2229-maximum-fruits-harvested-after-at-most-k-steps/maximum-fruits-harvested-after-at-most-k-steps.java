class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {

        int maxPos = Math.max(startPos + k, fruits[fruits.length - 1][0]);
        int[] prefixSum = new int[maxPos + 2];  // +2 to handle bounds
        Arrays.fill(prefixSum, 0);

        for (int[] subArray : fruits) {
            prefixSum[subArray[0]] = subArray[1];
        }

        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] += prefixSum[i - 1];
        }

        int result = 0;

        // Case 1: Move left first, then right
        for (int left = 0; left <= k; left++) {
            int right = k - 2 * left;
            if (right < 0) continue;

            int l = Math.max(0, startPos - left);
            int r = Math.min(prefixSum.length - 1, startPos + right);
            int total = prefixSum[r] - (l > 0 ? prefixSum[l - 1] : 0);
            result = Math.max(result, total);
        }

        // Case 2: Move right first, then left
        for (int right = 0; right <= k; right++) {
            int left = k - 2 * right;
            if (left < 0) continue;

            int l = Math.max(0, startPos - left);
            int r = Math.min(prefixSum.length - 1, startPos + right);
            int total = prefixSum[r] - (l > 0 ? prefixSum[l - 1] : 0);
            result = Math.max(result, total);
        }

        return result;
    }
}
