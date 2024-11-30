class Solution:
    def isValid(self, s: str) -> bool:


        stk=[]
        i=0
        while i<len(s):

            if stk:
                if stk[-1]=='(' and s[i]==')':
                    stk.pop()
                elif stk[-1]=='{' and s[i]=='}':
                    stk.pop()
                elif stk[-1]=='[' and s[i]==']':
                    stk.pop()
                else:
                    stk.append(s[i])
                
            else:
                stk.append(s[i])
            i+=1
        

        return True if len(stk)==0 else False 



        