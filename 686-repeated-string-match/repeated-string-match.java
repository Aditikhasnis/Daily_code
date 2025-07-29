class Solution {
    public int repeatedStringMatch(String a, String b) {
        
        int c_b=b.length();
        String temp="";
        while( c_b > temp.length())
        {
            temp+=a;
        }
        if(temp.length()>=b.length() && !temp.contains(b))
        {
            temp+=a;
        }
        return temp.contains(b) ? temp.length()/a.length() : -1 ;


        
    }
}