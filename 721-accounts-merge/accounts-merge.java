class Solution {
        static class UnionAccount{
        int[] parent ;
        UnionAccount(int n ){
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int findParent(int i){
            if(parent[i]!=i){
                 parent[i]=findParent(parent[i]);
            }
            return parent[i];
        }

        public void unionParents(int i , int j){
            int one = findParent(i);
            int two = findParent(j);
            parent[two]=one;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
         HashMap<String, Integer> map = new HashMap<>();
        UnionAccount uc = new UnionAccount(accounts.size());
        int level=0;
        for(List<String> acct : accounts){
            for(int i=1;i<acct.size();i++){
                 String email = acct.get(i);
                if(map.containsKey(email)){
                    uc.unionParents(map.get(email),level);
                }
                else{
                    map.put(email,level);
                }
            }
            level++;
        }
        List<List<String>> result = new ArrayList<>();
        HashMap<Integer,TreeSet<String>> fmap = new HashMap<>();
        for(int i=0;i<uc.parent.length;i++){
            int root = uc.findParent(i);
            fmap.putIfAbsent(root, new TreeSet<>());
            for(int j=1 ; j<accounts.get(i).size();j++){
              fmap.get(root).add(accounts.get(i).get(j));
            }

        }

        for(Map.Entry<Integer,TreeSet<String>> set : fmap.entrySet()){
            List<String> subList = new ArrayList<>();
            subList.add(accounts.get(set.getKey()).get(0));
            subList.addAll(set.getValue());
            result.add(subList);
        }

        return result;
    }
}