class Solution {
    public String removeOuterParentheses(String s) {
        

Stack<Character> stk = new Stack<>();

        String res ="";
        int count=0;
        for(int i=0;i<s.length();i++)
        {
   
           if(s.charAt(i) =='(')
           {
               if(stk.isEmpty())
               {
                   stk.push('(');
               }
               else{
                   res+='(';
                   count++;
               }
           }
           else{
               if(!stk.isEmpty() && count==0)
               {
                   stk.pop();
               }
               else if(count>0)
               {
                   count--;
                   res+=')';
               }
           }
   
   
   
   
        }
        return res;

        
    }
}