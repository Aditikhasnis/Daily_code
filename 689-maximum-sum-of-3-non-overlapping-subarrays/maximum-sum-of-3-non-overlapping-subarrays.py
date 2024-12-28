from typing import List, Tuple, Dict

class Solution:
    def maxSumOfThreeSubarrays(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        sums = [0] * (n - k + 1)
        current_sum = sum(nums[:k])
        sums[0] = current_sum
        
        for i in range(1, len(sums)):
            current_sum += nums[i + k - 1] - nums[i - 1]
            sums[i] = current_sum
        
        memo: Dict[Tuple[int, int], Tuple[int, List[int]]] = {}
        
        def solve(current: int, count: int) -> Tuple[int, List[int]]:
            if count == 3:
                return 0, []
            if current > n - k:
                return float('-inf'), []
            
            if (current, count) in memo:
                return memo[(current, count)]
            
            include_sum, include_indices = solve(current + k, count + 1)
            include_sum += sums[current]
            include_indices = [current] + include_indices
            
            exclude_sum, exclude_indices = solve(current + 1, count)
            
            if include_sum > exclude_sum:
                result = (include_sum, include_indices)
            elif include_sum < exclude_sum:
                result = (exclude_sum, exclude_indices)
            else:
                result = (include_sum, min(include_indices, exclude_indices))
            
            memo[(current, count)] = result
            return result
        
        _, result = solve(0, 0)
        return result