class Solution {
    public String removeKdigits(String num, int k) {
       Stack<Character> stk = new Stack<>();
       if(num.length()==k)
       {
        return "0";
       }
       
        for(int i=0;i<num.length();i++) {
            while ( !stk.isEmpty() &&
              k>0 && Integer.valueOf(stk.peek())>Integer.valueOf(num.charAt(i))) {
                stk.pop();
                k--;
            }
            stk.push(num.charAt(i));
        }
        while (k-->0)
        {
            if(!stk.isEmpty())
            stk.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty())
        {
            sb.append(stk.removeFirst());
        }
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}