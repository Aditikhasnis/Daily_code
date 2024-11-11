class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:

        res=[]
        if len(intervals)==1:
            return intervals
        intervals=sorted(intervals,key=lambda x:x[0])
        newInterval=[intervals[0][0],intervals[0][1]]
        for i in range(1,len(intervals)):
            
            if intervals[i][0]<=newInterval[1]:
                newInterval=[min(newInterval[0],intervals[i][0]), max(intervals[i][1],newInterval[1])]
            else:
                res.append(newInterval)
                newInterval=intervals[i]
        
        res.append(newInterval)

        return res

            

        