class Solution {
    public int myAtoi(String s) {

        String res = s.trim();

        String sub = "";
        if(res.isEmpty()) return 0;

        int i=0;
        int sign=1;
        if(res.charAt(i)=='+' || res.charAt(i)=='-')
        {
            sign = res.charAt(i)=='+'? 1:-1;
            i++;

        }

        sub=res.substring(i);

        long  num=0;
         for(Character ch : sub.toCharArray())
         {

            if(Character.isDigit(ch))
            {
                int digit=ch-'0';
                if (num > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
                
                num=(num*10) + ch-'0';

            }
            else{

                break;
                
      
            }
         }

        return (int)(sign*num);
        
    }
}