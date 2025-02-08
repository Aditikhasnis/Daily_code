class Solution {
    public boolean isPalindrome(String s) {
        
        int mid=s.length()/2;
        int i=0;
        int j=s.length()-1;
        String s3= s.toLowerCase();
        while(i<j)
        {
            Character s1 = s3.charAt(i);
            Character s2 =s3.charAt(j);
            if(Character.isLetterOrDigit(s1) && Character.isLetterOrDigit(s2))
            {
                
                if(s1!=s2)
                {
                    return false;
                }

                i++;
                j--;


            }
            else if (Character.isLetterOrDigit(s1))
                {
                    j--;
                }
        else { 
       
                    i++;
                }



            





        }

        return true;
    }
}