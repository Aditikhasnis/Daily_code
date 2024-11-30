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
        

        if len(stk)==0:
            return True
        return False



        