class Solution:
    def maxScore(self, cardPoints: List[int], k: int) -> int:

        n=len(cardPoints)
        s=sum(cardPoints)
        mini_sum=sum(cardPoints[:n-k])
        res=mini_sum
        l,r=0,n-k
        while r<n:
            res+=(cardPoints[r]-cardPoints[l])
            l+=1
            r+=1
            mini_sum=min(mini_sum,res)

        return s-mini_sum


        