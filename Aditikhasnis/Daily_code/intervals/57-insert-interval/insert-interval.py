from typing import List

class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        res = []
        u, v = newInterval[0], newInterval[1]
        
        i = 0  
        while i < len(intervals):
            
            if intervals[i][1] < u:
                res.append(intervals[i])
            elif intervals[i][0] > v:
                res.append([u, v])
                u, v = intervals[i]
            else:
                u = min(u, intervals[i][0])
                v = max(v, intervals[i][1])
            i += 1
        res.append([u, v])

        return res
