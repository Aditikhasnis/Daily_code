class Solution:
    def wordSubsets(self, words1: List[str], words2: List[str]) -> List[str]:

        res=[]
        dicti={}

        for i in words2:
            char=[0]*26
            for j in i:
                char[ord(j)-97]+=1
                dicti[j]=max(char[ord(j)-97],dicti.get(j,0))
        for j in words1:
            parent=Counter(j)
            Valid=True
            for char,count in dicti.items():
                if parent.get(char,0)<count:
                    Valid=False
            if Valid:
                res.append(j)
        return res






        