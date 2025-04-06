class Solution:
    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:

        nums=sorted(nums)
        n=len(nums)
        memo: Dict[Tuple[int, int], List[int]] = {} 

        def rec(memo,curr_ind,prev_val,nums,n):

            if curr_ind==n:
                return []
            
            if (curr_ind,prev_val) in memo:
                return memo[(curr_ind,prev_val)]
            

            include=[]
            if prev_val==-1 or nums[curr_ind]%prev_val==0:
                include=[nums[curr_ind]]+ rec(memo,curr_ind+1,nums[curr_ind],nums,n)
            
            exclude=rec(memo,curr_ind+1,prev_val,nums,n)

            memo[(curr_ind,prev_val)]=include if len(include)>len(exclude) else exclude

            return  memo[(curr_ind,prev_val)]


        
        return rec(memo,0,-1,nums,n)

        