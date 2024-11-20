class Solution:
    def takeCharacters(self, s: str, k: int) -> int:

        counter=[0,0,0]
        # print(ord('a'))
        for c in s:
            counter[ord(c)-97]+=1
        if min(counter)<k:
            return -1

        res=float("inf")
        l=0
        n=len(s)
        for r in range(n):

            counter[ord(s[r])-97]-=1

            while l<len(s) and min(counter)<k:
                counter[ord(s[l]) - 97]+=1
                l+=1
            res=min(res,len(s)-(r-l+1))


        return res






            
                
            
        










        