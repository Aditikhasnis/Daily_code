class Solution {
    public String simplifyPath(String path) {

        if(path.equals("/..") || path.equals("/"))
        {
            return "/";
        }
        String[] parts = path.split("/");

        StringBuilder sb = new StringBuilder();
        Stack<String> stk = new Stack<>();
        for(int i=0 ;i< parts.length;i++)
        {
            if(parts[parts.length-i-1]!="")
            stk.push("/"+ parts[parts.length-i-1]);
        }
        Stack<String> result = new Stack<>();
        while(!stk.isEmpty())
        {
            if(stk.peek().equals("/..") )
            {
                String val =stk.pop();
                if(!result.isEmpty())
                    result.pop();
            } else if (stk.peek().equalsIgnoreCase("/.")) {
                 stk.pop();
            } else{
                 result.push(stk.pop());
            }
        }
        while (!result.isEmpty()) {
            sb.insert(0,result.pop());
        }

        return sb.length() == 0 ? "/" : sb.toString();

        
    }
}