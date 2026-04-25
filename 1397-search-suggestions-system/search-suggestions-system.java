 class TrieNode {
    public TrieNode[] children;
    public boolean isLeaf;

    TrieNode()
    {
        children = new TrieNode[26];
        isLeaf = false;
    }
}

 class Trie{
    TrieNode root;

     Trie() { root = new TrieNode(); }
     void insert (TrieNode root , String word)
     {
         TrieNode curr = root;
         for(char c : word.toCharArray())
         {
             if(curr.children[c-'a']==null)
             {
                 curr.children[c-'a']=new TrieNode();
             }
             curr = curr.children[c-'a'];
         }
        curr.isLeaf=true;

     }

    String prefix(TrieNode root , String s)
    {
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray())
        {
            if(curr.children[c-'a']==null)
            {
                break;
            }
            curr=curr.children[c-'a'];
            sb.append(c);
        }
        if(sb.isEmpty())
        {
            return "";
        }
        int i=0;
        while(i<26 && !curr.isLeaf)
        {
            if(curr.children[i]!=null)
            {
                sb.append((char) (i+'a'));
                curr=curr.children[i];
                i=-1;
            }
            i++;
        }
        return sb.toString();

    }
}


class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    List<List<String>> result = new ArrayList<>();
    Trie trie = new Trie();
    Arrays.sort(products);
    HashMap<String,Integer> map = new HashMap<>();
    int i=0;
    for(String s : products)
 {
     trie.insert(trie.root, s);
     if(!map.containsKey(s))
     {
         map.put(s,i);
     }
     i++;
 }
 StringBuilder sb = new StringBuilder();
 for(char c : searchWord.toCharArray())
 {
     sb.append(c);
    String prefix=sb.toString();
     String word = trie.prefix(trie.root,prefix);
    if(word.isEmpty())
     {
         result.add( new ArrayList<>());
     }
     if(map.containsKey(word)) {
         int index = map.get(word);
         List<String> lst = new ArrayList<>();
         int counter=0;
         while (index < products.length)
         {
            if(counter>=3)
             {
                 break;
             }
            if(!products[index].startsWith(prefix))
             {
                break;
             }
             lst.add(products[index]);
             index++;
             counter++;
         }
        result.add(lst);


     }
 }


return result;
    }
}