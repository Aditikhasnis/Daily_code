class Solution {
    public int repeatedStringMatch(String a, String b) {
        
        int c_b=b.length();
        StringBuilder sb = new StringBuilder();
        while( c_b > sb.length())
        {
            sb.append(a);
        }
        String temp = sb.toString();
        if(temp.length()>=b.length() && !temp.contains(b))
        {
            temp+=a;
        }
        return temp.contains(b) ? temp.length()/a.length() : -1 ;


        
    }
}