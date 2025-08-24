class Solution {
    public int strStr(String haystack, String needle) {
        int j=needle.length();
        for(int i=0;i<=haystack.length()-j;i++)
        {
            if(needle.equals(haystack.substring(i,i+j)))
            { 
                    return i;
            }
        }

        return needle.equals(haystack)? 0 : -1;
    }
}