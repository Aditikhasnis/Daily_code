class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> pSet = new HashMap<>();
        for(int i=0;i<p.length();i++)
        {
            pSet.put(p.charAt(i),pSet.getOrDefault(p.charAt(i),0)+1 );

        }
        HashMap<Character,Integer> resSet = new HashMap<>();
        int i=0;
        int j=0;
        List<Integer> lias = new ArrayList<>();
        for(int right=0; right < s.length() ;right++)
        {
            char c = s.charAt(right);
            resSet.put(c, resSet.getOrDefault(c,0)+1);

            if(right-i+1 == p.length())
            {
                if(resSet.equals(pSet))
                lias.add(i);
            char leftChar = s.charAt(i);
            resSet.put(leftChar,resSet.get(leftChar)-1);
            if(resSet.get(leftChar)==0)
            {
                resSet.remove(leftChar);
            }
            i++;
            }
            
        }

        return lias;
    }
}