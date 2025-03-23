class Solution {
    
    public static void  recurse(int n ,String str ,int open , int close , List<String> result)
    {
        
        if(open==n && close ==n)
        {
            result.add(str);
            return ;
        }
        if(open<n)
        {
            
            recurse(n,str+"(" ,open+1,close,result);
           
            
            
        }
        if(close<open)
        {
            
            recurse(n, str+')', open , ++close,result);
            
        }

        return  ;


    } 
    public List<String> generateParenthesis(int n) {
      
        List<String> result = new ArrayList<>();
        recurse(n ,"", 0  , 0 ,result );
        return result;

    }
}