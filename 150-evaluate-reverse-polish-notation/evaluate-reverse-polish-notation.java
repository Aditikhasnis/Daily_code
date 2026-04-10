class Solution {
    private int calculateTheValue(int val1 , int val2 , String op)
    {
        switch (op)
        {
            case "+":
                return val1 + val2;
            case "-":
                return val2 - val1;
            case "*":
                return val1 * val2;
            case "/":
                return val2 / val1;
            default:
                throw new IllegalArgumentException("Unknown operator: " + op);

        }
    }
    
    public int evalRPN(String[] tokens) {
        Set<String> keywords = new HashSet<>(Arrays.asList("+","-","*","/"));

        Stack<String> stk = new Stack<>();
        for (Iterator<String> it = Arrays.stream(tokens).iterator(); it.hasNext(); ) {
            String token = it.next(); // Get the actual string value
            if(!stk.empty() && keywords.contains(token))
            {
                int value1 =  Integer.valueOf(stk.pop()) ;
                int value2=1;
                if(!stk.isEmpty())
                value2 = Integer.valueOf(stk.pop());
               stk.push(String.valueOf(calculateTheValue(value1,value2,token)));

            }
            else {
                stk.push(token);
            }
        }
        return Integer.valueOf(stk.pop());
    }
}