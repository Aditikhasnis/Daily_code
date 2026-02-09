class Solution {
    public int minimumLength(String s) {

        int i=0,j=s.length();
        int end=s.length();
        while(j-i>0)
        {
            Character ch1 = s.charAt(i);
            Character ch2 = s.charAt(j-1);
            if(ch1!=ch2)
            {
                break;
            }

            if(i+1<end && s.charAt(i+1)==ch1)
            i++;
            else if(j-2>0 && s.charAt(j-2)==ch2)
            j--;
            else{
                i++;
                j--;
            }
        
        }
        return j-i>=0?j-i:1 ;
    }
}