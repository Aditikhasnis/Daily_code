from collections import Counter

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        mapi=Counter(s)
        res=[]       
        vis=set()
        count=0
        counter=0
        k=0
        for i in s:
            print(f"{i}{counter}{k}")
            if i not in vis:
                if counter==0 and k!=0:
                    print('correct')
                    res.append(k)
                    k=0
                    vis=set()
                vis.add(i)
                counter+=(mapi[i]-1)
                       
            else:
                counter-=1
            
            k+=1
        if k>0:
            res.append(k)
        return res

            





        