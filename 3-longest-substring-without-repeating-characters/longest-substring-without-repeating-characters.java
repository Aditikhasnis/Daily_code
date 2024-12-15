class Solution {
    public int lengthOfLongestSubstring(String s) {

    



        HashSet<Character> set = new HashSet<>();

        int l=0;
        int r=0;

        int maxi=0;
        int n=s.length();

        while (r<n)
        {
            if(set.contains(s.charAt(r)))
            {
                while ( s.charAt(l)!=s.charAt(r))
                {
                set.remove(s.charAt(l));
                l++;

                }
                l++;

            }
            set.add(s.charAt(r));
            maxi=Math.max(maxi,r-l+1);
            r++;

        }


        return maxi;


        



        
    }
}