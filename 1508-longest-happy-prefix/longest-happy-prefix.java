class Solution {
    public String longestPrefix(String s) {
        int[] arr = new int[s.length()];
        int i=1;
        int len=0;
        Arrays.fill(arr,0);
        while (i<s.length())
        {
            if(s.charAt(i)==s.charAt(len))
            {
                arr[i]=++len;
                  i++;
            }
            else{
                if(len>0)
                {
                    len=arr[len-1];
                }
                else{
                arr[i]=0;
                   i++;
                }
    
            }
          
        }
     return s.substring(0,arr[arr.length-1]);

        
    }
}