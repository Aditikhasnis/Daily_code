class Solution:
    def decrypt(self, code: List[int], k: int) -> List[int]:

        if k==0:
            return [0]*(len(code))

        n=len(code)
        res=[]
        flag=0
        if k<0:
            code=code[::-1]
            k=abs(k)
            flag=1
        for i in range(n):
            sumi=0
            for j in range(i+1,i+k+1):
                sumi+=code[j%n]
            res.append(sumi)
        
        return res if flag==0 else res[::-1]



                    








        