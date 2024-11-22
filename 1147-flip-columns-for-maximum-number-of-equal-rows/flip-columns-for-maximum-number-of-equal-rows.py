class Solution:
    def maxEqualRowsAfterFlips(self, matrix: List[List[int]]) -> int:
        res=defaultdict(int)

        for row in matrix:

            key=tuple(row)
            if row[0]:
                key=tuple([0 if r else 1 for r in row])
            
            res[key]+=1

        
        return max(res.values())
        






            


            








        
        