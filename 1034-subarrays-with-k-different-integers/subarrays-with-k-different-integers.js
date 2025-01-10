/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var subarraysWithKDistinct = function(nums, k) {
    function counting(k) {
        let l = 0;
        let r = 0;
        const n = nums.length;
        let dict = {};
        let uniqueCount = 0; 
        let count = 0;

        while (r < n) {

            if (!dict[nums[r]]) {
                dict[nums[r]] = 0;
                uniqueCount++;
            }
            dict[nums[r]]++;
            r++;

            while (uniqueCount > k) {
                dict[nums[l]]--;
                if (dict[nums[l]] === 0) {
                    delete dict[nums[l]];
                    uniqueCount--;
                }
                l++;
            }

            count += r - l+1;
        }

        return count;
    }

    
    return counting(k) - counting(k - 1);
};