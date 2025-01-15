class Solution:
    def minWindow(self, s: str, t: str) -> str:


        if s==t:
            return s
        l,r=0,0
        n=len(s)
        dicti={}
        for i in t:
            dicti[i]=dicti.get(i,0)+1
        dics={}
        mini=float('inf')
        formed=0
        required=len(dicti)
        result=''
        while r<n:
            char = s[r]
            if char in dicti:
                dics[char] = dics.get(char, 0) + 1
                if dics[char] == dicti[char]:
                    formed += 1
            while formed == required:
                if r - l + 1 < mini:
                    mini = r - l + 1
                    result = s[l:r+1]
                char = s[l]
                if char in dicti:
                    dics[char] -= 1
                    if dics[char] < dicti[char]:
                        formed -= 1
                l += 1

            r += 1

        return result

            
            
    



        

        
        