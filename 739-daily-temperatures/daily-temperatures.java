class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Arrays.fill(ans,0);
        Stack<Integer> stk = new Stack<>();
        HashMap<Integer,Integer> map = new LinkedHashMap<>();
        for(int i=0;i<n;i++)
        {
            while(!stk.isEmpty() && temperatures[stk.peek()] < temperatures[i])
            {
              
                    
                ans[stk.peek()]= i-stk.pop();


            }
            stk.push(i);
        }

        return ans;
    }
}