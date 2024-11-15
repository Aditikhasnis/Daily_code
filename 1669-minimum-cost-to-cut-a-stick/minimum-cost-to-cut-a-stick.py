class Solution:
    def minCost(self, n: int, cuts: List[int]) -> int:


        def rec(l, r, dp, cuts):
            if r - l <= 1:
                return 0
            if (l, r) in dp:
                return dp[(l, r)]
        
            res = float('inf')
            for c in cuts:
                if l < c < r:
                    res = min(res, (r - l) + rec(l, c, dp, cuts) + rec(c, r, dp, cuts))
            dp[(l, r)] = 0 if res == float('inf') else res
            return dp[(l, r)]
        dp = {}
        cuts.sort()
        return rec(0, n, dp, cuts)

            




        