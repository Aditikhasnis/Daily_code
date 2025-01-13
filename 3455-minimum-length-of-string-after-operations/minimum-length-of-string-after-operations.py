class Solution:
    def minimumLength(self, s: str) -> int:


        c=Counter(s)
        count=0
        for i,j in c.items():
            if j%2==0:
                count+=2
            else:
                count+=1
            

        return count

            
                

                




        
        