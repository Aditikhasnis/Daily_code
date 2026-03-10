class Solution {
    public int minAddToMakeValid(String s) {
         if(s.isEmpty())
        {
            return 0;
        }
        int result=0;
        Stack<Character> stk = new Stack<>();
        for(char c : s.toCharArray())
        {
            if(c == '(')
            {
                stk.push(c);
            }
            else{
                if(!stk.isEmpty() && stk.peek()=='(')
                {
                    stk.pop();
                }
                else{
                    result++;
                }
            }
        }

        return result+stk.size();

    }
}