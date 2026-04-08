class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<>();
        int maxRes=0;
        for(int currValue : heights)
        {
            int i=0;
            while(!stk.isEmpty() && stk.peek()> currValue)
            {
                i++;
                maxRes=Math.max(stk.pop()*i , maxRes);
            }
            while(i-->0)
            {
                stk.push(currValue);
            }
            stk.push(currValue);
        }
        int i=0;
        while(!stk.isEmpty())
        {
            i++;
            maxRes=Math.max(stk.pop()*i , maxRes);
        }
        return maxRes;
    }
}