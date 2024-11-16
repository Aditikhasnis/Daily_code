class Solution {
    public int[] nextGreaterElements(int[] nums) {


        Stack<Integer> stk = new Stack<>();
        int n =nums.length;
        int[] res = new int[n];
        for(int i=(2*n)-1;i>=0;i--)
        {
            while(!stk.isEmpty() && stk.peek()<=nums[i%n] )
            {
                stk.pop();
            }

            if(i<n)
            {
                if(stk.isEmpty())
                {
                    res[i]=-1;
                }
                else{
                    res[i]=stk.peek();
                }

            }

            stk.push(nums[i%n]);


        }

        return res;










    }
}