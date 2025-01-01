class Solution:
    def maxScore(self, s: str) -> int:

        dicti={}
        count=0
        for i in s:
            if i=='1':
                dicti[i]=dicti.get(i,0)+1
        res=0
        # if len(dicti)==0:
        #     return 1
        for i in range(len(s)-1):
            if s[i]=='0':
                count+=1
            else:
                if s[i] in dicti and dicti[s[i]]>0:
                    dicti[s[i]]-=1
            res=max(res,(count + dicti.get('1',0)))
        return res
            
                
        