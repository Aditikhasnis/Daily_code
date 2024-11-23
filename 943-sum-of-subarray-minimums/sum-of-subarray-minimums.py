class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:

        n=len(arr)
        stack=[]
        res=[n]*n
        MOD=10**9 +7 
        for i in range(len(arr)-1,-1,-1):

            while stack and stack[-1][0]>=arr[i]:
                stack.pop()
            if stack:
                res[i]=stack[-1][1]

            stack.append((arr[i],i))

        stack2=[]
        prev=[-1]*n
        sumi=0
        for i in range(n):
            while stack2 and stack2[-1][0]>arr[i]:
                stack2.pop()
            if stack2:
                prev[i]=stack2[-1][1]
            
            stack2.append((arr[i],i))
            # print(stack2)
        
        sumi = 0
        # print(f'{res} {prev}')
        for i in range(n):
            left_contribution = i - prev[i]
            right_contribution = res[i] - i
            contribution = left_contribution * right_contribution 
            # print(contribution)
            sumi = (sumi + (contribution*arr[i])) % MOD

        return sumi
    



            

        